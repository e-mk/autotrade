package am.autotrade.repository;

import java.util.Set;

public interface CustomCarRepository {

    Set<Integer> findAllDistinctYears();

    Set<String> findAllDistinctBrandsByYear(int year);
}
