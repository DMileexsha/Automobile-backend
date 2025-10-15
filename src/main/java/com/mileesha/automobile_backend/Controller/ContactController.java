package com.mileesha.automobile_backend.Controller;

import com.mileesha.automobile_backend.Model.Contact;
import com.mileesha.automobile_backend.Repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactRepo contactRepo;

    @PostMapping
    @CrossOrigin(origins = "${CORS_ORIGIN:*}")
    public Contact saveContact(@RequestBody Contact contact){
        return contactRepo.save(contact);
    }
}
