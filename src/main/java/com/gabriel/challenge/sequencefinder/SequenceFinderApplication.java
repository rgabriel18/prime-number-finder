package com.gabriel.challenge.sequencefinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.EventListener;

import java.nio.file.Path;

@SpringBootApplication
public class SequenceFinderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SequenceFinderApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initiateFlow() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Flow flow = context.getBean("flow", Flow.class);

        flow.introduce();
        Path filePath = flow.getPath();
        String result = flow.processFile(filePath);
        flow.presentResult(result);
    }

}
