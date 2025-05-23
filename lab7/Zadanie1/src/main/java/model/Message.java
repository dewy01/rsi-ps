package model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
    
    private long id;
    private String message;
    private Date created;
    private String author;
    
    public Message(){
        
    }
    
    public Message(long id, String message, String author){
        this.id = id;
        this.message = message;
        this.created = new Date();
        this.author = author;
    }
    
    public long getId(){
        return this.id;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    public Date getCreated(){
        return this.created;
    }
    
    public String getAuthor(){
        return this.author;
    }
    
    public void setId(long id){
        this.id = id;
    }
    
    public void setMessage(String message){
        this.message = message;
    }
    
    public void setCreated(Date created){
        this.created = created;
    }
    
    public void setAuthor(String author){
        this.author = author;
    }
}
