package br.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	private static final Logger log = Logger.getLogger(ScheduledTasks.class.getName());

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	// every ten seconds.
	// @Scheduled(cron = "*/10 * * * * *")
	public void reportCurrentTime() {
		// log.info("The time is now {}", dateFormat.format(new Date()));
		log.info("The time is now " + dateFormat.format(new Date()));
	}
}
