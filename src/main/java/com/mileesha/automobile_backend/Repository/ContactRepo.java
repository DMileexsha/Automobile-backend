package com.mileesha.automobile_backend.Repository;

import com.mileesha.automobile_backend.Model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepo extends MongoRepository<Contact,String> {
}
