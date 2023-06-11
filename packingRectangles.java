 class Solution {
    public long max(long a, long b) {
        return (a > b) ? a : b;
    }

    public boolean isValid(long x, long h, long w, long n) {
        long a = (x / h);
        long b = (x / w);

        return (a * b) >= n;
    }

    public long minRectanglesInSquare(long h, long w, long n) {
        long l = 0, r = 1;

        while (!isValid(r, h, w, n)) {
            r *= 2;
        }

        while (l < r) {
            long mid = l + (r - l) / 2;

            if (isValid(mid, h, w, n)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
