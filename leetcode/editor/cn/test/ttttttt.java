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
//class Main {
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            int n = sc.nextInt();
//            for (int i = 0; i < n; i++) {
//                long x= sc.nextInt();
//                long y=sc.nextInt();
//                if(x==y){
//                    System.out.println(0);
//                }
//                int res=0;
//                while (x!=y){
//                    ++res;
//                    if(x%3==0){
//                        x=x/3;
//                    }else {
//                        ++x;
//                    }
//                }
//                System.out.println(res);
//            }
//        }
//}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int len = sc.nextInt();
        int[][] list = new int[len][3];
        int[] ints = new int[num];
        for (int i = 0; i < len; i++) {
            int a= sc.nextInt();
            int b= sc.nextInt();
            int c= sc.nextInt();
            list[i][0]=a;
            list[i][1]=b;
            list[i][2]=c;
        }
        int[][] list2 = {{1,2,3},{1,3,4},{2,3,5}};


    }
    public int getTowNum(int[] nums){
        int[] temp = new int[2];
        temp[0]=nums[0]>nums[1] ? nums[1]:nums[0];
        temp[1]=nums[0]<nums[1] ? nums[1]:nums[0];
        for (int i = 2; i < nums.length; i++) {
            if(temp[0]<nums[i]){
                temp[0]=nums[i];
                if(temp[0]>temp[1]){
                    int tmp=temp[0];
                    temp[0]=temp[1];
                    temp[1]=temp[0];
                }
            }
        }
        return temp[0];
    }
}

//class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            System.out.println(process(x, y));
//        }
//    }
//
//    private static int process(long remain, long y) {
//        if (remain == y) {
//            return 0;
//        }
//        int ans = 0;
//        if (remain % 3 != 0) {
//            ans += process(remain + 1, y) + 1;
//        } else {
//            if(remain<y){
//                ans+=process(remain+1,y)+1;
//            }else
//            ans += process(remain / 3, y) + 1;
//        }
//        return ans;
//    }
//}