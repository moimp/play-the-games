package org.slipp.masil.games.domains.baseball;

public interface BaseballTargetRepository {

    <S extends BaseballTarget> S save(S entity);
}
