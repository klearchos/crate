package meetup.crate.web.controllers;

import java.sql.SQLException;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import meetup.crate.repositories.EventRepository;
import meetup.model.Event;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@Slf4j
@RequestMapping("/event")
public class EventController {

    private EventRepository eventRepository;

    EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @PostMapping("/create")
    public ResponseEntity postEvent(@Valid @RequestBody Event event) {
        log.debug("Received Event {}", event);
        try {
            this.eventRepository.insert(event);
        } catch (SQLException exc) {
            log.error("Database error", exc);
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
