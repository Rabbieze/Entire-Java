/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicegui;

import java.util.*;
import java.util.HashMap;

/**
 *
 * @author ahsan
 */
public class IDandPassword {
    HashMap<String,String> logininfo=new HashMap<String,String>();
    
    public IDandPassword(){
        logininfo.put("ahsan", "siddiqui");
        logininfo.put("ahsans", "PASSWORD");
        logininfo.put("ahsansiddiqui","hotmail@99");
    }
    
    protected  HashMap getLoginInfo(){
        return logininfo;
    }
}
