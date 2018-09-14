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
class NomineesEntityDaoImpl extends AbstractDaoImpl<NomineesEntity, Integer> implements NomineesDao {



    private final Logger log = Logger.getLogger(NomineesEntityDaoImpl.class);

    protected NomineesEntityDaoImpl() {
        super(NomineesEntity.class);
    }


    @Override
    public List<Trending> trendingNominees(String memberID) throws NomineesNotFoundException {
        //@ToDO user userspecific trending topics
        List<Trending> trendingList=new ArrayList<>();
        List<NomineesEntity> Nominees = getCurrentSession().createCriteria(NomineesEntity.class)
                .add(Restrictions.ne("memberId", "34"))
                .add(Restrictions.eq("enabled", 1))
                .addOrder(Order.desc("id"))
                .list();

        for(NomineesEntity trendingNominees:Nominees){
            Trending trending=new Trending();



            List<UserEntity> user = getCurrentSession().createCriteria(UserEntity.class)
                   // .add(Restrictions.eq("memberId", trendingNominees.getMemberId()))
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
            throw new NomineesNotFoundException("No Trending Stuff For You, That's weird. Try Again in a moment");
        }

    return trendingList;

    }
}
