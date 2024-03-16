package com.example.springtestperformancedbgeneral.service.personalInformation;

import com.example.springtestperformancedbgeneral.entity.PersonalInformationEntity;
import com.example.springtestperformancedbgeneral.model.PersonalInformationModel;

public interface PersonalInformService {
    PersonalInformationEntity create(PersonalInformationModel personalInformationModel);
}
