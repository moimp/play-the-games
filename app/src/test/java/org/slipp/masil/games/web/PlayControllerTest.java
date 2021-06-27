package org.slipp.masil.games.web;

import org.junit.jupiter.api.Test;
import org.slipp.masil.games.application.HighLowApplicationService;
import org.slipp.masil.games.domains.highrow.GuessHighLowNumber;
import org.slipp.masil.games.domains.highrow.HighLowJudgement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = PlayController.class)
class PlayControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    HighLowApplicationService highLowApplicationService;

    @Test
    void startHighLowGameButton() throws Exception {
        mockMvc.perform(get("/games/{gameId}", 1))
                .andExpect(view().name("highlow/beforePlaying"))
                .andDo(print())
                .andExpect(model().attribute("gameId", "1"));
    }

    @Test
    void userNameAndGameStart() throws Exception {
        //TODO 어떤 테스트를 해야 할까?
        mockMvc.perform(post("/games/{gameId}", 1)
                .param("userName", "mike")
                .param("level", "EASY")
        )
                .andExpect(view().name("highlow/playing"))
                .andExpect(model().attributeExists("contextId"))
                .andExpect(model().attribute("userName", "mike"));
    }

    @Test
    void low_result_playing() throws Exception {
        when(highLowApplicationService.play(GuessHighLowNumber.of(1L, 3L)))
                .thenReturn(HighLowJudgement.LOW);

        mockMvc.perform(post("/games/{gameId}/turn", 1)
                .param("guessNumber", "3")
                .param("contextId", "1")
                .param("userName", "mike")
        )
                .andExpect(view().name("highlow/playing"))
                .andExpect(model().attribute("result", "LOW"))
                .andExpect(model().attribute("contextId", 1L))
                .andExpect(model().attribute("gameId", "1"))
                .andExpect(model().attribute("userName", "mike"));
    }

    @Test
    void high_result_playing() throws Exception {
        when(highLowApplicationService.play(GuessHighLowNumber.of(1L, 3L)))
                .thenReturn(HighLowJudgement.HIGH);

        mockMvc.perform(post("/games/{gameId}/turn", 1)
                .param("guessNumber", "3")
                .param("contextId", "1")
                .param("userName", "mike")
        )
                .andExpect(view().name("highlow/playing"))
                .andExpect(model().attribute("result", "HIGH"))
                .andExpect(model().attribute("contextId", 1L))
                .andExpect(model().attribute("gameId", "1"))
                .andExpect(model().attribute("userName", "mike"));
    }

    @Test
    void match_result_playing() throws Exception {
        when(highLowApplicationService.play(GuessHighLowNumber.of(1L, 3L)))
                .thenReturn(HighLowJudgement.MATCH);

        mockMvc.perform(post("/games/{gameId}/turn", 1)
                .param("guessNumber", "3")
                .param("contextId", "1")
                .param("userName", "mike")
        )
                .andExpect(view().name("highlow/playing"))
                .andExpect(model().attribute("result", "MATCH"))
                .andExpect(model().attribute("contextId", 1L))
                .andExpect(model().attribute("gameId", "1"))
                .andExpect(model().attribute("userName", "mike"));
    }
}
