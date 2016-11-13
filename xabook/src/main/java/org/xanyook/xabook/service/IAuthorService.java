package org.xanyook.xabook.service;

import org.xanyook.xabook.exception.AuthorException;
import org.xanyook.xabook.service.model.GetAuthor;

public interface IAuthorService {

    void deleteAuthor(long id) throws AuthorException;

    GetAuthor getAuthor(long id) throws AuthorException;

}
