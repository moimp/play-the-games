package org.slipp.masil.games.domains.highrow;

import org.junit.jupiter.api.Test;
import org.slipp.masil.games.domains.game.GameId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;

@SpringBootTest
@ActiveProfiles("local")
@Transactional
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
class HighLowPlayingContextRepositoryTest {

	@Autowired
	HighLowPlayingContextRepository repository;

	HighLowPlayingContext play;

	@Test
	@Rollback
	void saveAndFind() {

		GameId gameId = GameId.of(1L);
		String userName = "Len";
		play = HighLowPlayingContext.by(gameId, userName, Target.of(10L));

		HighLowPlayingContext save = repository.save(play);
		HighLowPlayingContext find = repository.findById(save.getId());

		assertThat(find.getTarget()).isEqualTo(10L);
	}
}
