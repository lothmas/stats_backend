package com.stats.controller.trending;


import com.stats.controller.trending.TrendingMasterObject;
import com.stats.domain.trending.model.Trending;
import com.stats.domain.votes.exception.VotesEntityNotFoundException;
import com.stats.domain.votes.service.VotesEntityService;
import com.stats.utilities.JsonObjectConversionUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
@Controller
public class TrendingController {

    @Autowired
    VotesEntityService votesEntityService;

    public static String byteToString(byte[] _bytes) {
        String file_string = "";

        for (int i = 0; i < _bytes.length; i++) {
            file_string += (char) _bytes[i];
        }

        return file_string;
    }

    @RequestMapping({"/trending"})
    @ResponseBody
    public String trending(HttpServletRequest request, Model model, HttpSession session,
                                        @RequestParam(value = "memberID", required = false) String memberID) {
        try {
            List<Trending> trendings = votesEntityService.trendingVotes(memberID);
            TrendingMasterObject trendingMasterObject=new TrendingMasterObject();
            trendingMasterObject.setTrendingList(trendings);
            JsonObjectConversionUtility jsonConversion=new JsonObjectConversionUtility();
            return jsonConversion.objectToJson(trendingMasterObject);
        } catch (VotesEntityNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }




}