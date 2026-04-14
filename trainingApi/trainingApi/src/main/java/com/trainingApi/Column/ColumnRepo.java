package com.trainingApi.Column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ColumnRepo extends JpaRepository<Column, UUID> {
}
