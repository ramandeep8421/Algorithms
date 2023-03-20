class Solution:
    def maxArea(self, height: List[int]) -> int:
        # Find the size of the array
        n = len(height)

        # Initialize two pointers i and j
        # i with first index and j with last index
        i, j = 0, n - 1

        # Answer variable to store the final answer
        answer = 0

        while i < j:
            # Find the height of the container
            h = min(height[i], height[j])

            # Find the area of the container
            area = h * (j - i)

            # Update the answer
            answer = max(answer, area)

            # If height at index i is greater than the height at index j
            if height[i] > height[j]:
                j -= 1
            else:
                i += 1

        return answer
