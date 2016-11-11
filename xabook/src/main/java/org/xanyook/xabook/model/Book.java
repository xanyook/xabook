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
import javax.persistence.OneToOne;
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

    @Column( name = "DESCRIPTION", length = 2000 )
    private String            description;

    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "ID", nullable = false, scale = 10 )
    @Id
    private Long              id;

    @OneToOne( optional = false )
    @JoinColumn( name = "IMAGE_ID  " )
    private Image             image;

    @Column( name = "ISBN", nullable = false, length = 13, unique = true )
    private String            isbn;

    @Column( name = "TITLE", nullable = false, length = 200 )
    private String            title;

    @ManyToOne( optional = false )
    @JoinColumn( name = "TYPE_ID" )
    private Type              type;

    public Author getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public Image getImage() {
        return image;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
