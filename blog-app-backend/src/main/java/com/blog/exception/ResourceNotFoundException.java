package com.blog.exception;

public class ResourceNotFoundException extends RuntimeException {


    String resourceName;
    String filedName;
    long fieldValue;

    public ResourceNotFoundException(String resourceName, String filedName, long fieldValue) {
        super(String.format("%s not found with %s : %l",resourceName,filedName,fieldValue));
        this.resourceName = resourceName;
        this.filedName = filedName;
        this.fieldValue = fieldValue;
    }
}
