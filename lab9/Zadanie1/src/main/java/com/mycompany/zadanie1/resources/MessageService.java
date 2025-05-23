package com.mycompany.zadanie1.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Message;

public class MessageService {

    private static final Map<Long, Message> messages = new HashMap<>();

    public MessageService() {
        messages.put(1L, new Message(1L, "Pierwsza wiadomość", "Jacek"));
        messages.put(2L, new Message(2L, "Druga wiadomość", "Marek"));
        messages.put(3L, new Message(3L, "Trzecia wiadomość", "Ewa"));
    }

    public List<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }

    public Message getMessage(Long id) {
        return messages.get(id);
    }

    public Message createMessage(Message message) {
        message.setId(messages.size() + 1L);
        messages.put(message.getId(), message);
        return message;
    }
    
    public Message updateMessage(Long id, Message message) {
    if (!messages.containsKey(id)) {
        return null;
    }
    message.setId(id);
    messages.put(id, message);
    return message;
    }

    public Message removeMessage(Long id) {
        return messages.remove(id);
    }
    
}
