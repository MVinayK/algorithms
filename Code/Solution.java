import java.util.*;

public class Solution {
    public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> resArr = new ArrayList<>();
        ArrayList<Integer> tempArr = new ArrayList<>();
        tempArr.add(1);
        
        for(int i = 2; i <=A ; i++) {
            for(int j = 0; j < i ; j++) {
                int lIndexVal = (j - 1) < 0 ? 0 : tempArr.get(j-1);
                int rIndexValue = getRArrayValue(j, tempArr);
                resArr.add(lIndexVal + rIndexValue);
            }
            tempArr = null;
            tempArr = resArr;
            resArr = new ArrayList<>();
        }
        

        return tempArr;
    }

    private int getRArrayValue(int index, ArrayList<Integer> tempArr) {
        int res = 0;
        if(index < tempArr.size()) {
            res = tempArr.get(index);
        } else {
            return 0;
        }
        return res;
    }
}