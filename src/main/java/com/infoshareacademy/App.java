package com.infoshareacademy;

import com.infoshareacademy.model.User;
import com.infoshareacademy.service.MakeNewUser;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "The Velopers" );
        User currentUser = MakeNewUser.createUser();
    }
}
