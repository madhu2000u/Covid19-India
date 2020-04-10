package com.madhu.covid_19india;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Covid_India_ResponsePOJO {

    /**
     *
     * (Required)
     *
     */
    @SerializedName("status")
    @Expose
    private String status;
    /**
     *
     * (Required)
     *
     */
    @SerializedName("statusCode")
    @Expose
    private String statusCode;
    /**
     *
     * (Required)
     *
     */
    @SerializedName("response")
    @Expose
    private List<StateDataPOJO> response = null;

    /**
     *
     * (Required)
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * (Required)
     *
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * (Required)
     *
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     *
     * (Required)
     *
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     *
     * (Required)
     *
     */
    public List<StateDataPOJO> getResponse() {
        return response;
    }

    /**
     *
     * (Required)
     *
     */
    public void setResponse(List<StateDataPOJO> response) {
        this.response = response;
    }

}