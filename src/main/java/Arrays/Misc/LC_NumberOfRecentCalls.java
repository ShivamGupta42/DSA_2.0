package Arrays.Misc;

public class LC_NumberOfRecentCalls {


    int[] hits;
    int[] times;

    public LC_NumberOfRecentCalls() {
        hits = new int[3000];
        times = new int[3000];
    }

    public int ping(int t) {
        int n = t % 3000;

        if (times[n] == 0) {
            hits[n] = 1;
            return getHits(t);
        } else if (times[n] == t) {
            hits[n]++;
            return getHits(t);

        } else {
            int oldHits = times[n];
            times[n] = t;
            hits[n] = 1;
            return oldHits + getHits(t);
        }

    }

    public int getHits(int t) {
        int sum = 0;
        for (int i = 0; i <= 3000; i++) {
            if (t - times[i] <= 3000) {
                sum += hits[i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        LC_NumberOfRecentCalls calls = new LC_NumberOfRecentCalls();
        System.out.println(calls.getHits(1));
        System.out.println(calls.getHits(100));
        System.out.println(calls.getHits(3001));
        System.out.println(calls.getHits(3002));
    }


}


