/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stats.domain.castedvotes.dao;



import com.stats.domain.castedvotes.exception.CastedVotesNotFoundException;
import com.stats.domain.castedvotes.model.CastedVotesEntity;
import com.stats.domain.votes.exception.VotesEntityNotFoundException;
import com.stats.utilities.AbstractDao;

import java.util.List;

/**
 *
 * @author kwk
 */
public interface CastedVotesDao extends AbstractDao<CastedVotesEntity, Integer> {

    public List<CastedVotesEntity> getCastedVotesByVoteIDAndMemberID(int voteID, String memberID) throws VotesEntityNotFoundException, CastedVotesNotFoundException;

}
