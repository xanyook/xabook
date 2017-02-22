package org.xanyook.xabook.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.xanyook.xabook.exception.EntityNotFoundException;

import java.io.Serializable;

@NoRepositoryBean
public interface XabookRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

    T checkAndGetEntity(ID id) throws EntityNotFoundException;

}
