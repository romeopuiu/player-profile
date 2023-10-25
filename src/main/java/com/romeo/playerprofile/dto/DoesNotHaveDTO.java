package com.romeo.playerprofile.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DoesNotHaveDTO {

    private Integer id;

    private List<String> items = new ArrayList<>();

}
