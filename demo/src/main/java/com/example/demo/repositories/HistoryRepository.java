package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.History;

import java.time.LocalDate;



public interface HistoryRepository extends JpaRepository<History,Long>{
    public List<History> findByDate(LocalDate date);

    public List<History> findByUserId(long id);

    @Query("SELECT h FROM History h WHERE h.time= :time")
    List<History> findByTime (String time);
}
