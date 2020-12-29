

class Lis {

    public static void main(String[] arr) {
        lis(new int[]{10, 7, 8, 2, 5, 6});
    }


    private static void lis(int[] arr) {

        int[] lisArr = new int[arr.length];
        int max = 1;
        for(int i = 0; i < arr.length; i++) {
            lisArr[i] = 1;
        }

        for(int i = 1; i < arr.length; i++) { //her the j to i is the sub array or sub problem that we are trying to solve
            
            for(int j = 0; j < i; j++){// For each element in i consider starting from begining 

                if(arr[i] > arr[j] && lisArr[i] < lisArr[j] + 1) {
                    lisArr[i]++;
                }
            }

        }

        for(int i = 0; i < arr.length; i++) {
            if(lisArr[i] > max) {
                max = lisArr[i];
            }
        }

        System.out.println("LIS :: " + max);

    }

}