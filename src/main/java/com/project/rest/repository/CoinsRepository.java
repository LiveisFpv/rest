package com.project.rest.repository;

import com.project.rest.models.Coins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinsRepository extends JpaRepository<Coins,Integer> {
}
