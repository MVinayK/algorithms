

class Kadane {


    public static void main(String arx[]) {

        int[] arr = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(runKadane(arr));
    }

    private static int runKadane(int[] arr) {

        int maxNow = -2555;
        int maxSoFar = -2555;

        for(int i = 0; i < arr.length; i++) {

            maxNow = arr[i] + maxNow;

            if(maxNow < arr[i]) {
                maxNow = arr[i];
            }

            if(maxNow > maxSoFar) {
                maxSoFar = maxNow;
            }

        }
        return maxSoFar;
    }
}