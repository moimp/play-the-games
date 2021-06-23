package org.slipp.masil.games.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GamesController {

    @GetMapping(value = "/games")
    public ModelAndView games() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gameLounge");
        modelAndView.addObject("gameId", "1");

        return modelAndView;
    }
}
