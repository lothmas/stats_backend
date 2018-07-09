package com.stats.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "expected_stats",  catalog = "")
public class ExpectedStatsEntity {
    private int id;
    private int voteId;
    private Integer voteType;
    private Integer views;
    private Integer comments;
    private String locationRestrictions;
    private Integer gender;
    private Integer race;
    private String ageRange;
    private Integer occupation;
    private Integer occupationIndustry;
    private Integer locationStats;
    private Integer ageStats;
    private String occupationIndustryRestriction;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "vote_id", nullable = false)
    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    @Basic
    @Column(name = "vote_type", nullable = true)
    public Integer getVoteType() {
        return voteType;
    }

    public void setVoteType(Integer voteType) {
        this.voteType = voteType;
    }

    @Basic
    @Column(name = "views", nullable = true)
    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    @Basic
    @Column(name = "comments", nullable = true)
    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "location_restrictions", nullable = true, length = 5000)
    public String getLocationRestrictions() {
        return locationRestrictions;
    }

    public void setLocationRestrictions(String locationRestrictions) {
        this.locationRestrictions = locationRestrictions;
    }

    @Basic
    @Column(name = "gender", nullable = true)
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "race", nullable = true)
    public Integer getRace() {
        return race;
    }

    public void setRace(Integer race) {
        this.race = race;
    }

    @Basic
    @Column(name = "age_range", nullable = true, length = 45)
    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    @Basic
    @Column(name = "occupation", nullable = true)
    public Integer getOccupation() {
        return occupation;
    }

    public void setOccupation(Integer occupation) {
        this.occupation = occupation;
    }

    @Basic
    @Column(name = "occupation_industry", nullable = true)
    public Integer getOccupationIndustry() {
        return occupationIndustry;
    }

    public void setOccupationIndustry(Integer occupationIndustry) {
        this.occupationIndustry = occupationIndustry;
    }

    @Basic
    @Column(name = "location_stats", nullable = true)
    public Integer getLocationStats() {
        return locationStats;
    }

    public void setLocationStats(Integer locationStats) {
        this.locationStats = locationStats;
    }

    @Basic
    @Column(name = "age_stats", nullable = true)
    public Integer getAgeStats() {
        return ageStats;
    }

    public void setAgeStats(Integer ageStats) {
        this.ageStats = ageStats;
    }

    @Basic
    @Column(name = "occupation_industry_restriction", nullable = true, length = 45)
    public String getOccupationIndustryRestriction() {
        return occupationIndustryRestriction;
    }

    public void setOccupationIndustryRestriction(String occupationIndustryRestriction) {
        this.occupationIndustryRestriction = occupationIndustryRestriction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpectedStatsEntity that = (ExpectedStatsEntity) o;
        return id == that.id &&
                voteId == that.voteId &&
                Objects.equals(voteType, that.voteType) &&
                Objects.equals(views, that.views) &&
                Objects.equals(comments, that.comments) &&
                Objects.equals(locationRestrictions, that.locationRestrictions) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(race, that.race) &&
                Objects.equals(ageRange, that.ageRange) &&
                Objects.equals(occupation, that.occupation) &&
                Objects.equals(occupationIndustry, that.occupationIndustry) &&
                Objects.equals(locationStats, that.locationStats) &&
                Objects.equals(ageStats, that.ageStats) &&
                Objects.equals(occupationIndustryRestriction, that.occupationIndustryRestriction);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, voteId, voteType, views, comments, locationRestrictions, gender, race, ageRange, occupation, occupationIndustry, locationStats, ageStats, occupationIndustryRestriction);
    }
}
