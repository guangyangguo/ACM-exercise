package meiriyiti._26year07month;

public class q3658jishuheyuoushuhedezuidagongyueshu {

    /*
    * 实际上这道题的答案就是return n;
    * */
    public static void main(String[] args) {
        System.out.println(gcdOfOddEvenSums(4));
        System.out.println(gcdOfOddEvenSums(5));
    }

    public static int gcdOfOddEvenSums(int n){
        int[] sum = getnum(n);
        return getgcd(sum[0],sum[1]);
    }
    public static int[] getnum(int n){
        int[] sum = new int[2];
        for(int i = 1;i <= 2 * n;i++){
            if(i % 2 != 0){
                sum[0] += i;
            }else{
                sum[1] += i;
            }
        }
        return sum;
    }
    public static int getgcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
