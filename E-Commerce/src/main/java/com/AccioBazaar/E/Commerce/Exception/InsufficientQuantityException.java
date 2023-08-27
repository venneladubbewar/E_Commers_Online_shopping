package com.AccioBazaar.E.Commerce.Exception;

import net.bytebuddy.implementation.bind.annotation.Super;

public class InsufficientQuantityException extends Exception {

    public InsufficientQuantityException(String s){
        super(s);
    }
}
