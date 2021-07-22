package org.slipp.masil.games.infrastructures.jdbc;

import org.slipp.masil.games.domains.baseball.BaseballTarget;
import org.slipp.masil.games.domains.baseball.BaseballTargetRepository;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = BaseballTarget.class, idClass = Long.class)
public interface JdbcBaseballTargetRepository extends BaseballTargetRepository {


}
