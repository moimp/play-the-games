package org.slipp.masil.games.domains.baseball;


import org.junit.jupiter.api.Test;
import org.slipp.masil.games.domains.context.PlayingContextId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("local")
@Transactional
class BaseballTargetRepositoryTest {

    @Autowired
    BaseballTargetRepository repository;

    BaseballTarget target;

    @Test
    void exists() {
        assertThat(repository).isNotNull();
    }

    @Test
    @Rollback
    void saveTest() {

        target = BaseballTarget.of(PlayingContextId.of(1L), 10L);

        BaseballTarget saveTarget = repository.save(target);

        assertThat(saveTarget.getId()).isNotNull();
    }
}