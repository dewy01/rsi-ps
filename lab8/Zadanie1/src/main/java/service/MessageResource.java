package service;

import com.mycompany.zadanie1.resources.MessageService;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Message;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 */
@Path("messages")
@RequestScoped
public class MessageResource {

    MessageService messageService = new MessageService();

    @Context
    private UriInfo context;

    public MessageResource() {
    }

    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Message getMessage(@PathParam("messageId") Long id) {
        return messageService.getMessage(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message createMessage(Message message) {
        return messageService.createMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("messageId") Long id, Message message) {
        return messageService.updateMessage(id, message);
    }

    @DELETE
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message deleteMessage(@PathParam("messageId") Long id) {
        return messageService.removeMessage(id);
    }

    // GET /webresources/messages/filter?author=Marek
    // nagłówek client-version: 1.2.3
    // GET /webresources/messages/filter;debug=true
    
    @GET
    @Path("/filter")
    @Produces(MediaType.TEXT_PLAIN)
    public String filterMessages(
            @QueryParam("author") String author,
            @HeaderParam("client-version") String clientVersion,
            @MatrixParam("debug") String debug
    ) {
        StringBuilder response = new StringBuilder();
        response.append("Author: ").append(author).append("\n");
        response.append("Client Version (Header): ").append(clientVersion).append("\n");
        response.append("Debug (Matrix): ").append(debug).append("\n");
        return response.toString();
    }

    // GET /webresources/messages/context-info

    @GET
    @Path("/context-info")
    @Produces(MediaType.TEXT_PLAIN)
    public String getContextInfo(@Context UriInfo uriInfo, @Context javax.ws.rs.core.HttpHeaders headers) {
        StringBuilder sb = new StringBuilder();
        sb.append("Absolute URI: ").append(uriInfo.getAbsolutePath().toString()).append("\n");
        sb.append("Base URI: ").append(uriInfo.getBaseUri().toString()).append("\n");
        sb.append("Request Path: ").append(uriInfo.getPath()).append("\n");
        sb.append("Headers: ").append(headers.getRequestHeaders().toString()).append("\n");
        return sb.toString();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
