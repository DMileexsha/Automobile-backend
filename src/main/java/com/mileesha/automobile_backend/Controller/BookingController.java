package com.mileesha.automobile_backend.Controller;

import com.mileesha.automobile_backend.Model.Booking;
import com.mileesha.automobile_backend.Repository.BookingRepo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/booking")


public class BookingController {

    private final BookingRepo bookingRepo;

    public BookingController(BookingRepo bookingRepo) {

        this.bookingRepo = bookingRepo;
    }

    @PostMapping()
    @CrossOrigin(origins = "${CORS_ORIGIN:*}")
    public Booking createBooking(@RequestBody Booking booking){

        return bookingRepo.save(booking);
    }

    @GetMapping
    public List <Booking> getAllBookings(){

        return bookingRepo.findAll();
    }
}
