package com.compCalendar.calendar.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.compCalendar.calendar.Entities.Deadline;
import com.compCalendar.calendar.Entities.Recipient;

@Component
public class ReminderScheduler {

    @Autowired
    private DeadlineService deadlineService;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 9 * * ?") // Every day at 9 AM
    public void sendReminders() {
        List<Deadline> upcomingDeadlines = deadlineService.getUpcomingDeadlines();

        for (Deadline deadline : upcomingDeadlines) {
            for (Recipient recipient : deadline.getRecipients()) {
                String subject = "Reminder: " + deadline.getTitle();
                String body = "Dear " + recipient.getName() + ",\n\n"
                            + "This is a reminder for the deadline: " + deadline.getTitle() + "\n"
                            + "Description: " + deadline.getDescription() + "\n"
                            + "Due Date: " + deadline.getDueDate() + "\n\n"
                            + "Regards,\nCompliance Team";

                emailService.sendEmail(recipient.getEmail(), subject, body);

                // Later: Add WhatsApp API call here
            }
        }
    }


}
