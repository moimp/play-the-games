package org.slipp.masil.games.web;

import org.junit.jupiter.api.Test;
import org.slipp.masil.games.application.HighLowApplicationService;
import org.slipp.masil.games.domains.game.GameId;
import org.slipp.masil.games.domains.ranking.Ranking;
import org.slipp.masil.games.domains.ranking.RankingId;
import org.slipp.masil.games.domains.ranking.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class RankingControllerTest {


    @Autowired
    MockMvc mockMvc;

    @MockBean
    RankingRepository repository;

    @MockBean
    HighLowApplicationService highLowApplicationService;

    @Test
    void rankingView() throws Exception {
        Ranking ranking = Ranking.of(GameId.of(1L), 10);
        when(repository.findById(RankingId.of(1L))).thenReturn(ranking);

        mockMvc.perform(get("/ranking/{gameId}", "1"))
                .andExpect(view().name("rankingView"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("gameId", "1"))
                .andExpect(model().attributeExists("ranking"))
        ;
    }
}