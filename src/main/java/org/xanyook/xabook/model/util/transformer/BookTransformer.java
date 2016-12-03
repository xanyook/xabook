package org.xanyook.xabook.model.util.transformer;

import java.util.function.Function;

import org.xanyook.xabook.model.Book;
import org.xanyook.xabook.service.model.BookToBeCreated;
import org.xanyook.xabook.service.model.GetBook;

public final class BookTransformer {

    public static Function<Book, GetBook> getBookConverter() {

        return new Function<Book, GetBook>() {

            @Override
            public GetBook apply(Book t) {
                final GetBook e = new GetBook();
                e.setDescription( t.getDescription() );
                e.setId( t.getId() );
                e.setIsbn( t.getIsbn() );
                e.setTitle( t.getTitle() );
                e.setType( t.getType().getBookType() );

                return e;
            }
        };

    }

    public static Function<BookToBeCreated, Book> getToBeCreatedAuthorConverter() {
        return new Function<BookToBeCreated, Book>() {

            @Override
            public Book apply(BookToBeCreated t) {
                final Book e = new Book();

                e.setDescription( t.getDescription() );
                e.setIsbn( t.getIsbn() );
                e.setTitle( t.getTitle() );

                return e;
            }
        };
    }

    private BookTransformer() {
        super();
    }

}
