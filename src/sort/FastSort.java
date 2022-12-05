package sort;

import java.util.Arrays;

/**
 *              1  1  2 4  3
 * @author 86184
 * @date 2022-11-2022/11/7-21:21
 */
public class FastSort {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4};
        fastSort(arr,0,3);
        System.out.println(Arrays.toString(arr));
    }

    public static void fastSort(int[] arr,int l ,int r){
        if(l>=r)
            return;
        int value = arr[l+((r-l)>>1)];
        //小的放左边
        //大的放右边
        int cur = l;
        int left = l;
        int right = r;
        while(cur<=right){
            if(arr[cur] < value){
                int temp = arr[left];
                arr[left] = arr[cur];
                arr[cur] = temp;
                left++;cur++;
            }else if(arr[cur] > value){
                int temp = arr[right];
                arr[right] = arr[cur];
                arr[cur] = temp;
                right--;
            }else {
                cur++;
            }
        }

        fastSort(arr,l,left-1);
        fastSort(arr,right+1,r);
    }

}
