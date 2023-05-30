package ai.ineuron.dao;

import org.springframework.data.repository.CrudRepository;

import ai.ineuron.bo.Book;

public interface IBookRepository extends CrudRepository<Book, Integer>{

}
