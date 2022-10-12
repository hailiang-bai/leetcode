package leetcode.editor.cn.test;

import java.util.Stack;

public class test implements hhhh{
    Stack<Integer> stack1= new Stack<Integer>();
    Stack<Integer> stack2= new Stack<Integer>();

    void myPush(int value){
        stack1.push(value);
    }

    int myPop(){
        if(stack2.isEmpty()&&!stack1.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }

        }
        return stack2.pop();
    }



    @Override
    public void nihao() {

    }

    @Override
    public void hah(int a) {
        hhhh.super.hah(a);
    }

    public static void main(String[] args) {
        test sss = new test();
        sss.hah(2);
    }
}
