package com.stats.domain.nominees.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "nominees", schema = "stats", catalog = "")
public class NomineesEntity {
    private int id;
    private int voteId;
    private String nomineeName;
    private String nomineeImage;
    private String nomineesDescription;
    private Date creationDate;
    private int enabled;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "vote_id")
    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    @Basic
    @Column(name = "enabled")
    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @Basic
    @Column(name = "nominee_name")
    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    @Basic
    @Column(name = "nominee_image")
    public String getNomineeImage() {
        return nomineeImage;
    }

    public void setNomineeImage(String nomineeImage) {
        this.nomineeImage = nomineeImage;
    }

    @Basic
    @Column(name = "nominees_description")
    public String getNomineesDescription() {
        return nomineesDescription;
    }

    public void setNomineesDescription(String nomineesDescription) {
        this.nomineesDescription = nomineesDescription;
    }

    @Basic
    @Column(name = "creation_date")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NomineesEntity that = (NomineesEntity) o;
        return id == that.id &&
                Objects.equals(voteId, that.voteId) &&
                Objects.equals(nomineeName, that.nomineeName) &&
                Objects.equals(nomineeImage, that.nomineeImage) &&
                Objects.equals(nomineesDescription, that.nomineesDescription) &&
                Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, voteId, nomineeName, nomineeImage, nomineesDescription, creationDate);
    }
}
