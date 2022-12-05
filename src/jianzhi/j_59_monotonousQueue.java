package jianzhi;

import java.util.*;

/**
 * @author 86184
 * @date 2022-11-2022/11/2-16:29
 */
public class j_59_monotonousQueue {
    public static int[] v(int[] nums,int k){
        int[] result = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while(!deque.isEmpty()&&nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.add(i);
        }
        result[0] = nums[deque.getFirst()];
        for (int i = k; i < nums.length; i++) {
            while(!deque.isEmpty()&&nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.add(i);
            if(deque.peekFirst()<i-k+1){
                deque.pollFirst();
            }
            result[i-k+1] = nums[deque.getFirst()];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {3,2, 4,1};
        int[] v = v(a, 2);
        System.out.println(Arrays.toString(v));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
//
//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/solution/hua-dong-chuang-kou-de-zui-da-zhi-by-lee-ymyo/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
