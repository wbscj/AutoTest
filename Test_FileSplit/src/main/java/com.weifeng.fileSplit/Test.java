package com.weifeng.fileSplit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        String str3 = null,str4;
        int num = 100;
        for (int i = 0; i <= num; i++) {
            if (i<100){
                str3 = ">"+getString(num-i," ")+ "]";
            }else {
                str3 = getString(num-i," ")+ "]";
            }
            str4 = String.format("%d%%| [%s",i,getString(i,"="));
            System.out.print(str4);
            System.out.print(str3+"\r");
            Thread.sleep(100);
        }
    }

    public static String getString(int num,String str){
        String a = "";
        for (int i = 0; i < num; i++) {
            a+=str;
        }
        return a;
    }
}
