/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stats.domain.nominees.dao;



import com.stats.domain.trending.model.Trending;
import com.stats.domain.nominees.exception.NomineesNotFoundException;
import com.stats.domain.nominees.model.NomineesEntity;
import com.stats.utilities.AbstractDao;

import java.util.List;

/**
 *
 * @author kwk
 */
public interface NomineesDao extends AbstractDao<NomineesEntity, Integer> {

    public List<Trending> trendingNominees(String memberID) throws NomineesNotFoundException;

}
