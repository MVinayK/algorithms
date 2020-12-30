import java.util.*;
import java.util.concurrent.*;

class MaxSumPath {


    public static void main(String arr[]) {

        int[][] array = getA2DArray(4, 5);
        System.out.println("The maximum sum path is :: " + findMaxPathSum(array));
        System.out.println("The minimum sum path is :: " + findMinPathSum(array));
    }

    /**
     * This is the problem which gives the maximum sum path
     */
    private static int findMaxPathSum(int[][] array) {
        int[][] dyna = new int[array.length][array[0].length];
        printArray(array);

        dyna[0][0] = array[0][0];
        for(int i = 1; i < array.length; i++) {
            dyna[i][0] = array[i][0] + dyna[i-1][0]; 
        }

        for(int j = 1; j < array[0].length; j++) {
            dyna[0][j] = array[0][j] + dyna[0][j - 1];
        }

        for(int i=1; i < array.length; i++) {
            for(int j=1; j < array[0].length; j++){
                dyna[i][j] = array[i][j] + Math.max(dyna[i][j-1], dyna[i-1][j]);
            }
        }

        return dyna[array.length - 1][array[0].length-1];
    }

    /**
     * This is the problem which gives the minimum path 
     */
    private static int findMinPathSum(int[][] array) {
        int[][] dyna = new int[array.length][array[0].length];
        printArray(array);

        dyna[0][0] = array[0][0];
        for(int i = 1; i < array.length; i++) {
            dyna[i][0] = array[i][0] + array[i-1][0]; 
        }

        for(int j = 1; j < array[0].length; j++) {
            dyna[0][j] = array[0][j] + array[0][j - 1];
        }

        for(int i=1; i < array.length; i++) {
            for(int j=1; j < array[0].length; j++){
                dyna[i][j] = array[i][j] + Math.min(dyna[i][j-1], dyna[i-1][j]);
            }
        }

        return array[array.length - 1][array[0].length-1];
    }


    private static int[][] getA2DArray(int row, int col) {
        
        int[][] array = new int[row][col];
        for(int i=0; i < row; i++) {
            for(int j=0; j < col; j++){
                array[i][j] = ThreadLocalRandom.current().nextInt(1, 20 + 1);
            }
        }

        return array;
    }

    private static void printArray(int[][] array) {
        for(int i=0; i < array.length; i++) {
            for(int j=0; j < array[0].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("****************************");
    }
}