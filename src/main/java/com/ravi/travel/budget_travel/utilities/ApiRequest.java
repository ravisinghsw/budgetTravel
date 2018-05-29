package com.ravi.travel.budget_travel.utilities;

import java.util.Map;

public class ApiRequest {

    private String type;

    private Map<String,String> params;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "ApiRequest{" +
                "type='" + type + '\'' +
                ", params=" + params +
                '}';
    }
}
