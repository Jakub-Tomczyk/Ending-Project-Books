package pl.jakubtomczyk.controller;

import org.springframework.stereotype.Controller;
import pl.jakubtomczyk.service.PublisherService;

@Controller
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }
}
