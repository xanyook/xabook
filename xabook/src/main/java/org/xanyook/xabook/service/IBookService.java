package org.xanyook.xabook.service;

import org.xanyook.xabook.service.model.BookToBeCreated;
import org.xanyook.xabook.service.model.GetBook;

public interface IBookService {

    public GetBook createBook(long authorId, BookToBeCreated book);

}
