package com.example.servlet;

import com.example.model.User;
import com.example.service.UserService;
import com.example.service.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/register")
public class RegisterUserServlet extends HttpServlet {
    private UserServiceImpl userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("user_name");
        String password = req.getParameter("lastName");
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        try {
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
          }
}
