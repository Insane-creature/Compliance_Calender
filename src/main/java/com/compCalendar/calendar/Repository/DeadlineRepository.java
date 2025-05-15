package com.compCalendar.calendar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compCalendar.calendar.Entities.Deadline;

@Repository
public interface DeadlineRepository extends JpaRepository<Deadline, Long> {
    
}
