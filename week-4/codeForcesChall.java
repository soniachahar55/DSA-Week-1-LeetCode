1)  https://codeforces.com/contest/1593/problem/B
import java.util.*;
public class Main {
    static int solve(String s, String target) {
        int n = s.length();
        int j = target.length() - 1; 
        int deletions = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == target.charAt(j)) {
                j--;
                if (j < 0) return deletions; // found whole suffix
            } else {
                deletions++; // remove this digit
            }
        }
        return (int)1e9; // impossible (won't happen as per problem guarantee)
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

Q2)problem link- https://codeforces.com/contest/1679/problem/A
Sol- import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine().trim());

            // Impossible cases
            if (n < 4 || (n & 1) == 1) {
                out.append(-1).append('\n');
                continue;
            }

            long minBuses = (n + 5) / 6; // ceil(n/6)
            long maxBuses = n / 4;

            if (minBuses > maxBuses) {
                out.append(-1).append('\n');
            } else {
                out.append(minBuses).append(" ").append(maxBuses).append('\n');
            }
        }

        System.out.print(out.toString());
    }
}

Q3)problem link- https://codeforces.com/contest/1593/problem/B
Sol-
 import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s = br.readLine().trim();
            int n = s.length();

            String[] targets = {"00", "25", "50", "75"};
            int ans = Integer.MAX_VALUE;

            for (String tar : targets) {
                char b = tar.charAt(1); // last digit
                char a = tar.charAt(0); // second last digit

                int posB = -1;
                // find last digit from right
                for (int i = n - 1; i >= 0; i--) {
                    if (s.charAt(i) == b) {
                        posB = i;
                        break;
                    }
                }

                if (posB == -1) continue;

                int posA = -1;
                // find second last digit to the left of posB
                for (int i = posB - 1; i >= 0; i--) {
                    if (s.charAt(i) == a) {
                        posA = i;
                        break;
                    }
                }

                if (posA == -1) continue;

                int deletions = n - (posA + 2);
                ans = Math.min(ans, deletions);
            }

            out.append(ans).append('\n');
        }

        System.out.print(out.toString());
    }
}

Q4)Problem link :https://codeforces.com/problemset/problem/1829/B
import java.util.*;
public class blankspace {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
          int blank=count(arr);
            System.out.println(blank);
        }
    }
    static int count(int[]arr){
        int n=arr.length;
        int max=0;
        int c=0;
        for(int i=0;i<n;i++){
            if (arr[i]!=1) {
                c++;
                max=Math.max(max, c);
            } else {
                c=0;
            }
        }
        return max;
    }
}

Q5)problem link-https://codeforces.com/problemset/problem/1850/D
Sol- import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long k = fs.nextLong();
            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = fs.nextLong();
            }

            Arrays.sort(a);

            int best = 1;
            int curr = 1;

            for (int i = 1; i < n; i++) {
                if (a[i] - a[i - 1] <= k) {
                    curr++;
                } else {
                    curr = 1;
                }
                best = Math.max(best, curr);
            }

            int answer = n - best;
            out.append(answer).append('\n');
        }

        System.out.print(out.toString());
    }

    // Fast input for Codeforces
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = readByte()) <= ' ') {
                if (c == -1) return -1;
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = readByte();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        long nextLong() throws IOException {
            int c;
            while ((c = readByte()) <= ' ') {
                if (c == -1) return -1;
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = readByte();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }
}

Q6)problem link- https://codeforces.com/problemset/problem/1878/A
Sol- import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            boolean found = false;

            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == k) found = true;
            }

            out.append(found ? "YES" : "NO").append('\n');
        }

        System.out.print(out.toString());
    }
}

