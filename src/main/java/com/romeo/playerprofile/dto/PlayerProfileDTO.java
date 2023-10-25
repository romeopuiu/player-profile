package com.romeo.playerprofile.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerProfileDTO {

    private UUID playerId;

    private String credential;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssX")
    private Date created;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssX")
    private Date modified;

    private String lastSession;

    private Integer totalSpent;

    private Integer totalRefund;

    private Integer totalTransactions;

    private String lastPurchase;

    private List<String> activeCampaigns = new ArrayList<>();

    private Set<DeviceDTO> devices = new HashSet<>();

    private Integer level;

    private Integer xp;

    private Integer totalPlaytime;

    private String country;

    private String language;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssX")
    private Date birthdate;

    private String gender;

    private Map<String, Integer> inventory = new HashMap<>();

    private ClanDTO clan;

    private String customField;


}
