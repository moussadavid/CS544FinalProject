package edu.mum.cs544.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs544.entities.Book;

public interface IBookDao extends JpaRepository<Book, Integer> {
}