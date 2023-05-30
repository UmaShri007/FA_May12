package ai.ineuron.service;

import ai.ineuron.bo.Book;

public interface IBookMgmtService {

	public String insertSingleBook(Book book); //Single record insertion
	public Iterable<Book>insertBookInBatch(Iterable<Book>book); //batch insertion using array list
}
