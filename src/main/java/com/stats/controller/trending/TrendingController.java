package com.stats.controller.trending;


import com.stats.controller.trending.TrendingMasterObject;
import com.stats.domain.castedvotes.exception.CastedVotesNotFoundException;
import com.stats.domain.castedvotes.service.CastedVotesService;
import com.stats.domain.nominees.exception.NomineesNotFoundException;
import com.stats.domain.nominees.model.NomineesEntity;
import com.stats.domain.nominees.service.NomineesService;
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

    @Autowired
    NomineesService nomineesService;

    @Autowired
    CastedVotesService castedVotesService;

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
            List<Trending> trendingWithCastedNumber=new ArrayList<>();
            for(Trending trend:trendings){
                try {
                    int castedVotes=castedVotesService.getCastedVotesByVoteIDAndMemberID(trend.getVoteId(), Integer.parseInt(memberID)).size();
                    trend.setVotesCasted(castedVotes);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                trendingWithCastedNumber.add(trend);

            }
            TrendingMasterObject trendingMasterObject=new TrendingMasterObject();
            trendingMasterObject.setTrendingList(trendingWithCastedNumber);
            JsonObjectConversionUtility jsonConversion=new JsonObjectConversionUtility();
            return jsonConversion.objectToJson(trendingMasterObject);
        } catch (VotesEntityNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }


    @RequestMapping({"/castedVotes"})
    @ResponseBody
    public String getUserCastedVotes(HttpServletRequest request, Model model, HttpSession session,
                           @RequestParam(value = "voteID", required = false) String voteID) {
        try {

            List<NomineesEntity> nomineesEntities = nomineesService.getVoteNominees(Integer.parseInt(voteID));
            NomineeMasterObject nomineeMasterObject=new NomineeMasterObject();
            nomineeMasterObject.setNomineesEntityList(nomineesEntities);
            JsonObjectConversionUtility jsonConversion=new JsonObjectConversionUtility();
            return jsonConversion.objectToJson(nomineeMasterObject);
        } catch (VotesEntityNotFoundException e) {
            return null;
        } catch (NomineesNotFoundException e) {
            return null;
        }

    }

}