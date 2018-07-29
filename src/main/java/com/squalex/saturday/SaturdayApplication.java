package com.squalex.saturday;

import com.squalex.saturday.model.Event;
import com.squalex.saturday.model.Group;
import com.squalex.saturday.model.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

@SpringBootApplication
//@EnableOAuth2Sso
@AllArgsConstructor
public class SaturdayApplication {

    public final GroupRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SaturdayApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args -> {
            Stream.of("Denver JUG", "Utah JUG", "Seattle JUG",
                    "Richmond JUG").forEach(name ->
                    repository.save(new Group(name))
            );

            Group djug = repository.findByName("Denver JUG");
            Event e = Event.builder().title("Full Stack Reactive")
                    .description("Reactive with Spring Boot + React")
                    .date(Instant.parse("2018-12-12T18:00:00.000Z"))
                    .build();
            djug.setEvents(Collections.singleton(e));
            repository.save(djug);

            repository.findAll().forEach(System.out::println);
        };
    }
}
