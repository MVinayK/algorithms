

class BinarySearch {

    public static void main(String[] arr) {
        int[] array = new int[]{1, 3, 4, 8, 10, 14, 17, 18, 24};
        int[] array2 = new int[]{3, 4, 5, 6, 7, 8, 1, 2};
        //System.out.println(binarySearch(array, 1, 0, array.length - 1));
        //System.out.println(binarySearchRecur(array, 19, 0, array.length - 1));
        //System.out.println(findMinInSortedRotatedArr(array2, 0, array2.length - 1));
        int[] array3 = new int[]{1, 2, 10, 11, 12, 4};
        System.out.println(findPeak(array3, 0, array3.length - 1));

    }

    private static boolean binarySearchRecur(int[] arr, int value, int start, int end) {

        if(start > end) {
            return false;
        }

        int mid  =  start + ((end - start) / 2);
        
        if(arr[mid] == value) {
            return true;
        }

        if(value < arr[mid]) {
            return binarySearch(arr, value, start, mid - 1);
        } else {
            return binarySearch(arr, value, mid + 1, end);
        }

    }

    private static boolean binarySearch(int[] arr, int value, int start, int end) {

        while(start <= end) {
            int mid  =  start + ((end - start) / 2);
        
            if(arr[mid] == value) {
                return true;
            }

            if(value < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }


    /**
    * This below one is a tough one
    */
    private static int findMinInSortedRotatedArr(int[] arr, int start, int end) {

        if(start > end) {
            return -1;
        }

        if(start == end) {
            return arr[start];
        }

        int mid = start + (end - start)/2;

        if(arr[mid] > arr[mid+1]) {
            return arr[mid+1];
        }

        if(arr[mid] < arr[mid - 1]) {
            return arr[mid];
        }

        //the below line decides which side to go for the search
        if(arr[end] > arr[mid]) { // --> this dude here is the toughest hint to figure out 
            return findMinInSortedRotatedArr(arr, start, mid - 1);
        } else {
            return findMinInSortedRotatedArr(arr, mid + 1, end);
        }
    }

    private static int findPeak(int[] arr, int start, int end) {

        // boundary conditions

        if(start > end) {
            return -1;
        }

        if(start == end) {
            return arr[start];
        }

        //main check
        int mid = start + (end - start)/2;

        if(arr[mid-1] < arr[mid] &&  arr[mid] > arr[mid + 1]) {
            return arr[mid];
        }

        //go either left or right 
        if(arr[mid] > arr[end]) {
            //go left
            return findPeak(arr, mid + 1, end);
        } else {
            return findPeak(arr, start, mid - 1);
        }

    }

}