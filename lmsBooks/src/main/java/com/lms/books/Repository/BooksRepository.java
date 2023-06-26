package com.lms.books.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.books.Model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {

}
