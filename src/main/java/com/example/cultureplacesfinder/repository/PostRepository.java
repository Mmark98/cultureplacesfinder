package com.example.cultureplacesfinder.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.cultureplacesfinder.repository.entity.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

	List<Post> findAll();
	Post findByTitle(String title);
	List<Post> findByUserId(Long i);

}
