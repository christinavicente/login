package com.hcl.login;


import com.hcl.login.user.User;
import com.hcl.login.user.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/newUser")
public class NewUserController {
    private UserDAO loginDAO;

    public void init(){loginDAO=new UserDAO();}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("new-user.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            authenticate(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void authenticate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if(!loginDAO.validate(username,password)){
            User user=new User();
            user.setPassword(password);
            user.setUserName(username);
            loginDAO.saveUser(user);
            RequestDispatcher dispatcher=request.getRequestDispatcher("login-success");
        }else {
            throw new Exception("Login already exists");
        }
    }
}
