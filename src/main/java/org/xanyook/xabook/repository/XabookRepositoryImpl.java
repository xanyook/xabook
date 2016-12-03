package org.xanyook.xabook.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.xanyook.xabook.exception.EntityNotFoundException;

public class XabookRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
        implements XabookRepository<T, ID> {

    private final EntityManager entityManager;

    public XabookRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        super( entityInformation, entityManager );
        this.entityManager = entityManager;
    }

    @Override
    public T checkAndGetEntity(ID id) throws EntityNotFoundException {

        if (!exists( id )) {
            throw new EntityNotFoundException();
        }
        return findOne( id );
    }

}
