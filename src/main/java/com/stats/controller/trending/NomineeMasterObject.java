package com.stats.controller.trending;

import com.stats.domain.nominees.model.NomineesEntity;

import java.util.List;



public class NomineeMasterObject {

    private List<NomineesEntity> nomineesEntityList;

    public List<NomineesEntity> getNomineesEntityList() {
        return nomineesEntityList;
    }

    public void setNomineesEntityList(List<NomineesEntity> nomineesEntityList) {
        this.nomineesEntityList = nomineesEntityList;
    }
}
