package com.romeo.playerprofile.service;

import com.romeo.playerprofile.domain.CampaignData;
import com.romeo.playerprofile.domain.Level;
import com.romeo.playerprofile.domain.DoesNotHave;
import com.romeo.playerprofile.domain.Matchers;
import com.romeo.playerprofile.domain.Has;
import com.romeo.playerprofile.dto.CampaignDataDTO;
import com.romeo.playerprofile.mapper.CampaignDataMapper;
import com.romeo.playerprofile.repository.LevelRepository;
import com.romeo.playerprofile.repository.HasRepository;
import com.romeo.playerprofile.repository.MatchersRepository;
import com.romeo.playerprofile.repository.CampaignDataRepository;
import com.romeo.playerprofile.repository.DoesNotHaveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@RequiredArgsConstructor
@Service
public class CampaignDataService {

    private final CampaignDataRepository campaignDataRepository;
    private final CampaignDataMapper campaignDataMapper;
    private final HasRepository hasRepository;
    private final DoesNotHaveRepository doesNotHaveRepository;
    private final LevelRepository levelRepository;
    private final MatchersRepository matchersRepository;


    public CampaignDataDTO saveCampaignData(CampaignDataDTO campaignDataDTO) {
        log.info("CampaignDataDTO {}", campaignDataDTO);
        var campaignData = campaignDataMapper.toEntity(campaignDataDTO);
        campaignData = save(campaignData);
        return campaignDataMapper.toDto(campaignData);
    }

    @Transactional
    public CampaignData save(CampaignData campaignData) {
        Matchers matchers = campaignData.getMatchers();
        Level level = matchers.getLevel();
        Has has = matchers.getHas();
        DoesNotHave doesNotHave = matchers.getDoesNotHave();

        has.setMatchers(matchers);
        level.setMatchers(matchers);
        doesNotHave.setMatchers(matchers);

        doesNotHaveRepository.save(doesNotHave);
        levelRepository.save(level);
        hasRepository.save(has);

        matchersRepository.save(matchers);

        return campaignDataRepository.save(campaignData);
    }

    @Transactional(readOnly = true)
    public CampaignData findCurrentCampaignData() {
        return campaignDataRepository.findCurrentCampaignData();
    }
}
