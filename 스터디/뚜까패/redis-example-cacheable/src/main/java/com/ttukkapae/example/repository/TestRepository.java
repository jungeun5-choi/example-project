package com.ttukkapae.example.repository;

import com.ttukkapae.example.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    List<Test> findAllByUsername(String username);
}
