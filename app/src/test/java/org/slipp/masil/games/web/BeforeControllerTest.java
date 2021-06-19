package org.slipp.masil.games.web;

import org.junit.jupiter.api.Test;
import org.slipp.masil.games.application.HighLowApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest
class BeforeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    HighLowApplicationService highLowApplicationService;

    @Test
    void postUserNameAndGameStart() throws Exception {
        given(highLowApplicationService.start("mike")).willReturn(1L);
        
        mockMvc.perform(post("/games/{gameId}", 1)
                .param("userName", "mike")
        )
                .andExpect(view().name("playingHighLowGame"))
                .andExpect(model().attributeExists("contextId"))
                .andExpect(model().attribute("userName", "mike"));
    }
}
