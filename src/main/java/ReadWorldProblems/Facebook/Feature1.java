package ReadWorldProblems.Facebook;


/*Find all people who are in friend circles
 * A friend circle is all people who are directly or indirectly connected
 *  */

import java.util.Arrays;

public class Feature1 {


    public static void main(String args[]) {
        int n = 4;//Total users

        //Adjacency matrix of whole Facebook
        boolean[][] friends = {
                {true, true, false, false},
                {true, true, true, false},
                {false, true, true, false},
                {false, false, false, true}
        };
        System.out.println("Number of friends circles: " + friendCircles(friends, n));
    }

    private static int friendCircles(boolean[][] friends, int n) {
        if (n == 0) {
            return 0;
        }

        boolean[] visited = new boolean[n];
        int totalFriendCircles = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(friends, visited, n, i);
                totalFriendCircles++;
            }
        }
        return totalFriendCircles;
    }

    private static void dfs(boolean[][] friends,boolean[] visited, int n, int v) {
        for (int i = 0; i < n; i++) {
           if(i!=v&&friends[v][i]&&!visited[i]){
               visited[i]=true;
               dfs(friends, visited, n, i);
           }
        }
    }

}
