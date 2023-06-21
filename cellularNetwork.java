import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    // returns the first index in the list that is >= value, or list.size() if no such index exists
    static int firstAtLeast(List<Integer> list, int value) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) >= value)
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> cities = new ArrayList<>();
        List<Integer> towers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int city = sc.nextInt();
            cities.add(city);
        }

        for (int i = 0; i < m; i++) {
            int tower = sc.nextInt();
            towers.add(tower);
        }

        int minR = 0;
        for (int i = 0; i < n; i++) {
            int towerRight = firstAtLeast(towers, cities.get(i));
            int towerLeft = towerRight - 1;

            int minRForThisCity = 2_000_000_000;
            if (towerRight < m) {
                assert towers.get(towerRight) >= cities.get(i);
                minRForThisCity = Math.min(minRForThisCity, towers.get(towerRight) - cities.get(i));
            }
            if (towerLeft >= 0) {
                assert towers.get(towerLeft) <= cities.get(i);
                minRForThisCity = Math.min(minRForThisCity, cities.get(i) - towers.get(towerLeft));
            }

            minR = Math.max(minR, minRForThisCity);
        }

        System.out.println(minR);
    }
}
