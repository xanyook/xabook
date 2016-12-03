package org.xanyook.xabook.repository;

import org.springframework.stereotype.Repository;
import org.xanyook.xabook.model.Author;

@Repository
public interface AuthorRepository extends XabookRepository<Author, Long> {

}