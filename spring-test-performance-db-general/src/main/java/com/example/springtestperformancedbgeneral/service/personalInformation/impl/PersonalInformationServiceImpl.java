package com.example.springtestperformancedbgeneral.service.personalInformation.impl;

import com.example.springtestperformancedbgeneral.entity.PersonalInformationEntity;
import com.example.springtestperformancedbgeneral.entity.dto.PersonalInformationDto;
import com.example.springtestperformancedbgeneral.model.PersonalInformationModel;
import com.example.springtestperformancedbgeneral.repository.PersonalInformationRepository;
import com.example.springtestperformancedbgeneral.service.personalInformation.PersonalInformService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonalInformationServiceImpl implements PersonalInformService {
    private final PersonalInformationRepository personalInformationRepository;
    private final PersonalInformationDto personalInformationDto;

    @Override
    @Transactional
    public PersonalInformationEntity create(PersonalInformationModel personalInformationModel) {
        PersonalInformationEntity entity = personalInformationDto.mapToEntity(personalInformationModel);
        return personalInformationRepository.save(entity);
    }
}
