package com.ravi.travel.budget_travel.utilities;

import java.util.Map;

public class ApiResponse {

    private String status;

    private String errorDesc;

    private Map<String,String> responseParams;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public Map<String, String> getResponseParams() {
        return responseParams;
    }

    public void setResponseParams(Map<String, String> responseParams) {
        this.responseParams = responseParams;
    }


    @Override
    public String toString() {
        return "ApiResponse{" +
                "status='" + status + '\'' +
                ", errorDesc='" + errorDesc + '\'' +
                ", responseParams=" + responseParams +
                '}';
    }
}
