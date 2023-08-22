package br.com.suplementscommerce.service.exceptions;

public class DataBaseException extends RuntimeException{
    public DataBaseException(String msg){
        super(msg);
    }
}
