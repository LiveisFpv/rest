package com.project.rest.repository;

import com.project.rest.models.Price_History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Price_History_Repository extends JpaRepository<Price_History, Integer> {

}
