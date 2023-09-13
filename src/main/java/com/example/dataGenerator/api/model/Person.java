package com.example.dataGenerator.api.model;

import com.example.dataGenerator.consts.Sex;
import com.example.dataGenerator.generator.utils.RandomNumber;
import com.example.dataGenerator.generator.utils.UtilsManager;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Random;

@Getter
@Setter
public class Person extends UtilsManager {
    private String sex;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String pesel;

    public Person(Sex sex){
        Sex localSex = sex;
        if(sex == Sex.RANDOM){
            Sex[] sexArr = {Sex.FEMALE, Sex.MALE};
            localSex = sexArr[RandomNumber.getRandomNumber(2)];
        }
        generatePesel.setSex(localSex);
        switch (localSex){
            case MALE -> {
                this.sex = "Mężczyzna";
                this.name = generateName.getName(localSex);
                this.surname = generateSurname.getName(localSex);
                this.birthDate = generatePesel.getBirthDate();
                this.pesel = generatePesel.getPesel(localSex);
            }
            case FEMALE -> {
                this.sex = "Kobieta";
                this.name = generateName.getName(localSex);
                this.surname = generateSurname.getName(localSex);
                this.birthDate = generatePesel.getBirthDate();
                this.pesel = generatePesel.getPesel(localSex);
            }
        }
    }
}
