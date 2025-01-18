package net.javaguides.springboot_transaction_demo.Exception;

public class PaymentException extends RuntimeException{
    public PaymentException(String message){
        super(message);
    }
}
