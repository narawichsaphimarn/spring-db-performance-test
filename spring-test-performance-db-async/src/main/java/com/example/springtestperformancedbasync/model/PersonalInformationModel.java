package com.example.springtestperformancedbasync.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PersonalInformationModel {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String identityCard;
}
