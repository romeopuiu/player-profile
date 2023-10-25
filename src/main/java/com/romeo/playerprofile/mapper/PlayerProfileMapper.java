package com.romeo.playerprofile.mapper;

import com.romeo.playerprofile.domain.PlayerProfile;
import com.romeo.playerprofile.dto.PlayerProfileDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerProfileMapper {

    private final ModelMapper modelMapper;

    public PlayerProfile toEntity(PlayerProfileDTO profileDTO){
        return modelMapper.map(profileDTO, PlayerProfile.class);
    }

    public PlayerProfileDTO toDto(PlayerProfile playerProfile){
        return modelMapper.map(playerProfile, PlayerProfileDTO.class);
    }

}
