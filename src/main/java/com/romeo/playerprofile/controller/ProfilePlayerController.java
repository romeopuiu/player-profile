package com.romeo.playerprofile.controller;

import com.romeo.playerprofile.dto.CampaignDataDTO;
import com.romeo.playerprofile.dto.PlayerProfileDTO;
import com.romeo.playerprofile.service.CampaignDataService;
import com.romeo.playerprofile.service.ProfilePlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/profile-player")
public class ProfilePlayerController {

    private final ProfilePlayerService profilePlayerService;
    private final CampaignDataService campaignDataService;

    @GetMapping("/client-config/{playerId}")
    ResponseEntity<PlayerProfileDTO> getPlayer(@PathVariable("playerId") UUID playerId) {
        log.info("REST request to get playerId : {}", playerId);
        return ResponseEntity.ok(profilePlayerService.getPlayer(playerId));
    }

    @PostMapping
    public ResponseEntity<PlayerProfileDTO> createPlayerProfile(@RequestBody PlayerProfileDTO profileDTO) {
        return ResponseEntity.ok(profilePlayerService.savePlayerProfile(profileDTO));
    }

    @PostMapping("/create-campaign-data")
    public ResponseEntity<CampaignDataDTO> createCampaignData(@RequestBody CampaignDataDTO campaignDataDTO) {
        return ResponseEntity.ok(campaignDataService.saveCampaignData(campaignDataDTO));
    }
}
