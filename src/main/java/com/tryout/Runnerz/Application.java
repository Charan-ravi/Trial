package com.tryout.Runnerz;

import com.tryout.Runnerz.Run.Location;
import com.tryout.Runnerz.Run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	private final WelcomeMessage welcomeMessage;

	@Autowired
    public Application(WelcomeMessage welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		Application app = context.getBean(Application.class);
		app.run();
	}
	public void run(){
		System.out.println("The message: "+welcomeMessage.getWelcomeMessage());
		System.out.println("Did you see that?, I renamed my Application to Runnerz !!!");
	}
	@Bean
	CommandLineRunner runner(){
		return args -> {
			Run run = new Run(1,"First Run", LocalDateTime.now(),LocalDateTime.now().plusMinutes(30),6, Location.OUTDOOR);
            log.info("Run: {}", run);
		};
	}

}
