package com.devsuperior.ProjetoUserdept.Exceptions;

public class RecourceNotFoundException extends RuntimeException{


    public RecourceNotFoundException(String message){
        super(message);
    }

    public RecourceNotFoundException(){
        super("ID not found.");
    }
}
    

