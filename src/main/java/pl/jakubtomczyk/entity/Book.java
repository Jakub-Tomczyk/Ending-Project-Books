package pl.jakubtomczyk.entity;

import pl.jakubtomczyk.enums.Rating;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToMany
    private Set<Author> author;
    @ManyToMany
    private Set<Publisher> publisher;
    @Column(length=1000)
    private String description;
    private Rating rating;
    @ManyToMany
    private Set<Category> category;


}
