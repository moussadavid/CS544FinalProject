package edu.mum.cs544.integration;

import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.mum.cs544.entities.Comment;

import java.util.List;


@Service
@AllArgsConstructor
public class CommentServiceIntgeration {
    private final RestTemplate restTemplate;
    private final String commentUrl = "http://localhost:8080/comment";
    private final String commentUrlID = "http://localhost:8080/comment/{id}";

    public Comment get(Long id) {
        return restTemplate.getForObject(commentUrlID, Comment.class, id);
    }

    public List<Comment> getAll() {
        ResponseEntity<List<Comment>> response = restTemplate.exchange(commentUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Comment>>() {
                });
        return response.getBody();
    }

    public void add(Comment c) {
        restTemplate.postForLocation(commentUrl, c);
    }

    public void update(Comment c) {
        restTemplate.put(commentUrlID, c, c.getId());
    }

    public void delete(Long id) {
        restTemplate.delete(commentUrlID, id);
    }
}
