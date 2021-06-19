package org.slipp.masil.games.web;

import org.junit.jupiter.api.Test;
import org.slipp.masil.games.application.HighLowApplicationService;
import org.slipp.masil.games.domains.highrow.GuessHighLowNumber;
import org.slipp.masil.games.domains.highrow.HighLowJudgement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class PlayControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    HighLowApplicationService highLowApplicationService;

    @Test
    void low_result_playing() throws Exception {
        when(highLowApplicationService.start("mike")).thenReturn(1L);
        when(highLowApplicationService.play(GuessHighLowNumber.of(1L, 3L)))
                .thenReturn(HighLowJudgement.LOW);

        mockMvc.perform(post("/games/{gameId}/turn", 1)
                .param("guessNumber", "3")
                .param("contextId", "1")
                .param("userName", "mike")
        )
                .andExpect(view().name("playingHighLowGame"))
                .andExpect(model().attribute("result", "LOW"))
                .andExpect(model().attribute("contextId", 1L))
                .andExpect(model().attribute("userName", "mike"));
    }

    @Test
    void high_result_playing() throws Exception {
        when(highLowApplicationService.start("mike")).thenReturn(1L);
        when(highLowApplicationService.play(GuessHighLowNumber.of(1L, 3L)))
                .thenReturn(HighLowJudgement.HIGH);

        mockMvc.perform(post("/games/{gameId}/turn", 1)
                .param("guessNumber", "3")
                .param("contextId", "1")
                .param("userName", "mike")
        )
                .andExpect(view().name("playingHighLowGame"))
                .andExpect(model().attribute("result", "HIGH"))
                .andExpect(model().attribute("contextId", 1L))
                .andExpect(model().attribute("userName", "mike"));
    }

    @Test
    void match_result_playing() throws Exception {
        when(highLowApplicationService.start("mike")).thenReturn(1L);
        when(highLowApplicationService.play(GuessHighLowNumber.of(1L, 3L)))
                .thenReturn(HighLowJudgement.MATCH);

        mockMvc.perform(post("/games/{gameId}/turn", 1)
                .param("guessNumber", "3")
                .param("contextId", "1")
                .param("userName", "mike")
        )
                .andExpect(view().name("redirect:/rankingView"))
                .andExpect(status().is3xxRedirection())
                .andExpect(model().attribute("result", "MATCH"))
                .andExpect(model().attribute("contextId", 1L))
                .andExpect(model().attribute("userName", "mike"));
    }
}
