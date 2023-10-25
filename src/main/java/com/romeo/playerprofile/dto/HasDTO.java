package com.romeo.playerprofile.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HasDTO {

    private Integer id;

    private List<String> country = new ArrayList<>();

    private List<String> items = new ArrayList<>();

}
