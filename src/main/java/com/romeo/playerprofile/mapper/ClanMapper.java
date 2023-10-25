package com.romeo.playerprofile.mapper;

import com.romeo.playerprofile.domain.Clan;
import com.romeo.playerprofile.dto.ClanDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClanMapper {

    private final ModelMapper modelMapper;

    public Clan toEntity(ClanDTO clanDTO) {
        return modelMapper.map(clanDTO, Clan.class);
    }

    public ClanDTO toDto(Clan clan) {
        return modelMapper.map(clan, ClanDTO.class);

    }
}
