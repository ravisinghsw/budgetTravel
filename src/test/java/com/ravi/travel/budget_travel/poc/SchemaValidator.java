package com.ravi.travel.budget_travel.poc;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SchemaValidator {

    private Set<String> dbSchemaEnumSet = new HashSet<>();

@PostConstruct
    public void init(){
        dbSchemaEnumSet.add("SCHEMA1");
        dbSchemaEnumSet.add("SCHEMA2");
    }

    public boolean isSchemaValid(String schemaName){
        return dbSchemaEnumSet.contains(schemaName);
    }
}
