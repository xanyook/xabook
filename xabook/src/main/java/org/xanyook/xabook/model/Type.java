package org.xanyook.xabook.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.xanyook.xabook.model.util.BookTypeEnum;

@Entity
@Table( name = "type" )
@Access( AccessType.FIELD )
public class Type implements Serializable {

    private static final long serialVersionUID = 3966633688075298569L;

    @OneToMany( mappedBy = "type" )
    private Set<Book>         books;

    @Enumerated( EnumType.STRING )
    @Column( name = "BOOK_TYPE", nullable = false, length = 45 )
    private BookTypeEnum      bookType;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "ID", nullable = false, scale = 10 )
    private Long              id;

    public Set<Book> getBooks() {
        return books;
    }

    public BookTypeEnum getBookType() {
        return bookType;
    }

    public Long getId() {
        return id;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void setBookType(BookTypeEnum bookType) {
        this.bookType = bookType;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
