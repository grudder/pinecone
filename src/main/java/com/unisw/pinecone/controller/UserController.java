package com.unisw.pinecone.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.unisw.pinecone.entity.User;
import com.unisw.pinecone.repository.OrderRepository;
import com.unisw.pinecone.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model)
    {
        //initUsers();
        
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);

        return "/user/list";
    }

    private void initUsers()
    {
        try
        {
            String filePath = "D:\\Work\\_me\\pinecone\\doc\\100组序列.txt";
            File file = new File(filePath);
            if (file.isFile() && file.exists())
            {
                // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    userRepository.save(new User(lineTxt));
                }
                read.close();
            }
        }
        catch (Exception e)
        {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }
}
