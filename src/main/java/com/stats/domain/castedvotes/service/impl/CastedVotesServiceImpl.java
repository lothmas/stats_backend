/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stats.domain.castedvotes.service.impl;

import com.stats.domain.castedvotes.dao.CastedVotesDao;
import com.stats.domain.castedvotes.exception.CastedVotesNotFoundException;
import com.stats.domain.castedvotes.model.CastedVotesEntity;
import com.stats.domain.castedvotes.service.CastedVotesService;
import com.stats.domain.votes.exception.VotesEntityNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author kwk
 */
@Service("CastedVotesService")
@Transactional(readOnly = true)
public class CastedVotesServiceImpl implements CastedVotesService {

    @Autowired
    private CastedVotesDao CastedVotesDao;

    Logger logger = Logger.getLogger(this.getClass().getName());




    @Override
    public List<CastedVotesEntity> getCastedVotesByVoteIDAndMemberID(int voteID, int memberID) throws VotesEntityNotFoundException, CastedVotesNotFoundException {
        return CastedVotesDao.getCastedVotesByVoteIDAndMemberID(voteID,memberID);
    }
}
