package pl.jakubtomczyk.service;

import org.springframework.stereotype.Service;
import pl.jakubtomczyk.entity.Publisher;
import pl.jakubtomczyk.repository.PublisherRepository;

import java.util.List;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public void save(Publisher publisher) {
        this.publisherRepository.save(publisher);
    }

    public List<Publisher> readAll() {
        return this.publisherRepository.findAll();
    }

    public void delete(Publisher publisher) {
        this.publisherRepository.delete(publisher);
    }

    public void update(Publisher publisher, Long id) {
        this.publisherRepository.findOneById(id);
    }

    public Publisher findById(Long id) {
        return this.publisherRepository.findById(id).orElse(null);
    }
    public void deleteById(Long id) {
        Publisher publisher = findById(id);
        this.publisherRepository.delete(publisher);
    }
}
