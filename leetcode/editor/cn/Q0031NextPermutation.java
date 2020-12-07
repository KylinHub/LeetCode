//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 861 👎 0


/**
 * @author KylinHub
 */
public class Q0031NextPermutation {
    public static void main(String[] args) {
        Solution solution = new Q0031NextPermutation().new Solution();
        int[] nums = {1, 2, 3};
        solution.nextPermutation(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            // 查找最低位
            int i = nums.length - 1;
            for (; i >= 0; i--) {
                if (i == 0) {
                    break;
                }
                if (nums[i] > nums[i - 1]) {
                    break;
                }
            }

            // 如果不是最大（即各位数字呈倒序排列）
            int j;
            if (i != 0) {
                // 找到比i大的下一个数字
                int next = i;
                for (j = i; j < nums.length; j++) {
                    if (nums[next] > nums[j] && nums[j] > nums[i - 1]) {
                        next = j;
                    }
                }
                // 交换
                exchange(nums, i - 1, next);
            }
            // 升序排序位置i之后的数字
            for (int m = i; m < nums.length; m++) {
                for (int n = m + 1; n < nums.length; n++) {
                    if (nums[m] > nums[n]) {
                        exchange(nums, m, n);
                    }
                }
            }
        }

        void exchange(int[] nums, int idx1, int idx2) {
            nums[idx1] += nums[idx2];
            nums[idx2] = nums[idx1] - nums[idx2];
            nums[idx1] = nums[idx1] - nums[idx2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}