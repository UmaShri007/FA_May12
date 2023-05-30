package ai.ineuron.service;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import ai.ineuron.bo.BlogPost;


public interface IBlogPostService {

	public List<BlogPost> getAllBlogPosts();
	
	//sorting
	public Iterable<BlogPost>getSortedPosts(boolean value,String property);
	
	//pagination
	public Page<BlogPost> getPostsByPagination(int offset,int pageSize);
	
	//sorting and pagination
	public Page<BlogPost> getPostsByPaginationAndSorting(int offset,int pageSize,String field);
	
	//trying to filterr based on particular comments
	
	public List<BlogPost> findPostsBySpecificComments(String query);
	
}
