package com.romeo.playerprofile.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceDTO {

    private Integer id;

    private String model;

    private String carrier;

    private String firmware;
}
