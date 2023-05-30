package ai.ineuron.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ai.ineuron.bo.BlogPost;
import ai.ineuron.service.IBlogPostService;

@RestController
@RequestMapping("/api/blogpost")
public class BlogPostController {

	@Autowired
	private IBlogPostService blogPostService;
	
	@GetMapping("/get")
	public List<BlogPost> getAllBlogPost(){
		return blogPostService.getAllBlogPosts();
	}
	//localhost:8080/api/blogpost/getSorted/comment
	@GetMapping("/getSorted/{property}")
	public Iterable<BlogPost> getSortedBlogPosts(@PathVariable String property ){
		return blogPostService.getSortedPosts(true, property);
	}
	//localhost:8080/api/blogpost/pagination/0/2
	//total elements : 8, total pages = 4
	@GetMapping("/pagination/{offset}/{pageSize}")
	public Page<BlogPost> getBlogPostsByPagination(@PathVariable int offset,@PathVariable int pageSize ){
		return blogPostService.getPostsByPagination(offset, pageSize);
	}
	
	//localhost:8080/api/blogpost/pageAndSort/0/2/comment
	//total elements : 8, total pages = 4
	@GetMapping("/pageAndSort/{offset}/{pageSize}/{field}")
	public Page<BlogPost> getPostsByPaginationAndSorting(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field ){
		return blogPostService.getPostsByPaginationAndSorting(offset, pageSize, field);
	}
	//localhost:8080/api/blogpost/filtered?query=AI
	//localhost:8080/api/blogpost/filtered?query=informative
	
	@GetMapping("/filtered")
	 public List<BlogPost> findPostsBySpecificComments(@RequestParam("query") String query){
		return blogPostService.findPostsBySpecificComments(query);
	}
}
