/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stats.domain.castedvotes.dao.impl;


import com.stats.domain.castedvotes.dao.CastedVotesDao;
import com.stats.domain.castedvotes.exception.CastedVotesNotFoundException;
import com.stats.domain.castedvotes.model.CastedVotesEntity;
import com.stats.domain.votes.exception.VotesEntityNotFoundException;
import com.stats.utilities.AbstractDaoImpl;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author kwk
 */
@Repository
class CastedVotesDaoImpl extends AbstractDaoImpl<CastedVotesEntity, Integer> implements CastedVotesDao {



    private final Logger log = Logger.getLogger(CastedVotesDaoImpl.class);

    protected CastedVotesDaoImpl() {
        super(CastedVotesEntity.class);
    }



    @Override
    public List<CastedVotesEntity> getCastedVotesByVoteIDAndMemberID(int voteID, int memberID) throws VotesEntityNotFoundException, CastedVotesNotFoundException {
        List<CastedVotesEntity> CastedVotes = getCurrentSession().createCriteria(CastedVotesEntity.class)
                .add(Restrictions.eq("voteId", voteID))
                .add(Restrictions.eq("memberId", memberID))
                .addOrder(Order.desc("id"))
                .list();

        if (null==CastedVotes){
            throw new CastedVotesNotFoundException("No CastedVotes Found for this vote");
        }

        return CastedVotes;
    }
}
