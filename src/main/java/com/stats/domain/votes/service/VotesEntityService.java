/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stats.domain.votes.service;


import com.stats.domain.trending.model.Trending;
import com.stats.domain.votes.exception.VotesEntityNotFoundException;
import com.stats.domain.votes.model.VotesEntity;

import java.util.List;

/**
 *
 * @author kwk
 */
public interface VotesEntityService {

    public List<Trending> trendingVotes(String memberID) throws VotesEntityNotFoundException;
}
