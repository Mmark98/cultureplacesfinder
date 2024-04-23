package com.example.cultureplacesfinder.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.cultureplacesfinder.repository.UserRepository;
import com.example.cultureplacesfinder.repository.entity.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepository;

	@Autowired
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Objects.requireNonNull(username, "Username cannot be null");
		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserDetailsImpl(user);
	}

}
