package com.unisw.pinecone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order")
public class OrderController
{
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String person()
    {
        return "order/create";
    }
}
