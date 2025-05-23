package com.mycompany.zadanie1.resources;

import java.util.ArrayList;
import java.util.List;
import model.Message;

public class MessageService {
    
    private List<Message> list = new ArrayList<>();
    
    public MessageService(){
        Message m1 = new Message(1L, "Pierwsza wiadomość", "Jacek");
        Message m2 = new Message(1L, "Druga wiadomość", "Marek");
        Message m3 = new Message(1L, "Trzecia wiadomość", "Ewa");

        list.add(m1);
        list.add(m2);
        list.add(m3);
    }
    
    public List<Message> getAllMessages(){
        return list;
    }
}
