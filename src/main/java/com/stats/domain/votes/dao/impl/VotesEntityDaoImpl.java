/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stats.domain.votes.dao.impl;


import com.stats.domain.trending.model.Trending;
import com.stats.domain.votes.dao.VotesEntityDao;
import com.stats.domain.votes.exception.VotesEntityNotFoundException;
import com.stats.domain.votes.model.VotesEntity;
import com.stats.models.UserEntity;
import com.stats.utilities.AbstractDaoImpl;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 *
 * @author kwk
 */
@Repository
class VotesEntityDaoImpl extends AbstractDaoImpl<VotesEntity, Integer> implements VotesEntityDao {



    private final Logger log = Logger.getLogger(VotesEntityDaoImpl.class);

    protected VotesEntityDaoImpl() {
        super(VotesEntity.class);
    }


    @Override
    public List<Trending> trendingVotes(String memberID) throws VotesEntityNotFoundException {
        //@ToDO user userspecific trending topics
        List<Trending> trendingList=new ArrayList<>();
        List<VotesEntity> votes = getCurrentSession().createCriteria(VotesEntity.class)
                .add(Restrictions.ne("memberId", "34"))
                .add(Restrictions.eq("enabled", 1))
                .addOrder(Order.desc("id"))
                .list();

        for(VotesEntity trendingVotes:votes){
            Trending trending=new Trending();

            trending.setTitle(trendingVotes.getTitle());
            trending.setDescription(trendingVotes.getDescription());
            trending.setMainDisplay(trendingVotes.getPostPath());
            trending.setDescriptionType(trendingVotes.getPostType());
            trending.setTime(trendingVotes.getCreationDate().toString());
            trending.setVoteId(trendingVotes.getId());
            trending.setVoteType(trendingVotes.getVoteType());
            trending.setVoteBy(trendingVotes.getVoteBy());
            trending.setAllowedVoteNumber(trendingVotes.getAllowedVoteNumber());

            List<UserEntity> user = getCurrentSession().createCriteria(UserEntity.class)
                    .add(Restrictions.eq("memberId", trendingVotes.getMemberId()))
                    .list();

            if(null!=user){
                trending.setProfilePic(user.get(0).getProfilePicPath());
            }
            else{
                trending.setProfilePic("");
            }

            trending.setOwner(user.get(0).getUserName());
            trendingList.add(trending);
        }

        if (null==trendingList){
            throw new VotesEntityNotFoundException("No Trending Stuff For You, That's weird. Try Again in a moment");
        }

    return trendingList;

    }
}
