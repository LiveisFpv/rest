package com.project.rest.repository;

import com.project.rest.models.Trend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrendRepository extends JpaRepository<Trend,Integer> {
}
