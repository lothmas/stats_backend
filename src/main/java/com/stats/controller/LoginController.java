package com.stats.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



@ControllerAdvice
@Controller
public class LoginController {



    public static String byteToString(byte[] _bytes) {
        String file_string = "";

        for (int i = 0; i < _bytes.length; i++) {
            file_string += (char) _bytes[i];
        }

        return file_string;
    }

    @RequestMapping({"/login"})
    public String getPage(HttpServletRequest request, Model model, HttpSession session,
                          @RequestParam(value = "username", required = false) String username)  {
        String url = request.getRequestURI();
        int index = url.lastIndexOf("/");
        if (index != -1) { }
        return url;
    }


}