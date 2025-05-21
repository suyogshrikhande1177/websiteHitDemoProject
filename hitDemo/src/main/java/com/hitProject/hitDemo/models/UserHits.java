package com.hitProject.hitDemo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user_hits")
public class UserHits {

    @Id
    private int id;

    @Column(name = "hit_count")
    private long hitCount;

    public UserHits() {
    }

    public UserHits(int id, long hitCount) {
        this.id = id;
        this.hitCount = hitCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getHitCount() {
        return hitCount;
    }

    public void setHitCount(long hitCount) {
        this.hitCount = hitCount;
    }

    @Override
    public String toString() {
        return "UserHits{" +
                "id=" + id +
                ", hitCount=" + hitCount +
                '}';
    }
}
