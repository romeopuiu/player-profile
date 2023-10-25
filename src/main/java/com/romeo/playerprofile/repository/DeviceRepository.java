package com.romeo.playerprofile.repository;

import com.romeo.playerprofile.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Integer> {}
