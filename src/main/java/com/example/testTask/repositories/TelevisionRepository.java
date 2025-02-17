package com.example.testTask.repositories;

import com.example.testTask.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TelevisionRepository extends JpaRepository<Television, Long>, JpaSpecificationExecutor<Television> {
}
