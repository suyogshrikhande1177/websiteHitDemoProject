package com.hitProject.hitDemo.repository;

import com.hitProject.hitDemo.models.UserHits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHitsRepository extends JpaRepository<UserHits,Integer> {

    @Modifying
    @Query(value = "INSERT INTO user_hits(id,hit_count) values(1,1)",nativeQuery = true)
    void insertFirstHit();
}
