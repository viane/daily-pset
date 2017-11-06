import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++){
            set.add(nums2[i]);
        }
        TreeSet sortedSet = new TreeSet<Integer>(set);

        Object[] objArray = sortedSet.toArray();

        int size = objArray.length;
        if (size%2!=0) {
            return ((int) objArray[size / 2]);
        }else{
            return ((int)(objArray[size/2]) + ((int)objArray[size/2+1])/2);
        }
    }
}
