package com.romeo.playerprofile.service;

import com.romeo.playerprofile.domain.PlayerProfile;
import com.romeo.playerprofile.domain.Clan;
import com.romeo.playerprofile.domain.Matchers;
import com.romeo.playerprofile.dto.PlayerProfileDTO;
import com.romeo.playerprofile.exception.ResourceNotFoundException;
import com.romeo.playerprofile.mapper.ClanMapper;
import com.romeo.playerprofile.mapper.DeviceMapper;
import com.romeo.playerprofile.mapper.PlayerProfileMapper;
import com.romeo.playerprofile.repository.ClanRepository;
import com.romeo.playerprofile.repository.DeviceRepository;
import com.romeo.playerprofile.repository.PlayerProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
import java.util.UUID;
import java.util.HashSet;
import java.util.ArrayList;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProfilePlayerService {

    private final PlayerProfileRepository playerProfileRepository;
    private final PlayerProfileMapper playerProfileMapper;
    private final ClanRepository clanRepository;
    private final ClanMapper clanMapper;
    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper;
    private final CampaignDataService campaignDataService;

    @Transactional
    public PlayerProfileDTO savePlayerProfile(PlayerProfileDTO profileDTO) {
        var playerProfile = createPlayerProfile(profileDTO);
        var clan = createClan(profileDTO);

        checkClanExists(clan);

        setClan(clan, playerProfile, profileDTO);

        setDevices(playerProfile, profileDTO);

        saveEntities(clan, playerProfile);

        return playerProfileMapper.toDto(playerProfile);
    }

    @Transactional
    public PlayerProfileDTO getPlayer(UUID playerId) {
        var playerProfile = playerProfileRepository.findByPlayerId(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Player profile not found for this playerId: {}," + playerId));

        var campaignData = campaignDataService.findCurrentCampaignData();

        if (campaignData != null) {
            if (campaignMatches(playerProfile, campaignData.getMatchers())) {
                playerProfile.getActiveCampaigns().add(campaignData.getName());
                playerProfileRepository.save(playerProfile);
            }

        } else {
            throw new ResourceNotFoundException("Campaign Data not found for playerId:" + playerId);
        }

        return playerProfileMapper.toDto(playerProfile);
    }


  /*  private void setClanAndDevices(PlayerProfile playerProfile, Clan clan, PlayerProfileDTO profileDTO) {
        clan.setPlayerProfile(playerProfile);
        playerProfile.setClan(clan);

        var devices = playerProfile.getDevices();
        devices.forEach(device -> device.setPlayerProfile(playerProfile));

        profileDTO.setClan(clanMapper.toDto(clan));
        profileDTO.setDevices(deviceMapper.toDtoList(devices));
    }*/

    private void setClan(Clan clan, PlayerProfile playerProfile, PlayerProfileDTO profileDTO) {
        clan.setPlayerProfile(playerProfile);
        playerProfile.setClan(clan);

        profileDTO.setClan(clanMapper.toDto(clan));
    }

    private void setDevices(PlayerProfile playerProfile, PlayerProfileDTO profileDTO) {
        var devices = playerProfile.getDevices();
        devices.forEach(device -> device.setPlayerProfile(playerProfile));

        profileDTO.setDevices(deviceMapper.toDtoList(devices));
    }


    private void saveEntities(Clan clan, PlayerProfile playerProfile) {
        clanRepository.save(clan);
        deviceRepository.saveAll(playerProfile.getDevices());
        playerProfileRepository.save(playerProfile);
    }

    private boolean campaignMatches(PlayerProfile playerProfile, Matchers matchers) {
        // Check level condition
        var playerLevel = playerProfile.getLevel();
        if (matchers.getLevel() != null &&
                (playerLevel  >=  matchers.getLevel().getMin() || playerLevel <= matchers.getLevel().getMax())) {
            return true;
        }

        // Check country condition
        var playerCountry = playerProfile.getCountry();
        if (matchers.getHas() != null && matchers.getHas().getCountry() != null &&
                matchers.getHas().getCountry().contains(playerCountry)) {
            return true;
        }

        // Check items condition
        var playerItems = new ArrayList<>(playerProfile.getInventory().keySet());
        if (matchers.getHas() != null && matchers.getHas().getItems() != null &&
                new HashSet<>(playerItems).containsAll(matchers.getHas().getItems())) {
            return true;
        }
        // Check excluded items condition
        return matchers.getDoesNotHave() != null && matchers.getDoesNotHave().getItems() != null &&
                playerItems.stream().anyMatch(matchers.getDoesNotHave().getItems()::contains);
    }

    private PlayerProfile createPlayerProfile(PlayerProfileDTO profileDTO) {
        var playerProfile = playerProfileMapper.toEntity(profileDTO);
        playerProfile.setDevices(deviceMapper.toEntityList(profileDTO.getDevices()));
        return playerProfile;
    }

    private Clan createClan(PlayerProfileDTO profileDTO) {
        return clanMapper.toEntity(profileDTO.getClan());
    }

    private void checkClanExists(Clan clan) {
        Optional<Clan> optionalClan = clanRepository.findById(clan.getId());
        if (optionalClan.isPresent()) {
            throw new IllegalArgumentException("Clan id is present in database: " + clan.getId());
        }
    }
}