package com.example.springtestperformancedbasync.entity.dto;

import com.example.springtestperformancedbasync.entity.PersonalInformationEntity;
import com.example.springtestperformancedbasync.model.PersonalInformationModel;
import org.springframework.stereotype.Repository;

@Repository
public class PersonalInformationDto {
    public PersonalInformationEntity mapToEntity(PersonalInformationModel model) {
        PersonalInformationEntity entity = new PersonalInformationEntity();
        entity.setAge(model.getAge());
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setIdentityCard(model.getIdentityCard());
        return entity;
    }
}
