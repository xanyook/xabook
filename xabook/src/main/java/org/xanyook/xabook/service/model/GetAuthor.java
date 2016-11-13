package org.xanyook.xabook.service.model;

import java.util.Date;

public class GetAuthor {

    private String biography;
    private Date   birthdate;
    private Date   deathDate;
    private String firstName;
    private Long   id;
    private String lastName;

    public String getBiography() {
        return biography;
    }

    public Date getBirthdate() {
        return birthdate;
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
