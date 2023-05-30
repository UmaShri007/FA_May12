package ai.ineuron;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ai.ineuron.bo.Book;
import ai.ineuron.service.IBookMgmtService;

@SpringBootApplication
public class FinAssgmtSpDataJpa21Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FinAssgmtSpDataJpa21Application.class, args);
		IBookMgmtService service = context.getBean(IBookMgmtService.class);
		
	/*	//Single row insertion
		
		Book book = new Book(1001,"Ramayanam","C.P.RajaGopalachari");
		System.out.println(service.insertSingleBook(book));
		
	*/	
		//Batch Insertion
		
		Iterable<Book>listBooks = service.insertBookInBatch(List.of(
				new Book(null,"Ikigai","HectorGarcia"), 
				new Book(null,"Lord of the Rings","J.R.R.Toklein"), 
				new Book(null,"Tamas","Bhishm Sahni"), 
				new Book(null,"The Blue Umberlla","RuskinBond")));
		listBooks.forEach(book->System.out.println(book.getBookId()));
		
			
	
	}

}
