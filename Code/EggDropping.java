class EggDropping {

    public void calculateNofWays(int totalFloors, int totalEggs) {

        int[][] memo = new int[totalFloors+1][totalEggs+1];

        for(int row = 1; row < totalFloors+1 ; row++) {
            for(int col = 1; col < totalEggs+1; col++) {
                memo[row][col] = -1;
            }
        }
        System.out.println("Memo : " + noOfWays(totalFloors, totalEggs, memo));
        System.out.println( "Recur : " +  noOfWaysRecur(totalFloors, totalEggs));
    }

    private int noOfWays(int floors, int eggs, int[][] memo) {

        int x , res;
        int min = Integer.MAX_VALUE;

        if(eggs == 1) {
            return floors;
        }

        if(floors == 0 || floors == 1) {
            return floors;
        }

        for(x = 1; x <= floors; x++) {
            if(memo[x][eggs] != -1 ) {
                res = memo[x][eggs];
            } else {
                memo[x-1][eggs-1] = noOfWays(x - 1, eggs - 1, memo);
                memo[floors - x][eggs] = noOfWays(floors - x, eggs, memo);
            }
            res = Math.max(memo[x-1][eggs-1] , memo[floors - x][eggs]);
            if(res < min) {
                min = res;
                memo[x][eggs] = min;
            }
        }
        return min + 1;
    }

    private int noOfWaysRecur(int floors, int eggs) {

        int x , res;
        int min = Integer.MAX_VALUE;

        if(eggs == 1) {
            return floors;
        }

        if(floors == 0 || floors == 1) {
            return floors;
        }

        for(x = 1; x <= floors; x++) {
            res = Math.max(noOfWaysRecur(x - 1, eggs - 1), noOfWaysRecur(floors - x, eggs));
            if(res < min) {
                min = res;
            }
        }
        return min + 1;
    }

}