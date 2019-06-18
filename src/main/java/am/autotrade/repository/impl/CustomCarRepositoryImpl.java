package am.autotrade.repository.impl;

import am.autotrade.repository.custom.CustomCarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;

public class CustomCarRepositoryImpl implements CustomCarRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Set<Integer> findAllDistinctYears() {
        List<Integer> distinctYears = entityManager
                .createQuery(
                        "select distinct c.year " +
                                "from CarEntity c " +
                                "order by c.year", Integer.class)
                .getResultList();

        return Set.copyOf(distinctYears);
    }

    @Override
    public Set<String> findAllDistinctBrandsByYear(int year) {
        List<String> distinctYears = entityManager
                .createQuery(
                        "select distinct c.brand " +
                                "from CarEntity c " +
                                "where c.year = ?1", String.class)
                .setParameter(1, year)
                .getResultList();

        return Set.copyOf(distinctYears);
    }
}
