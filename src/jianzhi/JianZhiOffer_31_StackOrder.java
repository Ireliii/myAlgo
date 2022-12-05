package jianzhi;

import java.util.Stack;

/**
 * @author 86184
 * @date 2022-11-2022/11/2-14:38
 */
public class JianZhiOffer_31_StackOrder {
    public static boolean whether(int[] pushed,int[] popped){
        Stack<Integer> stack = new Stack<>();
        int length = pushed.length;
        int j = 0;
        for (int i = 0; i < length; i++) {
            if(pushed[i] == popped[j]){
                j++;
                continue;
            }
            stack.push(pushed[i]);
        }
        boolean result = true;
        while(!stack.isEmpty()){
            result = stack.pop() == popped[j++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {2,1,0};
        int[] b = {1,2,0};
        System.out.println(whether(a,b));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

//    作者：jyd
//    链接：https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/solution/mian-shi-ti-31-zhan-de-ya-ru-dan-chu-xu-lie-mo-n-2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
