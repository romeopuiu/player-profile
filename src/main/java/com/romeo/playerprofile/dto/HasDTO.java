package com.romeo.playerprofile.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HasDTO {

    private Integer id;

    private Collection<String> country = new ArrayList<>();

    private Collection<String> items = new ArrayList<>();

}
