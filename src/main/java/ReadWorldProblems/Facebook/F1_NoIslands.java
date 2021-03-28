package ReadWorldProblems.Facebook;

public class F1_NoIslands {

    public static int numIslands(String[][] islands) {

        int numIslands = 0;

        for (int i = 0; i < islands.length; i++) {
            for (int j = 0; j < islands[0].length; j++) {

                if (islands[i][j].equals("1")) {
                    sinkConnectedIslands(islands, i, j);
                    numIslands++;
                }

            }
        }

        return numIslands;
    }

    public static void sinkConnectedIslands(String[][] islands, int i, int j) {
        if (islands == null || i < 0 || j < 0 || i >= islands.length || j >= islands[0].length) {
            return;
        }

        if (islands[i][j].equals("0")) {
            return;
        }

        islands[i][j] = "0";

        //left
        if (j - 1 >= 0) {
            sinkConnectedIslands(islands, i, j - 1);
        }

        //right
        if (j + 1 < islands[0].length) {
            sinkConnectedIslands(islands, i, j + 1);
        }

        //up
        if (i - 1 >= 0) {
            sinkConnectedIslands(islands, i - 1, j);
        }

        //down
        if (i + 1 < islands.length) {
            sinkConnectedIslands(islands, i + 1, j);
        }

    }

}
