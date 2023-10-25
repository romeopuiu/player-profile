package com.romeo.playerprofile.repository;

import com.romeo.playerprofile.domain.Has;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HasRepository extends JpaRepository<Has, Integer> {}
