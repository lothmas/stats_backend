/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stats.domain.nominees.service;


import com.stats.domain.nominees.exception.NomineesNotFoundException;
import com.stats.domain.trending.model.Trending;
import com.stats.domain.votes.exception.VotesEntityNotFoundException;

import java.util.List;

/**
 *
 * @author kwk
 */
public interface NomineesService {

    public List<Trending> trendingVotes(String memberID) throws VotesEntityNotFoundException, NomineesNotFoundException;
}
