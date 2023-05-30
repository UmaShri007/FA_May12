package ai.ineuron.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ai.ineuron.bo.BlogPost;

public interface IBlogPostRepository extends JpaRepository<BlogPost,Integer> {
	
	@Query("SELECT b FROM BlogPost b WHERE " +
            "b.comment LIKE CONCAT('%',:query, '%')" +
            "Or b.title LIKE CONCAT('%', :query, '%')")
	List<BlogPost> findPostsBySpecificComments(String query);
	
}
