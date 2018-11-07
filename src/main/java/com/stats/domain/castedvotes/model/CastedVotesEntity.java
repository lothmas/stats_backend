package com.stats.domain.castedvotes.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "casted_votes",  catalog = "")
public class CastedVotesEntity {
    private int id;
    private String voteId;
    private String memberId;
    private int voterIdentity;
    private Integer like;
    private String nomination;
    private Integer nominationType;
    private Timestamp creationTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "vote_id", nullable = false, length = 45)
    public String getVoteId() {
        return voteId;
    }

    public void setVoteId(String voteId) {
        this.voteId = voteId;
    }

    @Basic
    @Column(name = "member_id", nullable = false, length = 45)
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "voter_identity", nullable = false)
    public int getVoterIdentity() {
        return voterIdentity;
    }

    public void setVoterIdentity(int voterIdentity) {
        this.voterIdentity = voterIdentity;
    }

    @Basic
    @Column(name = "like", nullable = true)
    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    @Basic
    @Column(name = "nomination", nullable = false, length = 5000)
    public String getNomination() {
        return nomination;
    }

    public void setNomination(String nomination) {
        this.nomination = nomination;
    }

    @Basic
    @Column(name = "nomination_type", nullable = true)
    public Integer getNominationType() {
        return nominationType;
    }

    public void setNominationType(Integer nominationType) {
        this.nominationType = nominationType;
    }

    @Basic
    @Column(name = "creation_time", nullable = false)
    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CastedVotesEntity that = (CastedVotesEntity) o;
        return id == that.id &&
                voterIdentity == that.voterIdentity &&
                Objects.equals(voteId, that.voteId) &&
                Objects.equals(memberId, that.memberId) &&
                Objects.equals(like, that.like) &&
                Objects.equals(nomination, that.nomination) &&
                Objects.equals(nominationType, that.nominationType) &&
                Objects.equals(creationTime, that.creationTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, voteId, memberId, voterIdentity, like, nomination, nominationType, creationTime);
    }
}
