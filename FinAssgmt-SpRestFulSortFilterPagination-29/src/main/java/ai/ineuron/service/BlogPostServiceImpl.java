package ai.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ai.ineuron.bo.BlogPost;
import ai.ineuron.dao.IBlogPostRepository;

@Service
public class BlogPostServiceImpl implements IBlogPostService {

	@Autowired
	private IBlogPostRepository blogPostRepo;

	@Override
	public List<BlogPost> getAllBlogPosts() {
		return blogPostRepo.findAll();
	}

	@Override
	public Iterable<BlogPost> getSortedPosts(boolean value,String property) {
		Sort sort = Sort.by(value?Direction.ASC:Direction.DESC,property);
		Iterable<BlogPost>sortedPosts = blogPostRepo.findAll(sort);
		return sortedPosts;
	}

	@Override
	public Page<BlogPost> getPostsByPagination(int offset, int pageSize) {
		Page<BlogPost> pageableBlogPosts = blogPostRepo.findAll(PageRequest.of(offset, pageSize));
		return pageableBlogPosts;
	}

	@Override
	public Page<BlogPost> getPostsByPaginationAndSorting(int offset, int pageSize, String field) {
		Page<BlogPost>sortedPageableBlogPost =blogPostRepo.findAll(PageRequest.of(offset, pageSize,Sort.by(field))); 
		return sortedPageableBlogPost;
	}

	@Override
	public List<BlogPost> findPostsBySpecificComments(String query) {
		List<BlogPost>filteredBlogPosts=blogPostRepo.findPostsBySpecificComments(query);
		return filteredBlogPosts;
	}


	
}
