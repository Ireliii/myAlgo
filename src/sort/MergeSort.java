package sort;

/**
 * @author 86184
 * @date 2022-11-2022/11/7-21:22
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        mergeSort(arr,0,arr.length-1);
    }

    public static void merge(int[] arr,int l,int r){
        int mid = l + ((r-l)>>1);
        int index = 0;
        int[] help = new int[r-l+1];
        int left = l;
        int right = mid+1;
        while(left <= mid && right <= r){
            help[index++] = arr[left]>arr[right]?arr[right++]:arr[left++];
        }
        while(left <= mid){
            help[index++] = arr[left++];
        }
        while(right <= r){
            help[index++] = arr[right++];
        }
        left = l;
        for (int i = 0; i < r - l + 1; i++) {
            arr[left++] = help[i];
        }
    }
    public static void mergeSort(int[] arr, int l, int r){
        //结束条件
        if(r<=l){
            return;
        }
        int mid = l + ((r-l)>>1);

        mergeSort(arr,l,mid);                     //排好左边
        mergeSort(arr,mid+1,r);                 //排好右边

        merge(arr,l,r);                          //得到两个有序数组 排好自己

    }
}
