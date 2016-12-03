package org.xanyook.xabook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xanyook.xabook.exception.EntityNotFoundException;
import org.xanyook.xabook.model.Author;
import org.xanyook.xabook.model.Book;
import org.xanyook.xabook.model.Type;
import org.xanyook.xabook.model.util.transformer.BookTransformer;
import org.xanyook.xabook.repository.AuthorRepository;
import org.xanyook.xabook.repository.BookRepository;
import org.xanyook.xabook.repository.TypeRepository;
import org.xanyook.xabook.service.model.BookToBeCreated;
import org.xanyook.xabook.service.model.GetBook;

@Service
public class BookService implements IBookService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository   bookRepository;

    @Autowired
    private TypeRepository   TypeRepository;

    @Override
    public GetBook createBook(long authorId, BookToBeCreated book) throws EntityNotFoundException {

        final Author CheckedAuthor = authorRepository.checkAndGetEntity( authorId );

        final Type type = TypeRepository.findBybookType( book.getType() );

        final Book entity = BookTransformer.getToBeCreatedAuthorConverter().apply( book );
        entity.setType( type );
        entity.setAuthor( CheckedAuthor );
        final Book savedBook = bookRepository.save( entity );

        return BookTransformer.getBookConverter().apply( savedBook );
    }

    @Override
    public void deleteBoook(final Long authorId, final Long bookId) throws EntityNotFoundException {
        authorRepository.checkAndGetEntity( authorId );
        final Book book = bookRepository.checkAndGetEntity( bookId );
        bookRepository.delete( book );
    }

}
