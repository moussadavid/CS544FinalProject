package edu.mum.cs544.integration;

import edu.mum.cs544.entities.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "COMMENT", url = "localhost:8080/api")
public interface CommentClient {

    @GetMapping
    List<Book> getComment(@RequestParam Long id);
}
