package org.xanyook.xabook.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.xanyook.xabook.exception.AuthorException;
import org.xanyook.xabook.exception.EntityNotFoundException;
import org.xanyook.xabook.service.IAuthorService;
import org.xanyook.xabook.service.model.AuthorToBeCreated;
import org.xanyook.xabook.service.model.GetAuthor;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( "/authors/" )
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @ApiOperation( value = "Create a new Author" )
    @PostMapping( path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ResponseStatus( code = HttpStatus.CREATED )
    public GetAuthor createAuthor(
        // @formatter:off
            @RequestBody @NotNull AuthorToBeCreated AuthorToBeCreated
        // @formatter:on
    ) throws AuthorException {
        return authorService.createAuthor( AuthorToBeCreated );
    }

    @Valid
    @ApiOperation( value = "Delete author by ID" )
    @DeleteMapping( path = "{authorId}" )
    @ResponseStatus( code = HttpStatus.NO_CONTENT )
    public void deleteAuthor(
        // @formatter:off
            @PathVariable( name = "authorId" ) final Long authorId
        // @formatter:on
    ) throws EntityNotFoundException {
        authorService.deleteAuthor( authorId );
    }

    @ApiOperation( value = "get author by ID" )
    @GetMapping( path = "{authorId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ResponseStatus( code = HttpStatus.CREATED )
    public HttpEntity<GetAuthor> getAuthor(
        // @formatter:off
            @PathVariable( name = "authorId" ) @NotNull final Long authorId
        // @formatter:on
    ) throws EntityNotFoundException {
        final GetAuthor author = authorService.getAuthor( authorId );

        author.add( ControllerLinkBuilder
                .linkTo( ControllerLinkBuilder.methodOn( AuthorController.class ).getAuthor( authorId ) )
                .withSelfRel() );

        return new ResponseEntity<GetAuthor>( author, HttpStatus.OK );
    }
}
