
package org.xanyook.xabook.controller;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.xanyook.xabook.exception.EntityNotFoundException;
import org.xanyook.xabook.service.IBookService;
import org.xanyook.xabook.service.model.BookToBeCreated;
import org.xanyook.xabook.service.model.Documentation;
import org.xanyook.xabook.service.model.GetBook;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("authors/{authorId}/books/")
@Api(value = "Books Web Services")
public class BookController {

    @Inject
    private IBookService bookService;

    //@formatter:off
    @ApiOperation(value = "Create a new book", notes = "Allow user to create a new book resource")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = Documentation.CREATED_201_DESCRIPTION, response = GetBook.class),
            @ApiResponse(code = 404, message = Documentation.NOT_FOUND_404_DESCRIPTION),
            @ApiResponse(code = 500, message = Documentation.INTERNAL_ERROR_500_DESCRIPTION) })
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public GetBook createBook(
            @ApiParam(name = Documentation.AUTHOR_ID, required = true, value = Documentation.AUTHOR_ID_DESCRIPTION)
            @PathVariable(name = Documentation.AUTHOR_ID) Long authorId,
            @ApiParam(required = true, value = Documentation.BOOK_TO_BE_CREATED_DESCRIPTION)
            @RequestBody @NotNull BookToBeCreated bookToBeCreated)
            throws EntityNotFoundException {
        return bookService.createBook(authorId, bookToBeCreated);
    }

    @ApiOperation(value = "Delete existing book", notes = "allow user to delete an existing book resource")
    @ApiResponses( value = {
            @ApiResponse(code = 204, message = Documentation.DELETE_204_DESCRIPTION),
            @ApiResponse(code = 404, message = Documentation.NOT_FOUND_404_DESCRIPTION),
            @ApiResponse(code = 500, message = Documentation.INTERNAL_ERROR_500_DESCRIPTION) })
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{bookId}")
    public void deleteBook(
            @ApiParam(name = Documentation.AUTHOR_ID, required = true, value = Documentation.AUTHOR_ID_DESCRIPTION)
            @PathVariable(name = Documentation.AUTHOR_ID) Long authorId,
            @ApiParam(name = Documentation.BOOK_ID, required = true, value = Documentation.BOOK_ID_DESCRIPTION)
            @PathVariable(name = Documentation.BOOK_ID) Long bookId)
            throws EntityNotFoundException {
        bookService.deleteBoook(authorId, bookId);
    }

    @ApiOperation(value = "Get an existing book", notes = "Allow user to get an existing book resource")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = Documentation.GET_200_DESCRIPTION, response = GetBook.class),
            @ApiResponse(code = 404, message = Documentation.NOT_FOUND_404_DESCRIPTION),
            @ApiResponse(code = 500, message = Documentation.INTERNAL_ERROR_500_DESCRIPTION) })
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "{bookId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public GetBook getBook(
            @ApiParam(name = Documentation.AUTHOR_ID, required = true, value = Documentation.AUTHOR_ID_DESCRIPTION)
            @PathVariable(name = Documentation.AUTHOR_ID) Long authorId,
            @ApiParam(name = Documentation.BOOK_ID, required = true, value = Documentation.BOOK_ID_DESCRIPTION)
            @PathVariable(name = Documentation.BOOK_ID) Long bookId)
            throws EntityNotFoundException {
        return bookService.getBook(authorId, bookId);
    }
    //@formatter:on
}
