1) B. Make it Divisible by 25

 question Link: https://codeforces.com/contest/1593/problem/B

import java.util.*;

public class Main {

    static int solve(String s, String target) {
        int n = s.length();
        int j = target.length() - 1; 
        int deletions = 0;


        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == target.charAt(j)) {
                j--;
                if (j < 0) return deletions; 
            } else {
                deletions++;
            }
        }
        return (int)1e9; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String n = sc.next();

            
            int ans = Integer.MAX_VALUE;

            ans = Math.min(ans, solve(n, "00"));
            ans = Math.min(ans, solve(n, "25"));
            ans = Math.min(ans, solve(n, "50"));
            ans = Math.min(ans, solve(n, "75"));

            System.out.println(ans);
        }
    }
}

--
