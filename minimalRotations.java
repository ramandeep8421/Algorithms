import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        s += s;
        int n = s.length();
        int i = 0;
        int ans = 0;

        while (i < n/2) {
            ans = i;
            int k = i, j = i + 1;

            while (j < n && s.charAt(j) >= s.charAt(k)) {
                if (s.charAt(j) == s.charAt(k)) {
                    k++;
                } else if (s.charAt(j) > s.charAt(k)) {
                    k = i;
                }
                j++;
            }

            i += Math.max(1, j - k);
        }

        System.out.println(s.substring(ans, ans + n/2));
    }
}
