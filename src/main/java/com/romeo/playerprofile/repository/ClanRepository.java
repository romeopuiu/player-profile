package com.romeo.playerprofile.repository;

import com.romeo.playerprofile.domain.Clan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClanRepository extends JpaRepository<Clan, String> {}
