package org.xanyook.xabook.model.util.transformer;

import org.xanyook.xabook.model.Author;
import org.xanyook.xabook.service.model.AuthorToBeCreated;
import org.xanyook.xabook.service.model.GetAuthor;

import java.util.function.Function;

public final class AuthorTransformer {

    private AuthorTransformer() {
        super();
    }

    public static Function<Author, GetAuthor> getAuthorConverter() {

        return new Function<Author, GetAuthor>() {

            @Override
            public GetAuthor apply(Author entity) {
                final GetAuthor author = new GetAuthor();
                author.setAuthorId(entity.getId());
                author.setBiography( entity.getBiography() );
                author.setBirthdate( entity.getBirthdate() );
                author.setDeathDate( entity.getDeathDate() );
                author.setFirstName( entity.getFirstName() );
                author.setLastName( entity.getLastName() );

                return author;
            }
        };
    }

    public static Function<AuthorToBeCreated, Author> getToBeCreatedAuthorConverter() {
        return new Function<AuthorToBeCreated, Author>() {

            @Override
            public Author apply(AuthorToBeCreated t) {
                final Author entity = new Author();
                entity.setBiography( t.getBiography() );
                entity.setBirthdate( t.getBirthdate() );
                entity.setDeathDate( t.getDeathDate() );
                entity.setFirstName( t.getFirstName() );
                entity.setLastName( t.getLastName() );

                return entity;
            }
        };
    }

}
