package org.xanyook.xabook.repository;

import org.springframework.data.repository.CrudRepository;
import org.xanyook.xabook.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author findById(Long id);

}
