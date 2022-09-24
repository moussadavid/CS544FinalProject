package edu.mum.cs544.services;

import java.util.List;

import edu.mum.cs544.entities.Comment;
import edu.mum.cs544.repositories.ICommentDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CommentService {
    private final ICommentDao commentDao;

    public List<Comment> getAll() {
        return commentDao.findAll();
    }

    public void add(Comment comment) {
        commentDao.save(comment);
    }

    public Comment get(int id) {
        return commentDao.findById(id).get();
    }

    public void update(Comment comment) {
        commentDao.save(comment);
    }

    public void delete(int id) {
        commentDao.deleteById(id);
    }
    
    public List<Comment> findByPostId(int postId) {
        return commentDao.findByPostId(postId);
    }


    public void deleteByPostId(int postId) {
        commentDao.deleteByPostId(postId);
    }

    public List<Comment> findByCommentContaining(String comment) {
        return commentDao.findByCommentContaining(comment);
    }
}