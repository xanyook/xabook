package org.xanyook.xabook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xanyook.xabook.exception.EntityNotFoundException;
import org.xanyook.xabook.model.Author;
import org.xanyook.xabook.model.util.transformer.AuthorTransformer;
import org.xanyook.xabook.repository.AuthorRepository;
import org.xanyook.xabook.service.model.AuthorToBeCreated;
import org.xanyook.xabook.service.model.GetAuthor;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public GetAuthor createAuthor(final AuthorToBeCreated authorToBeCreated) {

        final Author entity = AuthorTransformer.getToBeCreatedAuthorConverter().apply( authorToBeCreated );
        final Author savedAuthor = authorRepository.save( entity );

        return AuthorTransformer.getAuthorConverter().apply( savedAuthor );
    }

    @Override
    public void deleteAuthor(final long id) throws EntityNotFoundException {

        final Author author = authorRepository.checkAndGetEntity( id );
        authorRepository.delete( id );
    }

    @Override
    public GetAuthor getAuthor(final long id) throws EntityNotFoundException {
        final Author author = authorRepository.checkAndGetEntity( id );
        return AuthorTransformer.getAuthorConverter().apply( author );
    }

}
