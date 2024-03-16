package com.example.springtestperformancedbgeneral.repository;

import com.example.springtestperformancedbgeneral.entity.PersonalInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalInformationRepository extends JpaRepository<PersonalInformationEntity, Long> {
}
