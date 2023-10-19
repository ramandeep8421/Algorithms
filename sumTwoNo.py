class Solution:
    def getSum(self, a, b):
        while b != 0:
            c = (a & b) << 1
            a = (a ^ b)
            b = c

        return a
