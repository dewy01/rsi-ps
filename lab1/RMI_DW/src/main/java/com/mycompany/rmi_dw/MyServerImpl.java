package com.mycompany.rmi_dw;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyServerImpl extends UnicastRemoteObject implements MyServerInt {   
int i = 0;
protected MyServerImpl() throws RemoteException {
super();
}

@Override
public String getDescription(String text) throws RemoteException {
i++;
System.out.println("MyServerImpl.getDescription: " + text + " " + i);
return "getDescription: " + text + " " + i;
}

@Override
public float Add(float a, float b) throws RemoteException {
  return a+b;
}

@Override
public float Subtract(float a, float b) throws RemoteException {
  return a-b;
}

@Override
public float Multiply(float a, float b) throws RemoteException {
  return a*b;
}

@Override
public float Divide(float a, float b) throws RemoteException {
  return a/b;
}


}
