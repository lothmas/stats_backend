//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iqa.institutes.dao.impl;


import com.iqa.institutes.dao.InstitutesDao;
import com.iqa.institutes.exception.InstitutesNotFoundException;
import com.iqa.institutes.model.InstitutesEntity;
import com.iqa.utilities.AbstractDaoImpl;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstitutesDaoImpl extends AbstractDaoImpl<InstitutesEntity, Integer> implements InstitutesDao {

    private final Logger log = Logger.getLogger(InstitutesDaoImpl.class);
    Logger InstitutesDaoImplLogger = Logger.getLogger(this.getClass().getName());

    protected InstitutesDaoImpl() {
        super(InstitutesEntity.class);
    }

    @Override
    public void saveInstitutes(InstitutesEntity InstitutesEntity) {
        this.saveOrUpdate(InstitutesEntity);
    }

    @Override
    public InstitutesEntity findInstitutesByUsername(String username) throws InstitutesNotFoundException {
        List<InstitutesEntity> results = this.getCurrentSession().createCriteria(InstitutesEntity.class)
                .add(Restrictions.eq("username", username))
                .list();

        if (results.isEmpty()) {
            throw new InstitutesNotFoundException("No Institutes found associated with username:" + username);
        } else if (results.size() != 1) {
            throw new InstitutesNotFoundException("There are several InstitutesEntity found associated with :" + username);
        } else {
            return (InstitutesEntity) results.get(0);
        }
    }

    @Override
    public InstitutesEntity findInstitutesById(int id) throws InstitutesNotFoundException {
        List<InstitutesEntity> results = this.getCurrentSession().createCriteria(InstitutesEntity.class)
                .add(Restrictions.eq("id", id))
                .list();

        if (results.isEmpty()) {
            throw new InstitutesNotFoundException("No Institutes found associated with id:" + id);
        } else if (results.size() != 1) {
            throw new InstitutesNotFoundException("There are several InstitutesEntity found associated with instituteId: " + id);
        } else {
            return results.get(0);
        }
    }

    @Override
    public List<InstitutesEntity> getAllInstitutes() throws InstitutesNotFoundException {
        List<InstitutesEntity> results = this.getCurrentSession().createCriteria(InstitutesEntity.class)
                .list();

        if (results.isEmpty()) {
            throw new InstitutesNotFoundException("No Institutes found ");
        }

        return results;
    }


    @Override
    public List<InstitutesEntity> getInstitutesByCountry(int countryId) throws InstitutesNotFoundException {
        List<InstitutesEntity> results = this.getCurrentSession().createCriteria(InstitutesEntity.class)
                .add(Restrictions.eq("country", countryId))
                .add(Restrictions.eq("enabled", 1))
                .list();

        if (results.isEmpty()) {
            throw new InstitutesNotFoundException("No Institutes found ");
        }

        return results;
    }
}

