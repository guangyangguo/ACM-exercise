package meiriyiti._26year08month;

public class q3345zuixiaokezhengchushuweichengji1 {

    public static void main(String[] args) {
        System.out.println(smallestNumber(10, 2));
        System.out.println(smallestNumber(15, 3));
    }

    public static int smallestNumber(int n, int t) {
        if(t == 1){
            return n;
        }
        int curr = n;
        while(true){
            int ji = getji(curr);
            if(ji % t == 0){
                return curr;
            }
            curr++;
        }
    }
    public static int getji(int n){
        int ji = 1;
        while(n > 0){
            ji *= n % 10;
            n /= 10;
        }
        return ji;
    }
}
