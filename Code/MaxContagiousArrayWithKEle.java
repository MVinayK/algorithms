import java.util.HashMap;
import java.util.Map;

public class MaxContagiousArrayWithKEle {


    public int calculateMaxContagiousSubArrayWithKElements(int[] arr) {
        int max = Integer.MIN_VALUE;
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
      //  {1, 2, 1, 2, 5, 3, 3,3,3}
        while(j < arr.length) {

            if(map.size() <= 2) {
               map.put(arr[j], j++); //put the value with the index 
            }

            if(map.size() > 2) {
                min = Integer.MAX_VALUE;
                for(Integer val : map.values()) { //iterating with values as they denote the index
                    min = Math.min(min, val);
                }
                i = min + 1;
                map.remove(arr[min]);
            }

            max = Math.max(max, j - i);
            
        }

        return max;
    }

}