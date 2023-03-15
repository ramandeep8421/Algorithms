from typing import List

class Solution:

    def merge(self, arr: List[int], left: int, mid: int, right: int, answer: List[int]) -> None:
        # Size of the left array
        n = mid - left + 1

        # Size of the right array
        m = right - mid

        # Declare the left and right arrays
        l = [0] * n
        r = [0] * m

        # Pointers to store elements in the arrays
        for i in range(n):
            l[i] = arr[left + i]
        for i in range(m):
            r[i] = arr[mid + 1 + i]

        # Declare pointers to both the arrays
        i = 0
        j = 0
        k = left

        # Pointers to iterate over the arrays and prepare the final array arr
        while i < n and j < m:

            # If the element at ith location of l is less than the jth location of r
            # then, assign arr[i] at index k
            if l[i] <= r[j]:
                arr[k] = l[i]
                i += 1
            # Otherwise assign arr[j] at the kth index
            else:
                arr[k] = r[j]
                # Here, we know that we have (n-i) inversions at index i
                answer[0] += (n - i)
                j += 1
            k += 1

        # Copy remaining elements of left array if any
        while i < n:
            arr[k] = l[i]
            i += 1
            k += 1

        # Copy remaining elements of right array if any
        while j < m:
            arr[k] = r[j]
            j += 1
            k += 1

    def mergeSort(self, arr: List[int], left: int, right: int, answer: List[int]) -> None:
        # Base condition
        if left >= right:
            return

        # Find the middle point
        mid = left + (right - left) // 2

        # Sort the left part
        self.mergeSort(arr, left, mid, answer)

        # Sort the right part
        self.mergeSort(arr, mid + 1, right, answer)

        # Merge the two parts of the array
        self.merge(arr, left, mid, right, answer)

    def countInversions(self, arr: List[int]) -> int:
        # Initialize the answer variable
        answer = [0]

        # Call the mergeSort Function to call for the final answer
        self.mergeSort(arr, 0, len(arr) - 1, answer)

        # Return the answer from here
        return answer[0]
