import java.util.Arrays;

public class PythagorasTheorem {


    public void solve(int[] arr) {

        for (int i =0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }

        Arrays.sort(arr);

        for(int i = arr.length - 1; i > 1; i--) {

            int l = 0;
            int r = i - 1;

            while(l < r && r < i) {

                if(arr[i] == arr[l] + arr[r]) {
                    System.out.println(arr[i] + " " + arr[l] + " " + arr[r]);
                }

                if(arr[i] > arr[l] + arr[r]) {
                    l++;
                } else {
                    r--;
                }
            }

        }

    }

    private void print(int[] arr) {
        for (int i =0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}