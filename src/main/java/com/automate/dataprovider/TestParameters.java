package com.automate.dataprovider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class TestParameters {

    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public String zipCode;
    public String phone;
    public String ssn;
    public String username;
    public String password;
    public String confirmPasswordOne;
    public String confirmPasswordTwo;

   public static List<TestParameters> loadFromFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File(filePath));
        JsonNode parameterSetsNode = rootNode.get("parameterSets");
        return objectMapper.convertValue(parameterSetsNode, new TypeReference<List<TestParameters>>(){});
    }

   public static List<TestParameters> loadFromCSV(String filePath) throws IOException
   {
	   try (FileReader reader = new FileReader(filePath)) {
           CsvToBean<TestParameters> csvToBean = new CsvToBeanBuilder<TestParameters>(reader)
                   .withType(TestParameters.class)
                   .withIgnoreLeadingWhiteSpace(true)
                   .build();
           return csvToBean.parse();
       }
   }
   
   
}

