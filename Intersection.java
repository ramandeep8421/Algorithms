import java.util.*;

class Solution {
    public List<Integer> intersection(int[] nums1, int[] nums2) {
        // Convert arrays to lists
        List<Integer> list1 = new ArrayList<>();
        for (int num : nums1) {
            list1.add(num);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums2) {
            list2.add(num);
        }

        // Sort the lists
        Collections.sort(list1);
        Collections.sort(list2);

        List<Integer> res = new ArrayList<>();

        // Declare two pointers
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            // If the elements at i and j matches
            if (list1.get(i).equals(list2.get(j))) {
                if (res.size() == 0) {
                    res.add(list1.get(i));
                    i++;
                    j++;
                } else {
                    if (res.get(res.size() - 1).equals(list1.get(i))) {
                        i++;
                        j++;
                    } else {
                        res.add(list1.get(i));
                        i++;
                        j++;
                    }
                }
            } else { // If they don't match
                if (list1.get(i) < list2.get(j)) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[m];
        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            nums2[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        List<Integer> res = obj.intersection(nums1, nums2);
        for (int it : res) {
            System.out.print(it + " ");
        }
    }
}
