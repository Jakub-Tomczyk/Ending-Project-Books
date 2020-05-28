package pl.jakubtomczyk.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    @ManyToMany(mappedBy = "category")
    private Set<Book> nameCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Book> getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(Set<Book> nameCategory) {
        this.nameCategory = nameCategory;
    }
}
