package com.mileesha.automobile_backend.Repository;

import com.mileesha.automobile_backend.Model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepo extends MongoRepository<Booking,String> {

}

