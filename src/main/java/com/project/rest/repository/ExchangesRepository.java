package com.project.rest.repository;

import com.project.rest.models.Exchanges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangesRepository extends JpaRepository<Exchanges,Integer> {
}
