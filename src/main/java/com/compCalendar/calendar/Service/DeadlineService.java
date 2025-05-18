package com.compCalendar.calendar.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compCalendar.calendar.Entities.Deadline;
import com.compCalendar.calendar.Repository.DeadlineRepository;
import com.compCalendar.calendar.Repository.RecipientRepository;

@Service
public class DeadlineService {
    @Autowired
    private DeadlineRepository deadlineRepository;

    @Autowired
private RecipientRepository recipientRepository;

    public List<Deadline> getAllDeadline(){
        return deadlineRepository.findAll();
    }
    public Deadline createDeadline(Deadline deadline) {
        deadline.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        deadline.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        return deadlineRepository.save(deadline);
    }

    // Will add update, delete, reminder-sending methods later

    public List<Deadline> getUpcomingDeadlines() {
    LocalDate today = LocalDate.now();
    LocalDate nextWeek = today.plusDays(7);

    return deadlineRepository.findByDueDateBetween(today, nextWeek);
}
}
