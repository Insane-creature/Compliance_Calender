package com.compCalendar.calendar.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compCalendar.calendar.Entities.Deadline;

@Repository
public interface DeadlineRepository extends JpaRepository<Deadline, Long> {

    List<Deadline> findByDueDateBetween(LocalDate start, LocalDate end);

}
