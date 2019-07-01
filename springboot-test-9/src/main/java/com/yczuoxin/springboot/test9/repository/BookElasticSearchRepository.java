package com.yczuoxin.springboot.test9.repository;

import com.yczuoxin.springboot.test9.domain.Book;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.ElasticsearchPersistentEntity;
import org.springframework.data.elasticsearch.core.mapping.SimpleElasticsearchPersistentEntity;
import org.springframework.data.elasticsearch.repository.support.AbstractElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.support.ElasticsearchEntityInformation;
import org.springframework.data.elasticsearch.repository.support.MappingElasticsearchEntityInformation;
import org.springframework.data.util.ClassTypeInformation;
import org.springframework.data.util.TypeInformation;
import org.springframework.stereotype.Repository;

@Repository
public class BookElasticSearchRepository extends AbstractElasticsearchRepository<Book, Long> {

    public BookElasticSearchRepository(ElasticsearchOperations elasticsearchOperations){
        super(createElasticsearchEntityInformation(), elasticsearchOperations);
    }

    private static ElasticsearchEntityInformation<Book, Long> createElasticsearchEntityInformation() {

        TypeInformation<Book> type = ClassTypeInformation.from(Book.class);

        ElasticsearchPersistentEntity<Book> entity = new SimpleElasticsearchPersistentEntity(type);

        ElasticsearchEntityInformation information = new MappingElasticsearchEntityInformation(entity);

        return information;
    }


    @Override
    protected String stringIdRepresentation(Long aLong) {
        return String.valueOf(aLong);
    }
}
