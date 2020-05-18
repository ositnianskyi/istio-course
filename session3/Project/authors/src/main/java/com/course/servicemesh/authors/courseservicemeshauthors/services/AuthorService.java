package com.course.servicemesh.authors.courseservicemeshauthors.services;

import com.course.servicemesh.authors.courseservicemeshauthors.models.Author;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class AuthorService {
    private final HashMap<Integer, Author> authors;

    public AuthorService() {
        this.authors = new HashMap<>();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            this.authors.put(1, new Author(1)
                    .withFirstName("Loreth Anne")
                    .withLastName("White")
                    .withBirthDate(dateFormat.parse("28/12/1959")));
            this.authors.put(2, new Author(2)
                    .withFirstName("Lisa")
                    .withLastName("Regan")
                    .withBirthDate(dateFormat.parse("31/12/1979")));
            this.authors.put(3, new Author(3)
                    .withFirstName("Ty")
                    .withLastName("Patterson")
                    .withBirthDate(dateFormat.parse("11/06/1964")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Collection<Author> getAuthors() {
        return this.authors.values();
    }

    public Author findById(int id) {
        return this.authors.get(id);
    }
}
