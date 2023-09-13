package com.example.dataGenerator.generator.person;

import com.example.dataGenerator.consts.Sex;
import com.example.dataGenerator.generator.utils.RandomNumber;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GenerateSurname {
    private final List<String> maleSurnames;
    private final List<String> femaleSurnames;
    @SneakyThrows
    public GenerateSurname(){
        this.maleSurnames = Files.readAllLines(Paths.get("src/main/resources/M_SURNAMES.txt"));
        this.femaleSurnames = Files.readAllLines(Paths.get("src/main/resources/F_SURNAMES.txt"));
    }
    public String getName(Sex sex){
        switch (sex){
            case MALE -> {
                return getMaleSurname();
            }
            case FEMALE -> {
                return  getFemaleSurname();
            }
            default -> {
                return "Wrong sex";
            }
        }
    }
    private String getMaleSurname(){
        return maleSurnames.get(RandomNumber.getRandomNumber(maleSurnames.size()));
    }
    private String getFemaleSurname(){
        return femaleSurnames.get(RandomNumber.getRandomNumber(femaleSurnames.size()));
    }
}
