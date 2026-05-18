package meiriyiti;

public class q153xunzhaoxuanzhuanpaixuzhuzuzhongdezuixiaozhi {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findanswer(nums));
    }

    public static int findanswer(int[] nums){
        if (nums.length == 1){
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            //这里要顺着思路实现，如果中间的数比右边的数大，说明最小值在右边
            //！！！不要写成if(nums[mid] > nums[left]),然后说明最小值在右边！！！
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }

}
