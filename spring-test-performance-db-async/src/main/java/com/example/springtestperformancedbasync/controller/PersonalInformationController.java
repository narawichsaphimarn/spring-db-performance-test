package com.example.springtestperformancedbasync.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springtestperformancedbasync.entity.PersonalInformationEntity;
import com.example.springtestperformancedbasync.model.PersonalInformationModel;
import com.example.springtestperformancedbasync.service.personalInformation.PersonalInformService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PersonalInformationController {
    private final PersonalInformService personalInformService;

    @PostMapping(path = "/personal-information")
    public ResponseEntity<PersonalInformationEntity> create(@RequestBody PersonalInformationModel req)
            throws InterruptedException, ExecutionException {
        CompletableFuture<PersonalInformationEntity> pCompletableFuture = personalInformService.create(req);
        return new ResponseEntity<>(pCompletableFuture.get(), HttpStatus.OK);
    }
}
