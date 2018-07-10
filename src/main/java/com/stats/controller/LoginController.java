package com.stats.controller;


import com.stats.trending.model.Trending;
import com.stats.utilities.JsonObjectConversionUtility;
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

    @RequestMapping({"/trending"})
    @ResponseBody
    public Trending getPage(HttpServletRequest request, Model model, HttpSession session,
                            @RequestParam(value = "memberID", required = false) String memberID)  {
        String url = request.getRequestURI();
        Trending trending=new Trending();
        trending.setDescription("test");
        trending.setOwner("louis");
        return trending;
//        JsonObjectConversionUtility jsonConversion=new JsonObjectConversionUtility();
//        return jsonConversion.objectToJson(trending);
    }


}