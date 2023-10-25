package com.romeo.playerprofile.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatchersDTO {

    private Integer id;

    private LevelDTO level;

    private HasDTO has;

    private DoesNotHaveDTO doesNotHave;

    private CampaignDataDTO campaignData;

}
