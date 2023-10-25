package com.romeo.playerprofile.repository;

import com.romeo.playerprofile.domain.DoesNotHave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoesNotHaveRepository extends JpaRepository<DoesNotHave, Integer> {}
