// package edu.mum.cs544.integration;

// import lombok.AllArgsConstructor;
// import org.springframework.core.ParameterizedTypeReference;
// import org.springframework.http.HttpMethod;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;

// import edu.mum.cs544.entities.Book;

// import java.net.URI;
// import java.util.List;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

// @Service
// @AllArgsConstructor
// public class BookServiceIntgeration {
// private final RestTemplate restTemplate;
// private final String bookUrl = "http://localhost:8080/book";
// private final String bookUrlID = "http://localhost:8080/book/{id}";

// public Book get(Long id) {
// return restTemplate.getForObject(bookUrlID, Book.class, id);
// }

// public List<Book> getAll() {
// ResponseEntity<List<Book>> response = restTemplate.exchange(bookUrl,
// HttpMethod.GET, null,
// new ParameterizedTypeReference<List<Book>>() {
// });
// return response.getBody();
// }

// public void add(Book b) {
// restTemplate.postForLocation(bookUrl, b);
// }

// public void update(Book b) {
// restTemplate.put(bookUrlID, b, b.getId());
// }

// public void delete(Long id) {
// restTemplate.delete(bookUrlID, id);
// }
// }
