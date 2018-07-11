/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stats.domain.votes.dao;



import com.stats.domain.trending.model.Trending;
import com.stats.domain.votes.exception.VotesEntityNotFoundException;
import com.stats.domain.votes.model.VotesEntity;
import com.stats.utilities.AbstractDao;

import java.util.List;

/**
 *
 * @author kwk
 */
public interface VotesEntityDao extends AbstractDao<VotesEntity, Integer> {

    public List<Trending> trendingVotes(String memberID) throws VotesEntityNotFoundException;

}
