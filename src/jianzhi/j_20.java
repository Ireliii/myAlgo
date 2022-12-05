package jianzhi;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 86184
 * @date 2022-11-2022/11/2-15:10
 */
public class j_20 {
    public static boolean w(String s){
        s = s.trim();
        char[] chars = s.toCharArray();
        int i = 0;
        boolean isI = false;
        if(chars[0] == '-'||chars[0] == '+'){
            isI = !isI;
            i++;
        }
        boolean e = false;
        boolean dot = false;
        for (; i < chars.length; i++) {
            if(chars[i] > '9' || chars[i]<'0'){

                if(isI){
                    if(i == 1 ){
                        return false;
                    }
                }else {
                    if(i == 0 ){
                        return false;
                    }
                }

                if(e){
                    if(dot){
                        return false;
                    }else {
                        if(chars[i] == '.'){
                            dot = !dot;
                            continue;
                        }else {
                            return false;
                        }
                    }
                }else{
                    if(chars[i] !='e'||chars[i] !='E'){
                        e = !e;
                        dot = true;
                        if(i+1 == chars.length){
                            return false;
                        }
                        if(chars[i+1] == '-'||chars[i+1] == '+'){
                            i++;
                            if(i+1 == chars.length){
                                return false;
                            }
                        }
                        continue;
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] s = {"12e", "1a3.14", "1.2.3", "+-5", "12e+5.4",".2"};
        for(String a:s){
            System.out.println(w(a));
        }
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
}
