package com.example.dataGenerator.generator.person;

import com.example.dataGenerator.consts.Sex;

import java.time.LocalDate;

public class GeneratePesel {
    private final int[] evenNumbers = {0,2,4,6,8};
    private final int[] notEvenNumbers = {1,3,5,7,9};
    private Sex sex;
    private LocalDate birthDate;
    private String pesel;
    public GeneratePesel(){
        createRandomDate();
    }
    public void setSex(Sex sex){
        this.sex = sex;
    }
    public LocalDate getBirthDate(){
        return this.birthDate;
    }
    public String getPesel(Sex sex){
        this.sex = sex;
        createPesel();
        peselValidate();
        return this.pesel;
    }
    private void createPesel(){
        StringBuilder tempPesel = new StringBuilder(this.birthDate.toString().replace("-", "").substring(2));
        for (int i = 0; i < 5; i++){
            if(i == 3){
                switch (this.sex){
                    case FEMALE -> tempPesel.append(evenNumbers[randomIntBetween(0,4)]);
                    case MALE -> tempPesel.append(notEvenNumbers[randomIntBetween(0,4)]);
                    default -> tempPesel.append(randomIntBetween(0,9));
                }
            }else {
                tempPesel.append(randomIntBetween(0, 9));
            }
        }
        this.pesel = tempPesel.toString();
    }
    private void createRandomDate(){
        int year = randomIntBetween(1920,2022);
        int month = randomIntBetween(1,12);
        int day = randomIntBetween(1,28);
        this.birthDate = LocalDate.of(
                year,
                month,
                day
        );
    }
    private void peselValidate(){
        char[] peselCharArray = this.pesel.toCharArray();
        int controlNumber = 0;
        for (int i = 0; i < peselCharArray.length-1; i++){
            if(i == 0 || i == 4 || i == 8){
                controlNumber = controlNumber + (Integer.parseInt(String.valueOf(peselCharArray[i])));
            } else if (i == 1 || i == 5 || i == 9) {
                controlNumber = controlNumber + (Integer.parseInt(String.valueOf(peselCharArray[i])) * 3);
            }else if (i == 2 || i == 6){
                controlNumber = controlNumber + (Integer.parseInt(String.valueOf(peselCharArray[i])) * 7);
            }else {
                controlNumber = controlNumber + (Integer.parseInt(String.valueOf(peselCharArray[i])) * 9);
            }
        }
        char[] controlNumberArray = String.valueOf(controlNumber).toCharArray();
        if((10 - Integer.parseInt(String.valueOf(controlNumberArray[controlNumberArray.length-1]))) != Integer.parseInt(String.valueOf(peselCharArray[10]))){
            createPesel();
            peselValidate();
        }
    }
    private int randomIntBetween(int start, int end){
        return start + (int) Math.round(Math.random() * (end-start));
    }


}
