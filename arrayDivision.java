import java.util.*;

class Solution {
    public boolean isValid(List<Integer> a, int k, int mid) {
        int groups = 0;
        int sum = 0;
        int n = a.size();

        for (int i = 0; i < n; i++) {
            if (a.get(i) > mid)
                return false;

            if (sum + a.get(i) > mid) {
                groups++;
                sum = 0;
            }
            sum += a.get(i);
        }

        if (sum > 0)
            groups++;

        return groups <= k;
    }

    public int arrayDivision(List<Integer> a, int k) {
        int lo = 0;
        int hi = 0;
        int ans = 0;

        for (int num : a)
            hi += num;

        while (lo <= hi) {
            int mid = (hi + lo) / 2;

            if (isValid(a, k, mid)) {
                hi = mid - 1;
                ans = mid;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++)
            a.add(scanner.nextInt());

        System.out.println(obj.arrayDivision(a, k));
    }
}
