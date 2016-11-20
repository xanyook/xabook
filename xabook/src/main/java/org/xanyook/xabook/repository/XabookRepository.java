package org.xanyook.xabook.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.xanyook.xabook.exception.EntityNotFoundException;

@NoRepositoryBean
public interface XabookRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

    T checkAndGetEntity(ID id) throws EntityNotFoundException;

}
