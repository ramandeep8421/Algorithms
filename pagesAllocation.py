class Solution:
    
    def isValid(self, books, curr_min, m):
        run_sum = 0
        students = 1

        for it in books:
            if it > curr_min:
                return False

            if run_sum + it > curr_min:
                students += 1
                run_sum = it

                if students > m:
                    return False
            else:
                run_sum += it

        return True

    def minimumPagesAllocation(self, books, m):
        n = len(books)

        if n > m:
            return -1

        lo = 0
        hi = 0

        for it in books:
            hi += it

        ans = -1

        while lo <= hi:
            mid = lo + (hi - lo) // 2

            if self.isValid(books, mid, m):
                ans = mid
                hi = mid - 1
            else:
                lo = mid + 1

        return ans
