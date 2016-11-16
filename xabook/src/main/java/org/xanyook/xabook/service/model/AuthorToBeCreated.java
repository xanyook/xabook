package org.xanyook.xabook.service.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class AuthorToBeCreated {

    @NotNull
    private String biography;
    @NotNull
    private Date   birthdate;
    private Date   deathDate;
    @NotNull
    private String firstName;
    @NotNull
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
