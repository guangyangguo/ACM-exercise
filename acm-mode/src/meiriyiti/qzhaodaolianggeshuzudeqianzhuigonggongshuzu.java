package meiriyiti;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class qzhaodaolianggeshuzudeqianzhuigonggongshuzu {

    public static void main(String[] args) {
        int[] A = {1,3,2,4};
        int[] B = {3,1,2,4};
        int[] res = findThePrefixCommonArray(A, B);
        System.out.println(Arrays.toString( res));
    }

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        //记录A出现了哪些数
        Set<Integer> cntA = new HashSet<>();
        //记录B出现了哪些数
        Set<Integer> cntB = new HashSet<>();
        //两边都出现的数字
        Set<Integer> cnt = new HashSet<>();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            cntA.add(A[i]);
            cntB.add(B[i]);
            if (cntB.contains(A[i])) {
                cnt.add(A[i]);
            }
            if (cntA.contains(B[i])) {
                cnt.add(B[i]);
            }
            ans[i] = cnt.size();
        }
        return ans;
    }
}
