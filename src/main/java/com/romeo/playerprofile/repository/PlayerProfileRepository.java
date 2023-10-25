package com.romeo.playerprofile.repository;

import com.romeo.playerprofile.domain.PlayerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlayerProfileRepository extends JpaRepository<PlayerProfile, UUID> {

    Optional<PlayerProfile> findByPlayerId(UUID playerId);
}
