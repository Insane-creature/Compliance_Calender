package com.compCalendar.calendar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compCalendar.calendar.Entities.Recipient;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Long> {
    
}
