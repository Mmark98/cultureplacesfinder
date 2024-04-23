package com.example.cultureplacesfinder.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cultureplacesfinder.domain.dto.PostDto;
import com.example.cultureplacesfinder.repository.PostRepository;
import com.example.cultureplacesfinder.repository.UserRepository;
import com.example.cultureplacesfinder.repository.entity.Post;
import com.example.cultureplacesfinder.repository.entity.User;
import com.example.cultureplacesfinder.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	private PostRepository postRepository;
	private UserRepository userRepository;
	private ModelMapper modelMapper;

	@Autowired
	public PostServiceImpl(PostRepository postRepository, UserRepository userRepository, ModelMapper modelMapper) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<PostDto> getPosts() {
		return postRepository.findAll().stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public PostDto getPost(String title) {
		Objects.requireNonNull(title, "Title is a required parameter for getting post.");
		return modelMapper.map(postRepository.findByTitle(title), PostDto.class);
	}

	@Override
	public PostDto createPost(PostDto postDto, String email) {
		Objects.requireNonNull(postDto, "Post is a required parameter for creating post.");
		Objects.requireNonNull(email, "Email is a required parameter for creating post.");
		User user = userRepository.findByEmail(email);
		Post post = modelMapper.map(postDto, Post.class);
		post.setUser(user);
		return modelMapper.map(postRepository.save(post), PostDto.class);
	}

	@Override
	public List<PostDto> getAllPost(Long id) {
		Objects.requireNonNull(id, "Id is a required parameter for getting all post.");
		return postRepository.findByUserId(id).stream().map(post -> modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
	}

}
