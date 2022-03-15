package leetcode.editor.cn.test;

import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
//    }
//}
//class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int nextInt = sc.nextInt();
//        ArrayList<Integer> arr = new ArrayList<>();
//
//    }
//}


//class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int ans = 0, x;
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                x = sc.nextInt();
//                ans += x;
//            }
//        }
//        System.out.println(ans);
//    }
//}
//class Main {
//    static int time;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int  x;
//        int[] list = new int[n];
//        int res=0;
//        for (int i = 0; i < n; i++) {
//            x = sc.nextInt();
//            list[i]=x;
//        }
//        int result=1;
//        time=0;
//        for (int i = 0; i < n; i++) {
//            result *= list[i];
//            traceBack(list,result,i+1);
//            result /= list[i];
//        }
//        System.out.println(time);
//    }
//    private static void traceBack(int[] list, int result,int start) {
//        if(result==1){
//            ++time;
//        }
//        if(start<list.length){
//            result *= list[start];
//            traceBack(list,result,start+1);
//            result /=list[start];
//        }
//    }
//}
//class Main {
//
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m= sc.nextInt();
//        int[] list = new int[m + 1];
//        int  res=0;
//        int[][] quList=new int[n][2];
//        for (int i = 0; i < n; i++) {
//            int a =sc.nextInt();
//            int b =sc.nextInt();
//            quList[i][0]=a;
//            quList[i][1]=b;
//        }
//        for (int j= 0; j< n; j++) {
//            for (int i = j; i < n; i++) {
//                if(list[quList[i][0]]==0&&list[quList[i][1]]==0){
//                    ++res;
//                    list[quList[i][0]]=1;
//                    list[quList[i][1]]=1;
//                }
//            }
//            for (int i = 0; i <j ; i++) {
//                if(list[quList[i][0]]==0&&list[quList[i][1]]==0){
//                    ++res;
//                    list[quList[i][0]]=1;
//                    list[quList[i][1]]=1;
//                }
//            }
//        }
//
//        System.out.println(res);
//    }
//
//}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int[] oneList = new int[]{1,0,1,1,0,0};
        int[] twoList = new int[]{0,1,2,1,4,4};
//        for (int i = 0; i < n; i++) {
//            int a= sc.nextInt();
//            oneList[i]=a;
//        }
//        for (int i = 0; i < n; i++) {
//            int a= sc.nextInt();
//            twoList[i]=a;
//        }
        int balck=0;
        int white=0;
        for (int i = 0; i < oneList.length; i++) {
            if(oneList[i]==1){

            }
        }
        System.out.print(2);
        System.out.print(3);
    }
}