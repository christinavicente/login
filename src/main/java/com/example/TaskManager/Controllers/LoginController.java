package com.example.TaskManager.Controllers;

import com.example.TaskManager.entities.User;
import com.example.TaskManager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String getCredentials(ModelMap model, @RequestParam String name,
                                 @RequestParam String password ){
        System.out.println("user login: post");
        User user;
        if(authenticate(name,password)){
            model.addAttribute("Username", name);
            return "login";
        }else {
            model.put("Error", "Not-Found-Error");
        }

        return "error";
    }

    @RequestMapping(value = "/new-user", method = RequestMethod.POST)
    public String createNewUser(ModelMap model, @RequestParam String name,
                                @RequestParam String password, @RequestParam String email){
        System.out.println("new: post");
        User user;
        if(userService.getUserByName(name)==null){
            user=new User();
            user.setName(name);
            user.setPassword(password);
            user.setEmail(email);
            userService.addUser(user);
            return "new-user";
        }else {
            model.put("Error", "Already-exists-error");
        }

        return "error";
    }

    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String loadTasksFromLogin(){
        System.out.println("user login: get");
        return "display-tasks";
    }


    @RequestMapping(value = "new-user", method = RequestMethod.GET)
    public String loadLoginFromNewUser(){
        System.out.println("new user: get");
        return "login";
    }

    @RequestMapping(value = "error", method = RequestMethod.GET)
    public String displayError(){

        return "error";
    }

    private boolean authenticate(String name, String password){
        for(User user:userService.getAllUsers()){
                if((user.getName().equals(name))&&(user.getPassword().equals(password))){
                    return true;
                }
            }
        return false;
    }

}
