package com.example.springtestperformancedbgeneral.controller;

import com.example.springtestperformancedbgeneral.entity.PersonalInformationEntity;
import com.example.springtestperformancedbgeneral.model.PersonalInformationModel;
import com.example.springtestperformancedbgeneral.service.personalInformation.PersonalInformService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PersonalInformationController {
    private final PersonalInformService personalInformService;

    @PostMapping(path = "/personal-information")
    public ResponseEntity<PersonalInformationEntity> create(@RequestBody PersonalInformationModel req) {
        return new ResponseEntity<>(personalInformService.create(req), HttpStatus.OK);
    }
}
