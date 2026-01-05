package com.example.exceptionhandling;


public class Trying {
    public static void main(String[] args) {
        int[] numerator={10,20,30,40,50};
        int[] denominator={2,1,5,0,10};
        for (int i=0;i<10;i++){
            try{
                System.out.println(divided(numerator[i],denominator[i]));
            }catch(Exception e){
                System.out.println(e);
            }
        }


//        for (int i=0;i<numerator.length;i++){
//            System.out.println(divided(numerator[i],denominator[i]));
//        }


        System.out.println("Good Job");
    }
    public static int divided(int a,int b){
        try{
            return a/b;
        }catch(ArithmeticException e){
            System.out.print(e+" : ");
            return -1;
        }catch(Exception e){
            System.out.println(e);
            return -1;
        }

    }

}
