package com.example.dataGenerator.generator.person;

import com.example.dataGenerator.consts.Sex;
import com.example.dataGenerator.generator.utils.RandomNumber;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GenerateName {
    private final List<String> maleNames;
    private final List<String> femaleNames;
    @SneakyThrows
    public GenerateName(){
        this.maleNames = Files.readAllLines(Paths.get("src/main/resources/M_NAMES.txt"));
        this.femaleNames = Files.readAllLines(Paths.get("src/main/resources/F_NAMES.txt"));
    }
    public String getName(Sex sex){
        switch (sex){
            case MALE -> {
                return getMaleName();
            }
            case FEMALE -> {
                return  getFemaleName();
            }
            default -> {
                return "Wrong sex";
            }
        }
    }
    private String getMaleName(){
        return maleNames.get(RandomNumber.getRandomNumber(maleNames.size()));
    }
    private String getFemaleName(){
        return femaleNames.get(RandomNumber.getRandomNumber(femaleNames.size()));
    }
}
