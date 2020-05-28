package pl.jakubtomczyk.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.jakubtomczyk.entity.Publisher;
import pl.jakubtomczyk.repository.PublisherRepository;

@Component
public class PublisherConverter implements Converter<String, Publisher> {
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public Publisher convert(String id){
        return publisherRepository.findOneById(Long.parseLong(id));
    }
}
