package com.juaracoding.ujian5.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.juaracoding.ujian5.entity.User;
import com.juaracoding.ujian5.respository.UserRespository;

public class CustomUserDetailServices implements UserDetailsService {

	@Autowired
	private UserRespository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.findByUsername(username);		
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetail(user);
	}

}

