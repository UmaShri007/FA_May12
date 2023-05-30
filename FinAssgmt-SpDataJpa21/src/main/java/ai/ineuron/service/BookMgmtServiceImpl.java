package ai.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.ineuron.bo.Book;
import ai.ineuron.dao.IBookRepository;

@Service("book")
public class BookMgmtServiceImpl implements IBookMgmtService {

	@Autowired
	private IBookRepository bookRepo;
	
	@Override
	public String insertSingleBook(Book book) {
		Book saveBook = null;
		if(book!=null) {
		saveBook = bookRepo.save(book);
		}
		return saveBook !=null ? "Book info saved into db succesfully with "+saveBook.getBookId()
								:"Book info insertion to db failed";
	}

	@Override
	public Iterable<Book> insertBookInBatch(Iterable<Book> bookList) {
		if(bookList!=null)
		  return bookRepo.saveAll(bookList);
		else
			throw new IllegalArgumentException("Batch insertion failed..");
	
	}
	
	

}
