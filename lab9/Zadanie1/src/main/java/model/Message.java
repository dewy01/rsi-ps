package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
    
    private long id;
    private String message;
    private Date created;
    private String author;
    private List<Link> links = new ArrayList<Link>();
    
    public Message(){
        
    }
    
    public Message(long id, String message, String author){
        this.id = id;
        this.message = message;
        this.created = new Date();
        this.author = author;
    }
    
    public void addLink(Link link) {
        links.add(link);
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
    
    public List<Link> getLinks(){
        return this.links;
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
    
    public void setLinks(List<Link> links){
        this.links = links;
    }
}
