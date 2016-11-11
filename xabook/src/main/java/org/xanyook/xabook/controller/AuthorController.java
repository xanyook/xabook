package org.xanyook.xabook.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( "/authors" )
public class AuthorController {

    @ApiOperation( value = "get author by ID" )
    @RequestMapping( method = RequestMethod.GET, path = "/{authorId}", produces = MediaType.APPLICATION_JSON_VALUE )
    public String getAuthor(@PathVariable( name = "authorId" ) Long authorId) {

        return String.format( "you are looking for author %d", authorId );
    }
}
