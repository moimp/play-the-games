package org.slipp.masil.games.web;

import org.junit.jupiter.api.Test;
import org.slipp.masil.games.application.HighLowApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest
class IndexControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    HighLowApplicationService applicationService;

    @Test
    void indexView() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(view().name("index"))
                .andReturn();
    }


    @Test
    void startHighLowGameButton() throws Exception {
        mockMvc.perform(get("/games/{gameId}", 1))
                .andExpect(view().name("beforeHighLowGameView"))
                .andDo(print())
                .andExpect(model().attribute("gameId", "1"));
    }
}
