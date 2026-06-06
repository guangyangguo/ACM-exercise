package meiriyiti._26year05month;

import java.util.Arrays;

public class q2126cuihuixiaoxingxing {

    public static void main(String[] args) {
        int[] asteroids = {3,9,19,5,21};
        System.out.println(asteroidsDestroyed(10, asteroids));
    }


    /*
    * 第一个直觉的解法，注意用long
    * */
    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long res = mass;
        Arrays.sort(asteroids);
        for (int i = 0; i < asteroids.length; i++) {
            if (mass < asteroids[i]){
                return false;
            }
            res += asteroids[i];
        }
        return true;
    }

}
