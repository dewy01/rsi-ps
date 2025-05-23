package com.mycompany.zadanie1.resources;

import java.util.*;
import model.Comment;

public class CommentService {

    private static Map<Long, Map<Long, Comment>> comments = new HashMap<>();

    public CommentService() {
        Map<Long, Comment> commentsForMessage1 = new HashMap<>();
        commentsForMessage1.put(1L, new Comment(1L, "Pierwszy komentarz", "Adam"));
        comments.put(1L, commentsForMessage1);
    }

    public List<Comment> getAllComments(Long messageId) {
        return new ArrayList<>(comments.getOrDefault(messageId, Collections.emptyMap()).values());
    }

    public Comment getComment(Long messageId, Long commentId) {
        Map<Long, Comment> messageComments = comments.get(messageId);
        return messageComments != null ? messageComments.get(commentId) : null;
    }

    public Comment addComment(Long messageId, Comment comment) {
        Map<Long, Comment> messageComments = comments.computeIfAbsent(messageId, k -> new HashMap<>());
        long newId = messageComments.size() + 1L;
        comment.setId(newId);
        messageComments.put(newId, comment);
        return comment;
    }

    public Comment updateComment(Long messageId, Long commentId, Comment comment) {
        Map<Long, Comment> messageComments = comments.get(messageId);
        if (messageComments == null || !messageComments.containsKey(commentId)) return null;
        comment.setId(commentId);
        messageComments.put(commentId, comment);
        return comment;
    }

    public Comment removeComment(Long messageId, Long commentId) {
        Map<Long, Comment> messageComments = comments.get(messageId);
        return messageComments != null ? messageComments.remove(commentId) : null;
    }
}
