package com.example.backbyteacookie.services;

import com.example.backbyteacookie.DAO.CommentDao;
import com.example.backbyteacookie.models.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentService {
    private final CommentDao commentDao;

    public List<Comment> findAll() {
        return commentDao.findAll();
    }

    public Comment findById(Long id) {
        return commentDao.findById(id).orElseThrow();
    }
}
