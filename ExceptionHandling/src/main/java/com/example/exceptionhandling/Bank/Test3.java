package com.example.exceptionhandling.Bank;

public class Test3 {
    public static void main(String[] args){
        BankAccount bankaccount=new BankAccount(10);
        try{
            bankaccount.withdraw(15);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
