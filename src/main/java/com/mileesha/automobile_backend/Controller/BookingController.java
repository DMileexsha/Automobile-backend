package com.mileesha.automobile_backend.Controller;

import com.mileesha.automobile_backend.Model.Booking;
import com.mileesha.automobile_backend.Repository.BookingRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin(origins = "http://localhost:5173")

public class BookingController {

    private final BookingRepo bookingRepo;

    public BookingController(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    @PostMapping()
    public Booking createBooking(@RequestBody Booking booking){

        return bookingRepo.save(booking);
    }

    @GetMapping
    public List <Booking> getAllBookings(){

        return bookingRepo.findAll();
    }
}
