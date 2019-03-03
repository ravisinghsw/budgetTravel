package com.ravi.travel.budget_travel.poc;

public class TestClass {

    public static void main(String[] args) {

        SchemaValidator validator = new SchemaValidator();
        validator.init();

        String testSchemaA1 = "SCHEMA1";

        System.out.println(" Is   testSchemaA1 exist ::"+validator.isSchemaValid(testSchemaA1));


        String testSchemaA2 = "SCHEMA2";

        System.out.println(" Is   testSchemaA2 exist ::"+validator.isSchemaValid(testSchemaA2));

        String testSchemaA = "SCHEA2";

        System.out.println(" Is   testSchemaA exist ::"+validator.isSchemaValid(testSchemaA));


    }
}
