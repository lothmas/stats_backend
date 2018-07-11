/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stats.domain.votes.service.impl;

import com.stats.domain.trending.model.Trending;
import com.stats.domain.votes.dao.VotesEntityDao;
import com.stats.domain.votes.exception.VotesEntityNotFoundException;
import com.stats.domain.votes.model.VotesEntity;
import com.stats.domain.votes.service.VotesEntityService;
import org.apache.log4j.Logger;
import org.apache.log4j.NDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kwk
 */
@Service("VotesEntityService")
@Transactional(readOnly = true)
public class VotesEntityServiceImpl implements VotesEntityService {

    @Autowired
    private VotesEntityDao votesEntityDao;

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public List<Trending> trendingVotes(String memberID) throws VotesEntityNotFoundException {
        return votesEntityDao.trendingVotes(memberID);
    }


}
