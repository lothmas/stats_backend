package com.stats.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "following",  catalog = "")
public class FollowingEntity {
    private int id;
    private String memberId;
    private String followedMemberId;

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
    @Column(name = "followed_member_id", nullable = false, length = 45)
    public String getFollowedMemberId() {
        return followedMemberId;
    }

    public void setFollowedMemberId(String followedMemberId) {
        this.followedMemberId = followedMemberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FollowingEntity that = (FollowingEntity) o;
        return id == that.id &&
                Objects.equals(memberId, that.memberId) &&
                Objects.equals(followedMemberId, that.followedMemberId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, memberId, followedMemberId);
    }
}
