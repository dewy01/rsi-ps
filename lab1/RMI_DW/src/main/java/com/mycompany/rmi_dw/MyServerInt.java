package com.mycompany.rmi_dw;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyServerInt extends Remote{
    
String getDescription(String text) throws RemoteException;

float Add(float a, float b) throws RemoteException;
float Subtract(float a, float b) throws RemoteException;
float Multiply(float a, float b) throws RemoteException;
float Divide(float a, float b) throws RemoteException;

}