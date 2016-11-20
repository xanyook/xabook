package org.xanyook.xabook.repository;

import org.springframework.stereotype.Repository;
import org.xanyook.xabook.model.Type;
import org.xanyook.xabook.model.util.enumeration.BookTypeEnum;

@Repository
public interface TypeRepository extends XabookRepository<Type, Long> {

    public Type findBybookType(BookTypeEnum value);

}
