/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stats.domain.nominees.service.impl;

import com.stats.domain.nominees.exception.NomineesNotFoundException;
import com.stats.domain.nominees.service.NomineesService;
import com.stats.domain.trending.model.Trending;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author kwk
 */
@Service("NomineesService")
@Transactional(readOnly = true)
public class NomineesServiceImpl implements NomineesService {

//    @Autowired
//    private NomineesDao NomineesDao;

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public List<Trending> trendingVotes(String memberID) throws NomineesNotFoundException {
       // return NomineesDao.trendingVotes(memberID);
        return null;
    }


}
