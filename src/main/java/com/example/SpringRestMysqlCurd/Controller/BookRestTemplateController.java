package com.example.SpringRestMysqlCurd.Controller;

import com.example.SpringRestMysqlCurd.Model.Book;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

public class BookRestTemplateController {
    
    private static final String BASE_URL = "http://localhost:8080/v1/mysqlapp/";
    private RestTemplate restTemplate;
    
    public BookRestTemplateController() {
        this.restTemplate = new RestTemplate();
    }
    @GetMapping("getAllBooks1")
    public ResponseEntity<String> getAllBooks() {
        String url = BASE_URL + "getAllBooks1";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response;
    }
    
    public ResponseEntity<String> getBookById(long id) {
        String url = BASE_URL + "getBookById/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response;
    }
    
    public ResponseEntity<String> getLatestByUuid(String uuid) {
        String url = BASE_URL + "getLatestByUuid?uuid=" + uuid;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response;
    }
    
    public ResponseEntity<String> addABookToLibrary(Book book) {
        String url = BASE_URL + "books";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Book> entity = new HttpEntity<Book>(book, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return response;
    }
    
    public ResponseEntity<String> updateBook(long id, Book book) {
        String url = BASE_URL + "updateBook/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Book> entity = new HttpEntity<Book>(book, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
        return response;
    }
    
    public ResponseEntity<String> deleteBook(long id) {
        String url = BASE_URL + "deleteBook/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
        return response;
    }
}
