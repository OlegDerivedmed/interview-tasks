package com.derivedmed;

public interface B {

    default void hello(){
        System.out.println("B");
    }
}
