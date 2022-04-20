package leetcode.editor.cn.sort;

public class kuaiSort {
    public static void main(String[] args) {
        int[] arr={2,4,9,3,5,10,8,1};
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if(L>R){
            return;
        }
        int i=L;
        int j=R;
        int temp=arr[i];

        while (i<j){
//先看右边，依次往左递减
            while (arr[j]>=temp&&i<j){
                j--;
            }
            //再看左边，依次往右递增
            while (arr[i]<=temp&&i<j){
                i++;
            }


            if(i<j){
                int tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
            }
        }

        arr[L]=arr[i];
        arr[i]=temp;
        quickSort(arr,L,i-1);
        quickSort(arr,i+1,R);


    }
}
