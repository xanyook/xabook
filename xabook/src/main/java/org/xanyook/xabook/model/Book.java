package org.xanyook.xabook.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table( name = "book", uniqueConstraints = { @UniqueConstraint( name = "UC_ISBN", columnNames = { "ISBN" } ) } )
@Access( AccessType.FIELD )
public class Book implements Serializable {

    private static final long serialVersionUID = 826016048875608113L;

    @ManyToOne( optional = false )
    @JoinColumn( name = "AUTHOR_ID  " )
    private Author            author;

    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "ID", nullable = false, scale = 10 )
    @Id
    private Long              id;

    @Column( name = "ISBN", nullable = false, length = 13, unique = true )
    private String            isbn;

    @Column( name = "TITLE", nullable = false, length = 200 )
    private String            title;

    public Author getAuthor() {
        return author;
    }

    public Long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
