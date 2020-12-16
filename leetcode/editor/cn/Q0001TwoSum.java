//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9775 👎 0


import java.util.HashMap;
import java.util.Map;

/**
 * @author KylinHub
 */
public class Q0001TwoSum {
    public static void main(String[] args) {
        Solution solution = new Q0001TwoSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
        int[] r = {};
        out:
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if(j == i) {
                    continue;
                }
                int b = nums[j];
                if ((a + b) == target) {
                    r = new int[]{i, j};
                    break out;
                }
            }
        }
        return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}