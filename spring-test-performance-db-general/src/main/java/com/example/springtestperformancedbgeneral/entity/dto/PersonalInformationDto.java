package com.example.springtestperformancedbgeneral.entity.dto;

import com.example.springtestperformancedbgeneral.entity.PersonalInformationEntity;
import com.example.springtestperformancedbgeneral.model.PersonalInformationModel;
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
