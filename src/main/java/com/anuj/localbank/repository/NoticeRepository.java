package com.anuj.localbank.repository;

import com.anuj.localbank.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {


    //jpql
    @Query(value = "From Notice n where CURDATE() between noticBegDt And noticEndDt")
    List<Notice> findAllActiveNotices();
}
