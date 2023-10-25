package com.romeo.playerprofile.mapper;

import com.romeo.playerprofile.domain.Device;
import com.romeo.playerprofile.dto.DeviceDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DeviceMapper {

    private final ModelMapper modelMapper;

    public Device toEntity(DeviceDTO deviceDTO) {
        return modelMapper.map(deviceDTO, Device.class);
    }

    public DeviceDTO toDto(Device device) {
        return modelMapper.map(device, DeviceDTO.class);

    }

    public Set<Device> toEntityList(Set<DeviceDTO> dtoList) {
        return dtoList.stream()
                .map(this::toEntity)
                .collect(Collectors.toSet());
    }

    public Set<DeviceDTO> toDtoList(Set<Device> entityList) {
        return entityList.stream()
                .map(this::toDto)
                .collect(Collectors.toSet());
    }

}
