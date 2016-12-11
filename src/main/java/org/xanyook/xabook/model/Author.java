package org.xanyook.xabook.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table( name = "author" )
@Access( AccessType.FIELD )
public class Author implements Serializable {

    private static final long serialVersionUID = 6723741467516233314L;

    @Column( name = "BIOGRAPHY", nullable = true, length = 2000 )
    private String            biography;

    @Column( name = "BIRTH_DATE", nullable = false )
    @Temporal( TemporalType.TIMESTAMP )
    private Date              birthdate;

    @OneToMany( mappedBy = "author", fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE } )
    private Set<Book>         books;

    @ColumnDefault( "NOW()" )
    @Column( name = "CREATION_DATE", insertable = false )
    @Temporal( TemporalType.TIMESTAMP )
    private Date              creationDate;

    @Column( name = "DEATH_DATE" )
    @Temporal( TemporalType.TIMESTAMP )
    private Date              deathDate;

    @Column( name = "FIRST_NAME", nullable = false, length = 45 )
    private String            firstName;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "ID", nullable = false, scale = 10 )
    private Long              id;

    @OneToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "IMAGE_ID" )
    private Image             image;

    @ColumnDefault( "NOW()" )
    @Column( name = "LAST_MODIFICATION_DATE", insertable = false )
    @Temporal( TemporalType.TIMESTAMP )
    private Date              lastModificationDate;

    @Column( name = "LAST_NAME", nullable = false, length = 45 )
    private String            lastName;

    public String getBiography() {
        return biography;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public Set<Book> getBooks() {
        if (null == books) {
            books = new HashSet<>();
        }
        return books;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
