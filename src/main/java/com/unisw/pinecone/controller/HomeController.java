package com.unisw.pinecone.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unisw.pinecone.entity.User;
import com.unisw.pinecone.entity.VisitLog;
import com.unisw.pinecone.repository.UserRepository;
import com.unisw.pinecone.repository.VisitLogRepository;

@Controller
public class HomeController
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    VisitLogRepository visitLogRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(value = "number", required = false) String number,
            HttpServletRequest request)
    {
        User user = null;

        List<User> users = userRepository.findByNumber(number);
        if (users != null && users.size() == 1)
        {
            user = users.get(0);

            // 记录访问日志
            VisitLog visitLog = new VisitLog();
            visitLog.setUser(user);
            visitLog.setVisitTime(new Date());
            visitLogRepository.save(visitLog);

            // 访问次数加1
            user.setVisitCount(user.getVisitCount() + 1);
            userRepository.save(user);
        }

        // 将用户信息记入Session
        request.getSession().setAttribute("user", user);

        return new ModelAndView("home/index", "user", user);
    }

    @RequestMapping(value = "/home/production", method = RequestMethod.GET)
    public String production()
    {
        return "home/production";
    }

    @RequestMapping(value = "/home/share", method = RequestMethod.GET)
    public String share()
    {
        return "home/share";
    }
}
