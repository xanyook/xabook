package org.xanyook.xabook.service;

import org.xanyook.xabook.exception.EntityNotFoundException;
import org.xanyook.xabook.service.model.AuthorToBeCreated;
import org.xanyook.xabook.service.model.GetAuthor;

public interface IAuthorService {

    GetAuthor createAuthor(AuthorToBeCreated authorToBeCreated);

    void deleteAuthor(long id) throws EntityNotFoundException;

    GetAuthor getAuthor(long id) throws EntityNotFoundException;

}
