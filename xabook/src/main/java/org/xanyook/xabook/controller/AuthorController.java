package org.xanyook.xabook.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xanyook.xabook.exception.AuthorException;
import org.xanyook.xabook.service.IAuthorService;
import org.xanyook.xabook.service.model.AuthorToBeCreated;
import org.xanyook.xabook.service.model.GetAuthor;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( "/authors" )
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @ApiOperation( value = "get author by ID" )
    @RequestMapping( method = RequestMethod.GET, path = "/{authorId}", produces = MediaType.APPLICATION_JSON_VALUE )
    public GetAuthor createAuthor(@PathVariable( name = "authorId" ) @NotNull final Long authorId)
            throws AuthorException {
        return authorService.getAuthor( authorId );
    }

    @Valid
    @ApiOperation( value = "Delete author by ID" )
    @RequestMapping( method = RequestMethod.DELETE, path = "/{authorId}" )
    public void deleteAuthor(@PathVariable( name = "authorId" ) final Long authorId) throws AuthorException {
        authorService.deleteAuthor( authorId );
    }

    @ApiOperation( value = "Create a new Author" )
    @RequestMapping( method = RequestMethod.POST, path = "/", produces = MediaType.APPLICATION_JSON_VALUE )
    public GetAuthor getAuthor(@RequestBody @NotNull AuthorToBeCreated AuthorToBeCreated) throws AuthorException {
        return authorService.createAuthor( AuthorToBeCreated );
    }
}
