package org.slipp.masil.games.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = GamesController.class)
class GamesControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void indexView() throws Exception {
        mockMvc.perform(get("/games"))
                .andExpect(view().name("gameLounge"))
                .andReturn();
    }
}
