/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 *
 * @author dawid
 */
public class InvalidInputException extends Exception {
    public String errorDetails;
    
    public InvalidInputException(String reason, String errorDetails){
        super(reason);
        this.errorDetails = errorDetails;
    }
    
    public String getFaultInfo(){
        return errorDetails;
    }
}
