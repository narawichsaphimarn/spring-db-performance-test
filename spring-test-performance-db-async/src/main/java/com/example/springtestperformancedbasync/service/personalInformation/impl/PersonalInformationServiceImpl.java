package com.example.springtestperformancedbasync.service.personalInformation.impl;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.springtestperformancedbasync.entity.PersonalInformationEntity;
import com.example.springtestperformancedbasync.entity.dto.PersonalInformationDto;
import com.example.springtestperformancedbasync.model.PersonalInformationModel;
import com.example.springtestperformancedbasync.repository.PersonalInformationRepository;
import com.example.springtestperformancedbasync.service.personalInformation.PersonalInformService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonalInformationServiceImpl implements PersonalInformService {
    private final PersonalInformationRepository personalInformationRepository;
    private final PersonalInformationDto personalInformationDto;

    @Override
    @Transactional
    @Async
    public CompletableFuture<PersonalInformationEntity> create(PersonalInformationModel personalInformationModel) {
        PersonalInformationEntity entity = personalInformationDto.mapToEntity(personalInformationModel);
        return CompletableFuture.completedFuture(personalInformationRepository.save(entity));
    }
}
