package com.romeo.playerprofile.dto;

import com.fasterxml.jackson.annotation.JsonInclude;;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClanDTO {

    private String id;

    private String name;
}
