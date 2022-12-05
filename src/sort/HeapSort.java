package sort;

import java.util.Arrays;

/**
 * @author 86184
 * @date 2022-11-2022/11/6-18:15
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[200];
        for (int j = 0; j < 1000; j++) {

            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int)(Math.random()*100000);
            }
            FastSort.fastSort(arr,0,arr.length-1);
            if(!judge(arr)){
                System.out.println(1);
                break;
            }

        }

    }
    public static boolean judge(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            if( arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void heapSort(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            heapInsert(arr,i);
        }
        int heapSize = len;
        swap(arr,0,--heapSize);
        while(heapSize>1){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }
    public static void heapify(int[] arr,int index,int heapSize){
        int left = index*2+1;
        //结束条件 无左子节点
        while(left < heapSize){
            //取大的下标
            int large = left+1 < heapSize &&arr[left] < arr[left+1] ? left+1: left;
            //比较 迭代
            if(arr[index] < arr[large]){
                swap(arr,index,large);
                index = large;
                left = index*2+1;
            }else {
                break;
            }

        }

    }
    public static void heapInsert(int[] arr ,int heapSize){
        //当前位置
        int index = heapSize;
        while(arr[index] > arr[(index-1)/2]){
            //交换
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }
    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
