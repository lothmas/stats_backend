package com.stats.controller.trending;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class TrendingController {


    public static String byteToString(byte[] _bytes) {
        String file_string = "";

        for (int i = 0; i < _bytes.length; i++) {
            file_string += (char) _bytes[i];
        }

        return file_string;
    }

    //  @RequestMapping(value = {"/trending"}, method = RequestMethod.GET)
    public String getPage(@RequestParam(value = "memberID", required = false) String memberID) {
        String test = "testing";
        System.out.println("gotit");
        return "GotIt";
    }
}
