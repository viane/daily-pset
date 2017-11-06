

public class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] nums1 = {1,3,7};
        int[] nums2 = {2,4};
        double ans = sol.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median of [1,3,7] and [2,4] is " + ans);

    }

}
