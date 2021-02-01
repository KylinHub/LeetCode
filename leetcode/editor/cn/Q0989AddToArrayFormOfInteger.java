//对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。 
//
// 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = [1,2,0,0], K = 34
//输出：[1,2,3,4]
//解释：1200 + 34 = 1234
// 
//
// 示例 2： 
//
// 输入：A = [2,7,4], K = 181
//输出：[4,5,5]
//解释：274 + 181 = 455
// 
//
// 示例 3： 
//
// 输入：A = [2,1,5], K = 806
//输出：[1,0,2,1]
//解释：215 + 806 = 1021
// 
//
// 示例 4： 
//
// 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
//输出：[1,0,0,0,0,0,0,0,0,0,0]
//解释：9999999999 + 1 = 10000000000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 0 <= A[i] <= 9 
// 0 <= K <= 10000 
// 如果 A.length > 1，那么 A[0] != 0 
// 
// Related Topics 数组 
// 👍 120 👎 0


import java.util.LinkedList;
import java.util.List;

/**
 * @author KylinHub
 */
public class Q0989AddToArrayFormOfInteger {
    public static void main(String[] args) {
        Solution solution = new Q0989AddToArrayFormOfInteger().new Solution();

        List<Integer> result1 = solution.addToArrayForm(new int[]{1, 2, 0, 0}, 34);
        System.out.println(result1);
        List<Integer> result2 = solution.addToArrayForm(new int[]{2, 7, 4}, 181);
        System.out.println(result2);
        List<Integer> result3 = solution.addToArrayForm(new int[]{2, 1, 5}, 806);
        System.out.println(result3);
        List<Integer> result4 = solution.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1);
        System.out.println(result4);
        List<Integer> result5 = solution.addToArrayForm(new int[]{1}, 99999999);
        System.out.println(result5);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> addToArrayForm(int[] A, int K) {
            int[] kvals = new int[String.valueOf(K).length()];
            int max=Math.max(A.length,kvals.length)+1;
            int []res=new int[max];
            for (int i = kvals.length - 1; i >= 0; i--) {
                kvals[i] = K % 10;
                K=K/10;
            }
            int i=0;
            for (; i < A.length && i < kvals.length; i++) {
                int aindex = A.length - 1 - i;
                int kindex = kvals.length - 1 - i;
                int val = A[aindex] + kvals[kindex]+res[max-i-1];
                res[max-i-1] = val % 10;
                res[max-i-2] = res[max-i-2] + val / 10;
            }
            if(i<A.length){
                for(;i<A.length;i++){
                    int aindex = A.length - 1 - i;
                    int value=A[aindex]+res[max-i-1];
                    res[max-i-1]=value%10;
                    res[max-i-2]=value/10+res[max-i-2];
                }
            }
            if(i<kvals.length){
                for(;i<kvals.length;i++){
                    int kindex=kvals.length-1-i;
                    int value=kvals[kindex]+res[max-i-1];
                    res[max-i-1]=value%10;
                    res[max-i-2]=value/10+res[max-i-2];
                }
            }

            List<Integer>list=new LinkedList<>();
            if(res[0]!=0){
                list.add(res[0]);
            }
            for(int j=1;j<res.length;j++){
                list.add(res[j]);
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)1

}