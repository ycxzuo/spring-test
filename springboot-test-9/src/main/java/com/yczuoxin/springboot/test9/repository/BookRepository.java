package com.yczuoxin.springboot.test9.repository;

import com.yczuoxin.springboot.test9.domain.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends ElasticsearchRepository<Book, Long> {

    List<Book> findByName(String name);

}
