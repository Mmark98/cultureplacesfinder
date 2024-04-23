package com.example.cultureplacesfinder.service;

import java.util.List;
import com.example.cultureplacesfinder.domain.dto.PostDto;

public interface PostService {

	public List<PostDto> getPosts();
	public PostDto getPost(String title);
	public PostDto createPost(PostDto postDto, String email);
	public List<PostDto> getAllPost(Long id);

}

