package com.romeo.playerprofile.mapper;

import com.romeo.playerprofile.domain.CampaignData;
import com.romeo.playerprofile.dto.CampaignDataDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CampaignDataMapper {

    private final ModelMapper modelMapper;

    public CampaignData toEntity(CampaignDataDTO campaignDataDTO) {
        return modelMapper.map(campaignDataDTO, CampaignData.class);
    }

    public CampaignDataDTO toDto(CampaignData campaignData) {
        return modelMapper.map(campaignData, CampaignDataDTO.class);
    }
}
