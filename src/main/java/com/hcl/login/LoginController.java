package com.hcl.login;


import com.hcl.login.user.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private UserDAO loginDAO;

    public void init(){
        loginDAO=new UserDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("login.jsp");
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
        if(loginDAO.validate(username,password)){
            RequestDispatcher dispatcher=request.getRequestDispatcher("finished");
        }else {
            throw new Exception("Invalid username or password");
        }
    }
}

