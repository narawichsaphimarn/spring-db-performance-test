package com.example.springtestperformancedbasync.service.personalInformation;

import java.util.concurrent.CompletableFuture;

import com.example.springtestperformancedbasync.entity.PersonalInformationEntity;
import com.example.springtestperformancedbasync.model.PersonalInformationModel;

public interface PersonalInformService {
    CompletableFuture<PersonalInformationEntity> create(PersonalInformationModel personalInformationModel);
}
