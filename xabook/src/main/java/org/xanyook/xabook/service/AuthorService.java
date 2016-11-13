package org.xanyook.xabook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xanyook.xabook.exception.AuthorException;
import org.xanyook.xabook.model.Author;
import org.xanyook.xabook.repository.AuthorRepository;
import org.xanyook.xabook.service.model.GetAuthor;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void deleteAuthor(final long id) throws AuthorException {

        if (!authorRepository.exists( id )) {
            throw new AuthorException( "Impossible de trouver l'auteur d'ID " + id );
        }
        authorRepository.delete( id );
    }

    @Override
    public GetAuthor getAuthor(final long id) throws AuthorException {

        final Author entry = authorRepository.findOne( id );
        if (null == entry) {
            throw new AuthorException( "Impossible de trouver l'auteur d'ID " + id );
        }

        final GetAuthor author = new GetAuthor();
        author.setBiography( entry.getBiography() );
        author.setBirthdate( entry.getBirthdate() );
        author.setDeathDate( entry.getDeathDate() );
        author.setFirstName( entry.getFirstName() );
        author.setId( entry.getId() );
        author.setLastName( entry.getLastName() );

        return author;
    }

}
