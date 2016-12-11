package org.xanyook.xabook.controller;

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
import org.xanyook.xabook.service.model.Documentation;
import org.xanyook.xabook.service.model.GetAuthor;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping( "/authors/" )
@Api( value = "authors Web Services" )
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @ApiOperation( value = "Create a new author", notes = "Allow user to create a new author resource" )
    @ApiResponses( value = {
            @ApiResponse( code = 201, message = Documentation.CREATED_201_DESCRIPTION, response = GetAuthor.class ),
            @ApiResponse( code = 404, message = Documentation.NOT_FOUND_404_DESCRIPTION ),
            @ApiResponse( code = 500, message = Documentation.INTERNAL_ERROR_500_DESCRIPTION ) } )
    @PostMapping( path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ResponseStatus( code = HttpStatus.CREATED )
    public GetAuthor createAuthor(
        // @formatter:off
            @ApiParam(required = true, value = Documentation.AUTHOR_TO_BE_CREATED_DESCRIPTION)
            @RequestBody @NotNull AuthorToBeCreated AuthorToBeCreated
        // @formatter:on
    ) throws AuthorException {
        return authorService.createAuthor( AuthorToBeCreated );
    }

    @ApiOperation( value = "Delete existing author", notes = "allow user to delete an existing author resource with all his books" )
    @ApiResponses( value = { @ApiResponse( code = 204, message = Documentation.DELETE_204_DESCRIPTION ),
            @ApiResponse( code = 404, message = Documentation.NOT_FOUND_404_DESCRIPTION ),
            @ApiResponse( code = 500, message = Documentation.INTERNAL_ERROR_500_DESCRIPTION ) } )
    @DeleteMapping( path = "{authorId}" )
    @ResponseStatus( code = HttpStatus.NO_CONTENT )
    public void deleteAuthor(
        // @formatter:off
            @ApiParam(name = Documentation.AUTHOR_ID, required = true, value = Documentation.AUTHOR_ID_DESCRIPTION)
            @PathVariable( name = Documentation.AUTHOR_ID ) final Long authorId
        // @formatter:on
    ) throws EntityNotFoundException {
        authorService.deleteAuthor( authorId );
    }

    @ApiOperation( value = "Get an existing author", notes = "Allow user to get an existing author resource" )
    @ApiResponses( value = {
            @ApiResponse( code = 200, message = Documentation.GET_200_DESCRIPTION, response = GetAuthor.class ),
            @ApiResponse( code = 404, message = Documentation.NOT_FOUND_404_DESCRIPTION ),
            @ApiResponse( code = 500, message = Documentation.INTERNAL_ERROR_500_DESCRIPTION ) } )
    @GetMapping( path = "{authorId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ResponseStatus( code = HttpStatus.OK )
    public HttpEntity<GetAuthor> getAuthor(
        // @formatter:off
            @ApiParam(name = Documentation.AUTHOR_ID, required = true, value = Documentation.AUTHOR_ID_DESCRIPTION)
            @PathVariable( name = Documentation.AUTHOR_ID ) @NotNull final Long authorId
        // @formatter:on
    ) throws EntityNotFoundException {
        final GetAuthor author = authorService.getAuthor( authorId );

        author.add( ControllerLinkBuilder
                .linkTo( ControllerLinkBuilder.methodOn( AuthorController.class ).getAuthor( authorId ) )
                .withSelfRel() );

        return new ResponseEntity<GetAuthor>( author, HttpStatus.OK );
    }
}
