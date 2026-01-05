package com.example.exceptionhandling;

public class Test {
    public static void main(String[] args){
//        level1();
//        try {
//            level1();
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }

        try{
            level1();
        }catch(Exception o){
            o.printStackTrace();
        }
    }

    public static void level3(){
        int[] array=new int[5];
        array[5]=10;
    }
    public static void level2(){
        level3();
    }
    public static void level1(){
        level2();
    }
}
