package com.example.dataGenerator.generator.utils;

import com.example.dataGenerator.generator.person.GenerateName;
import com.example.dataGenerator.generator.person.GeneratePesel;
import com.example.dataGenerator.generator.person.GenerateSurname;

public class UtilsManager {
    protected GenerateName generateName = new GenerateName();
    protected GenerateSurname generateSurname = new GenerateSurname();
    protected GeneratePesel generatePesel = new GeneratePesel();
}
