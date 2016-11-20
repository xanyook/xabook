package org.xanyook.xabook.repository;

import org.springframework.stereotype.Repository;
import org.xanyook.xabook.model.Book;

@Repository
public interface BookRepository extends XabookRepository<Book, Long> {

}