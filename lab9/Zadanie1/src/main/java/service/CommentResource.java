package service;

import com.mycompany.zadanie1.resources.CommentService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import model.Comment;

public class CommentResource {

    private long messageId;
    private CommentService commentService = new CommentService();

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Comment> getAllComments() {
        return commentService.getAllComments(messageId);
    }

    @GET
    @Path("/{commentId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Comment getComment(@PathParam("commentId") long commentId) {
        return commentService.getComment(messageId, commentId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment addComment(Comment comment) {
        return commentService.addComment(messageId, comment);
    }

    @PUT
    @Path("/{commentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment updateComment(@PathParam("commentId") long commentId, Comment comment) {
        return commentService.updateComment(messageId, commentId, comment);
    }

    @DELETE
    @Path("/{commentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comment deleteComment(@PathParam("commentId") long commentId) {
        return commentService.removeComment(messageId, commentId);
    }
}

