package org.xanyook.xabook.controller;

import io.swagger.annotations.*;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.xanyook.xabook.exception.AuthorException;
import org.xanyook.xabook.exception.EntityNotFoundException;
import org.xanyook.xabook.service.IAuthorService;
import org.xanyook.xabook.service.model.AuthorToBeCreated;
import org.xanyook.xabook.service.model.Documentation;
import org.xanyook.xabook.service.model.GetAuthor;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.net.URI;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/authors")
@Api(value = "authors Web Services")
public class AuthorController {

    @Inject
    private IAuthorService authorService;

    //@formatter:off
    @ApiOperation(value = "Create a new author", notes = "Allow user to create a new author resource")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = Documentation.CREATED_201_DESCRIPTION, response = GetAuthor.class),
            @ApiResponse(code = 404, message = Documentation.NOT_FOUND_404_DESCRIPTION),
            @ApiResponse(code = 500, message = Documentation.INTERNAL_ERROR_500_DESCRIPTION) })
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> createAuthor(
            @ApiParam(required = true, value = Documentation.AUTHOR_TO_BE_CREATED_DESCRIPTION)
            @RequestBody @NotNull AuthorToBeCreated AuthorToBeCreated)
            throws AuthorException {
        GetAuthor author = authorService.createAuthor(AuthorToBeCreated);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{authorId}").buildAndExpand(author.getAuthorId()).toUri();
        return created(location).build();
    }

    @ApiOperation(value = "Delete existing author", notes = "allow user to delete an existing author resource with all his books")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = Documentation.DELETE_204_DESCRIPTION),
            @ApiResponse(code = 404, message = Documentation.NOT_FOUND_404_DESCRIPTION),
            @ApiResponse(code = 500, message = Documentation.INTERNAL_ERROR_500_DESCRIPTION) })
    @DeleteMapping(path = "{authorId}")
    public ResponseEntity<Void> deleteAuthor(
            @ApiParam(name = Documentation.AUTHOR_ID, required = true, value = Documentation.AUTHOR_ID_DESCRIPTION)
            @PathVariable(name = Documentation.AUTHOR_ID) final Long authorId)
            throws EntityNotFoundException {
        authorService.deleteAuthor(authorId);
        return noContent().build();
    }

    @ApiOperation(value = "Get an existing author", notes = "Allow user to get an existing author resource")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = Documentation.GET_200_DESCRIPTION, response = GetAuthor.class),
            @ApiResponse(code = 404, message = Documentation.NOT_FOUND_404_DESCRIPTION),
            @ApiResponse(code = 500, message = Documentation.INTERNAL_ERROR_500_DESCRIPTION) })
    @GetMapping(path = "{authorId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<GetAuthor> getAuthor(
            @ApiParam(name = Documentation.AUTHOR_ID, required = true, value = Documentation.AUTHOR_ID_DESCRIPTION)
            @PathVariable(name = Documentation.AUTHOR_ID) @NotNull final Long authorId)
            throws EntityNotFoundException {
        final GetAuthor author = authorService.getAuthor(authorId);
        author.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(AuthorController.class).getAuthor(authorId)).withSelfRel());
        return ok(author);
    }
    //@formatter:off
}
