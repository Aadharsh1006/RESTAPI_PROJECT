package com.example.demo.repositories;


import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.RechargePlan;

public interface RechargePlanRepository extends JpaRepository<RechargePlan,Long>{
        public RechargePlan findByPlanName(String planName);

        public Set<RechargePlan> findRechargePlanByUserId(long id);

        @Query("SELECT r FROM RechargePlan r WHERE r.planDuration= :planDuration")
        List<RechargePlan> findByDuration(int planDuration);
}

