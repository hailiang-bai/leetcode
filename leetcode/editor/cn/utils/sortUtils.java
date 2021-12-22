package leetcode.editor.cn.utils;

public class sortUtils {
    public static void swap(int[] arr , int a , int b){
        int temp;
        temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void pprint(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i]+" ");
        }
    }
}
