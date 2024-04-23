package com.example.cultureplacesfinder.service.impl;

import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cultureplacesfinder.domain.dto.UserDto;
import com.example.cultureplacesfinder.repository.UserRepository;
import com.example.cultureplacesfinder.repository.entity.User;
import com.example.cultureplacesfinder.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private ModelMapper modelMapper;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public UserDto getUser(String email) {
		Objects.requireNonNull(email, "Email is a required parameter.");
		User user = userRepository.findByEmail(email);
		Objects.requireNonNull(user, "The user does not exist");
		return modelMapper.map(user, UserDto.class);
	}

}
