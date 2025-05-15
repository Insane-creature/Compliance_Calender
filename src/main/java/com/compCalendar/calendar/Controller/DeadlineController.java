package com.compCalendar.calendar.Controller;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compCalendar.calendar.Entities.Deadline;
import com.compCalendar.calendar.Entities.Recipient;
import com.compCalendar.calendar.Service.DeadlineService;
import com.compCalendar.calendar.Service.RecipientService;
import com.compCalendar.calendar.dto.DeadlineRequestDTO;



@RestController
@RequestMapping("api/deadlines")
public class DeadlineController {
    @Autowired
    private DeadlineService deadlineService;

    @Autowired
    private RecipientService recipientService;

    @GetMapping
    public List<Deadline> getAllDeadlines(){
        return deadlineService.getAllDeadline();
    }

    @PostMapping
    public Deadline createDeadline(@RequestBody DeadlineRequestDTO deadlineRequest) {
        // Fetch Recipients by IDs
        List<Recipient> recipients = recipientService.getRecipientsByIds(deadlineRequest.getRecipientIds());

        // Create Deadline entity
        Deadline deadline = new Deadline();
        deadline.setTitle(deadlineRequest.getTitle());
        deadline.setDescription(deadlineRequest.getDescription());
        deadline.setDueDate(deadlineRequest.getDueDate());
        
        deadline.setRecipients(new HashSet<>(recipients));
        deadline.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        deadline.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return deadlineService.createDeadline(deadline);
    }

    


}
