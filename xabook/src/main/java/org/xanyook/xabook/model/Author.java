package org.xanyook.xabook.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "author" )
@Access( AccessType.FIELD )
public class Author implements Serializable {

    private static final long serialVersionUID = 6723741467516233314L;

    @Column( name = "BIRTH_DATE", nullable = false )
    @Temporal( TemporalType.TIMESTAMP )
    private Date              birthdate;

    @OneToMany( mappedBy = "author" )
    private Set<Book>         books;

    @Column( name = "DEATH_DATE" )
    @Temporal( TemporalType.TIMESTAMP )
    private Date              deathDate;

    @Column( name = "DESCRIPTION", nullable = false, length = 1000 )
    private String            description;

    @Column( name = "FIRST_NAME", nullable = false, length = 45 )
    private String            firstName;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "ID", nullable = false, scale = 10 )
    private Long              id;

    @Column( name = "LAST_NAME", nullable = false, length = 45 )
    private String            lastName;

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

    public String getDescription() {
        return description;
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

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public void setDescription(String description) {
        this.description = description;
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
