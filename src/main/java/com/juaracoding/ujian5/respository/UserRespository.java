package com.juaracoding.ujian5.respository;

import org.springframework.data.repository.CrudRepository;

import com.juaracoding.ujian5.entity.User;

public interface UserRespository extends CrudRepository<User, Long> {

	User findByUsername(String name);

	User findByIdUser(Long id);

}
