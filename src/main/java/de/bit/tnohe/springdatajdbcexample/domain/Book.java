package de.bit.tnohe.springdatajdbcexample.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;

@Table("Book_Author")
public class Book {

    @Id
    private Long id;

    private String title;

    public Set<AuthorRef> authors = new HashSet<>();

    public void addAuthor(Author author) {
        authors.add(createAuthorRef(author));
    }

    private AuthorRef createAuthorRef(Author author) {
        Assert.notNull(author, "Author must not be null");
        Assert.notNull(author.getId(), "Author id, must not be null");

        AuthorRef authorRef = new AuthorRef();
        authorRef.setAuthor(author.getId());
        authorRef.setBook(this.id);
        return authorRef;
    }

}
