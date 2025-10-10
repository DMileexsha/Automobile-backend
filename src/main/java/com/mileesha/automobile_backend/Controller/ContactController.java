package com.mileesha.automobile_backend.Controller;

import com.mileesha.automobile_backend.Model.Contact;
import com.mileesha.automobile_backend.Repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:5173")
public class ContactController {

    @Autowired
    private ContactRepo contactRepo;

    @PostMapping
    public Contact saveContact(@RequestBody Contact contact){
        return contactRepo.save(contact);
    }
}
