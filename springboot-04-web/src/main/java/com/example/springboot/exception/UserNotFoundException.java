package com.example.springboot.exception;

public class UserNotFoundException extends RuntimeException
{
    public UserNotFoundException()
    {
        super("用户不存在");
    }
}
