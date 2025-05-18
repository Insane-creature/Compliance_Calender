package com.compCalendar.calendar.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compCalendar.calendar.Entities.Deadline;
import com.compCalendar.calendar.Entities.Recipient;

@Component
public class ReminderScheduler {

    @Autowired
    private DeadlineService deadlineService;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 * * * * *") // Every day at 9 AM
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
                System.out.println("Sending email to: " + recipient.getEmail() + " for deadline: " + deadline.getTitle());

                // Later: Add WhatsApp API call here
            }
        }
    }

    @RestController
    @RequestMapping("/test")
    public class TestController {
        @Autowired
        ReminderScheduler reminderScheduler;

        @GetMapping("/run-scheduler")
        public String runSchedulerNow() {
            reminderScheduler.sendReminders();
            return "Scheduler manually triggered!";
        }
    }


}
