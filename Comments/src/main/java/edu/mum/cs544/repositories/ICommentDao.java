package edu.mum.cs544.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import edu.mum.cs544.entities.Comment;

public interface ICommentDao extends JpaRepository<Comment, Integer> {

    List<Comment> findByPostId(int postId);
    void deleteByPostId(int postId);
    List<Comment> findByCommentContaining(String comment);

}