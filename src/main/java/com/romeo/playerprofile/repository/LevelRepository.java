package com.romeo.playerprofile.repository;

import com.romeo.playerprofile.domain.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level, Integer> {
}
