package com.romeo.playerprofile.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CampaignDataDTO {

    private Integer id;

    private String game;

    private String name;

    private double priority;

    private MatchersDTO matchers;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssX")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssX")
    private Date endDate;

    private Boolean enabled;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssX")
    private Date lastUpdated;
}
