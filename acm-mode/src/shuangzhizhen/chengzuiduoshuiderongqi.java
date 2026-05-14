package shuangzhizhen;

public class chengzuiduoshuiderongqi {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(findanswer(height));
    }

    public static int findanswer(int[] heights){
        int left = 0;
        int right = heights.length - 1;
        int res = 0;
        while (left < right){
            int height = Math.min(heights[left],heights[right]);
            int width = right - left;
            res = Math.max(res,height * width);
            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }

}
