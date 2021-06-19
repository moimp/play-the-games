package org.slipp.masil.games.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("gameId", 1);

        return modelAndView;
    }

    @GetMapping(value = "/games/{gameId}")
    public ModelAndView beforeGameStart(@PathVariable String gameId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("beforeHighLowGameView");
        mv.addObject("gameId", gameId);
        return mv;
    }
}
