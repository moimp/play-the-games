package org.slipp.masil.games.web;

import org.junit.jupiter.api.Test;
import org.slipp.masil.games.application.HighLowApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest
class GamesControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    HighLowApplicationService applicationService;

    @MockBean
    RankingController rankingController;

    @Test
    void indexView() throws Exception {
        mockMvc.perform(get("/games"))
                .andExpect(view().name("gameLounge"))
                .andReturn();
    }
}
