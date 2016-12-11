package org.xanyook.xabook.service.model;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel( value = "Author" )
public class GetAuthor extends ResourceSupport {

    private Long   authorId;
    private String biography;
    private Date   birthdate;
    private Date   deathDate;
    private String firstName;
    private String lastName;

    @ApiModelProperty( value = Documentation.AUTHOR_ID_DESCRIPTION, required = true )
    public Long getAuthorId() {
        return authorId;
    }

    @ApiModelProperty( value = Documentation.AUTHOR_BIOGRAPHY_DESCRIPTION, required = false )
    public String getBiography() {
        return biography;
    }

    @ApiModelProperty( value = Documentation.AUTHOR_BIRTHDATE_DESCRIPTION, required = true )
    public Date getBirthdate() {
        return birthdate;
    }

    @ApiModelProperty( value = Documentation.AUTHOR_BIRTHDATE_DESCRIPTION, required = false )
    public Date getDeathDate() {
        return deathDate;
    }

    @ApiModelProperty( value = Documentation.AUTHOR_FIRST_NAME_DESCRIPTION, required = true )
    public String getFirstName() {
        return firstName;
    }

    @ApiModelProperty( value = Documentation.AUTHOR_LAST_NAME_DESCRIPTION, required = true )
    public String getLastName() {
        return lastName;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
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
