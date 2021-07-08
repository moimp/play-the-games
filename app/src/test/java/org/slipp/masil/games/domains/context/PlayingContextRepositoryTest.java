package org.slipp.masil.games.domains.context;

import org.junit.jupiter.api.Test;
import org.slipp.masil.games.domains.game.GameId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;

@SpringBootTest
@ActiveProfiles("local")
@Transactional
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
class PlayingContextRepositoryTest {

	@Autowired
	PlayingContextRepository repository;

	PlayingContext play;

	@Test
	@Rollback
	void saveAndFind() {

		GameId gameId = GameId.of(2L);
		String userName = "Len";
		play = PlayingContext.by(gameId, userName);

		PlayingContext save = repository.save(play);
		PlayingContext find = repository.findById(save.getId());

	}
}
