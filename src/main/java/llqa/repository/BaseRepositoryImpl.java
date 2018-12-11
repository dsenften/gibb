package llqa.repository;

/**
 * User: Daniel Senften <daniel@senften.org>
 * Date: 2018-12-11, 12:51
 */

import com.google.common.collect.Iterables;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@SuppressWarnings("squid:S00119")
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements
        BaseRepository<T, ID> {

    private static final int SQL_IN_SIZE_LIMIT = 10000;

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
    }

    @Override
    public List<T> findAllById(Iterable<ID> iter) {
        Iterable<List<ID>> partitionedIter = Iterables.partition(iter, SQL_IN_SIZE_LIMIT);
        return StreamSupport.stream(partitionedIter.spliterator(), false)
                .map(super::findAllById)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}