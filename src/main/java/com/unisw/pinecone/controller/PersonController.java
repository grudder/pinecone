package com.unisw.pinecone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/person")
public class PersonController
{
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String person()
    {
        return "person/list";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(@RequestParam(value = "imgUrl", required = true) String imgUrl, Model model)
    {
        imgUrl = imgUrl.replace("s.jpg", "b.jpg");
        model.addAttribute("imgUrl", imgUrl);
        
        return "person/detail";
    }
}
