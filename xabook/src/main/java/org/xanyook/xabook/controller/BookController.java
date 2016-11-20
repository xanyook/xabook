package org.xanyook.xabook.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xanyook.xabook.exception.EntityNotFoundException;
import org.xanyook.xabook.service.IBookService;
import org.xanyook.xabook.service.model.BookToBeCreated;
import org.xanyook.xabook.service.model.GetBook;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( "authors/{authorId}/books/" )
public class BookController {

    @Autowired
    private IBookService bookService;

    @ApiOperation( value = "Create a new Book" )
    @RequestMapping( method = RequestMethod.POST, path = "/", produces = MediaType.APPLICATION_JSON_VALUE )
    public GetBook createBook(
        // @formatter:off
            @PathVariable(name ="authorId") Long authorId,
            @RequestBody @NotNull BookToBeCreated bookToBeCreated
        // @formatter:off
            ) throws EntityNotFoundException
{
        return bookService.createBook(authorId, bookToBeCreated);
    }

}
