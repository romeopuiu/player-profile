package com.romeo.playerprofile.repository;

import com.romeo.playerprofile.domain.CampaignData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CampaignDataRepository extends JpaRepository<CampaignData, Integer> {

    @Query("SELECT c FROM CampaignData c WHERE c.enabled = true")
    CampaignData findCurrentCampaignData();
}
