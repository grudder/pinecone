package com.unisw.pinecone.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.unisw.pinecone.entity.Order;
import com.unisw.pinecone.entity.User;
import com.unisw.pinecone.repository.OrderRepository;

@Controller
@RequestMapping("/order")
public class OrderController
{
    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(value = "/create", params = "form", method = RequestMethod.GET)
    public String createForm(@ModelAttribute Order order)
    {
        return "/order/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid Order order, BindingResult result, HttpServletRequest request)
    {
        if (result.hasErrors())
        {
            return new ModelAndView("/order/create", "formErrors", result.getAllErrors());
        }

        User user = (User) request.getSession().getAttribute("user");
        order.setUser(user);
        order.setCreateTime(new Date());
        order = orderRepository.save(order);

        return new ModelAndView("redirect:/home/share");
    }
}
