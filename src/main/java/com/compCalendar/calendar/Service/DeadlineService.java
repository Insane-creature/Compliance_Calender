package com.compCalendar.calendar.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compCalendar.calendar.Entities.Deadline;
import com.compCalendar.calendar.Repository.DeadlineRepository;

@Service
public class DeadlineService {
    @Autowired
    private DeadlineRepository deadlineRepository;

    public List<Deadline> getAllDeadline(){
        return deadlineRepository.findAll();
    }
    public Deadline createDeadline(Deadline deadline) {
        return deadlineRepository.save(deadline);
    }

    // Will add update, delete, reminder-sending methods later
}
