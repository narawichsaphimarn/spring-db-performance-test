package com.example.springtestperformancedbasync.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springtestperformancedbasync.entity.PersonalInformationEntity;

public interface PersonalInformationRepository extends JpaRepository<PersonalInformationEntity, Long> {
}
