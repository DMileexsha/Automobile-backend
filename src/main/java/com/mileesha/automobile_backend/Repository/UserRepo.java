package com.mileesha.automobile_backend.Repository;

import com.mileesha.automobile_backend.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User,String> {
    Optional <User> findByEmail(String email);
}
