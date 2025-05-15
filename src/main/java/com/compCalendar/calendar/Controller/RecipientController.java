package com.compCalendar.calendar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compCalendar.calendar.Entities.Recipient;
import com.compCalendar.calendar.Service.RecipientService;

@RestController
@RequestMapping("/api/recipients")
public class RecipientController {

    @Autowired
    private RecipientService recipientService;

    @GetMapping
    public List<Recipient> getAllRecipients() {
        return recipientService.getAllRecipients();
    }

    @PostMapping
    public Recipient createRecipient(@RequestBody Recipient recipient) {
        return recipientService.createRecipient(recipient);
    }
}