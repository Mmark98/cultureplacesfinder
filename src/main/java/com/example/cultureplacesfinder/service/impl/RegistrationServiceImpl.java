package com.example.cultureplacesfinder.service.impl;

import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cultureplacesfinder.domain.dto.UserDto;
import com.example.cultureplacesfinder.repository.UserRepository;
import com.example.cultureplacesfinder.repository.entity.User;
import com.example.cultureplacesfinder.repository.entity.User.Privileges;
import com.example.cultureplacesfinder.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	private static final Privileges USER_ROLE = Privileges.USER;

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private ModelMapper modelMapper;

	@Autowired
	public RegistrationServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository,
			ModelMapper modelMapper) {
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public void registerUser(UserDto userDto) {
		Objects.requireNonNull(userDto, "UserDto is a mandatory parameter");
		User user = modelMapper.map(userDto, User.class);
		user.setRole(USER_ROLE);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

}
