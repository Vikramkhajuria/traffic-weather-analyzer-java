package com.vikram.traffic.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
    Optional<LocationEntity> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);
}
