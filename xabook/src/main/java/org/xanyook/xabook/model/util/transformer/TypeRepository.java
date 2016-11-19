package org.xanyook.xabook.model.util.transformer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.xanyook.xabook.model.Type;
import org.xanyook.xabook.model.util.enumeration.BookTypeEnum;

@Repository
public interface TypeRepository extends CrudRepository<Type, Long> {

    public Type findBybookType(BookTypeEnum value);

}
