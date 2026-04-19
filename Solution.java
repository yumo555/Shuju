public class Solution {
    // 核心方法：合并两个有序数组，结果存放在nums1中
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 指针i：指向nums1最后一个有效元素的位置
        int i = m - 1;
        // 指针j：指向nums2最后一个元素的位置
        int j = n - 1;
        // 指针k：指向nums1最终要填充的最后一个位置（总长度-1）
        int k = m + n - 1;

        // 循环条件：两个数组都还有未处理的元素
        while (i >= 0 && j >= 0) {
            // 比较两个指针指向的元素，将较大的放到nums1的k位置
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--; // nums1的指针左移，处理前一个元素
            } else {
                nums1[k] = nums2[j];
                j--; // nums2的指针左移，处理前一个元素
            }
            k--; // 填充位置指针左移，准备下一次赋值
        }

        // 处理nums2中剩余的元素（若nums1先遍历完）
        // 若nums2先遍历完，则nums1剩余元素已在正确位置，无需处理
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    // 主方法：用于测试例题
    public static void main(String[] args) {
        // 例题输入
        int[] nums1 = {1, 2, 3, 0, 0, 0}; // 前3个为有效元素，后3个为占位0
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        Solution solution = new Solution();
        solution.merge(nums1, m, nums2, n);

        // 输出合并后的结果
        System.out.print("合并结果：");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        // 输出：合并结果：1 2 2 3 5 6
    }
}
