package com.stats.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "vote_nomination",  catalog = "")
public class VoteNominationEntity {
    private int id;
    private String memberId;
    private String description;
    private String title;
    private String postPath;
    private int postType;
    private Integer enabled;
    private Date startDate;
    private Date endDate;
    private Integer voteType;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "description", nullable = false, length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "post_path", nullable = true, length = 100)
    public String getPostPath() {
        return postPath;
    }

    public void setPostPath(String postPath) {
        this.postPath = postPath;
    }

    @Basic
    @Column(name = "post_type", nullable = false)
    public int getPostType() {
        return postType;
    }

    public void setPostType(int postType) {
        this.postType = postType;
    }

    @Basic
    @Column(name = "enabled", nullable = true)
    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    @Basic
    @Column(name = "start_date", nullable = true)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = true)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "vote_type", nullable = true)
    public Integer getVoteType() {
        return voteType;
    }

    public void setVoteType(Integer voteType) {
        this.voteType = voteType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteNominationEntity that = (VoteNominationEntity) o;
        return id == that.id &&
                postType == that.postType &&
                Objects.equals(memberId, that.memberId) &&
                Objects.equals(description, that.description) &&
                Objects.equals(title, that.title) &&
                Objects.equals(postPath, that.postPath) &&
                Objects.equals(enabled, that.enabled) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(voteType, that.voteType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, memberId, description, title, postPath, postType, enabled, startDate, endDate, voteType);
    }
}
