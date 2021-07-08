package org.slipp.masil.games.infrastructures.jdbc;

import org.slipp.masil.games.domains.context.PlayingContext;
import org.slipp.masil.games.domains.context.PlayingContextRepository;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = PlayingContext.class, idClass = Long.class)
public interface JdbcPlayingContextRepository extends PlayingContextRepository {

}
