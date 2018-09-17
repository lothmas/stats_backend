/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stats.domain.nominees.dao.impl;


import com.stats.domain.nominees.dao.NomineesDao;
import com.stats.domain.nominees.exception.NomineesNotFoundException;
import com.stats.domain.nominees.model.NomineesEntity;
import com.stats.domain.trending.model.Trending;
import com.stats.domain.votes.exception.VotesEntityNotFoundException;
import com.stats.models.UserEntity;
import com.stats.utilities.AbstractDaoImpl;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kwk
 */
@Repository
class NomineesDaoImpl extends AbstractDaoImpl<NomineesEntity, Integer> implements NomineesDao {



    private final Logger log = Logger.getLogger(NomineesDaoImpl.class);

    protected NomineesDaoImpl() {
        super(NomineesEntity.class);
    }



    @Override
    public List<NomineesEntity> getVoteNominees(int voteID) throws VotesEntityNotFoundException, NomineesNotFoundException {
        List<NomineesEntity> Nominees = getCurrentSession().createCriteria(NomineesEntity.class)
                .add(Restrictions.eq("voteId", voteID))
                .add(Restrictions.eq("enabled", 1))
                .addOrder(Order.desc("id"))
                .list();

        if (null==Nominees){
            throw new NomineesNotFoundException("No Trending Stuff For You, That's weird. Try Again in a moment");
        }

        return Nominees;
    }
}
