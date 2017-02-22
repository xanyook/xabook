package org.xanyook.xabook.repository;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.xanyook.xabook.exception.EntityNotFoundException;

import javax.persistence.EntityManager;
import java.io.Serializable;

import static org.xanyook.xabook.exception.EntityNotFoundException.NotFoundCode.RESSOURCE_NOT_FOUND;

public class XabookRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements XabookRepository<T, ID> {

    private final EntityManager entityManager;

    public XabookRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        super( entityInformation, entityManager );
        this.entityManager = entityManager;
    }

    @Override
    public T checkAndGetEntity(ID id) throws EntityNotFoundException {

        if (!exists( id )) {
            throw new EntityNotFoundException(RESSOURCE_NOT_FOUND).set("id", id);
        }
        return findOne( id );
    }

}
