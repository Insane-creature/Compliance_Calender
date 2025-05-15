package com.compCalendar.calendar.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compCalendar.calendar.Entities.Recipient;
import com.compCalendar.calendar.Repository.RecipientRepository;

@Service
public class RecipientService {
    @Autowired
    private RecipientRepository recipientRepository;

    public List<Recipient> getAllRecipients(){
        return recipientRepository.findAll();
    }

    public Recipient createRecipient(Recipient recipient) {
        return recipientRepository.save(recipient);
    }


    public List<Recipient> getRecipientsByIds(List<Long> ids) {
        return recipientRepository.findAllById(ids);
    }
}
