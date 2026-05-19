package meiriyiti;

public class q2540zuixiaogongongzhi {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4};
        System.out.println(getCommon(nums1,nums2));
    }


    /*
    * 简单题，双指针实现
    * */
    public static int getCommon(int[] nums1,int[] nums2){
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length){
            if (nums1[index1] == nums2[index2]){
                return nums1[index1];
            }
            if (nums1[index1] < nums2[index2]){
                index1++;
            }else {
                index2++;
            }
        }
        return -1;
    }
}
