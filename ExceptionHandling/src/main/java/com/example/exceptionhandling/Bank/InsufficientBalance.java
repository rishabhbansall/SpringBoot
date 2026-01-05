package com.example.exceptionhandling.Bank;
//if want to create custom exception we need to extend Exception class
public class InsufficientBalance extends Exception{
    public InsufficientBalance(){
        super("You do not have sufficient balance to withdraw the amount");
    }
}
