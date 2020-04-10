package com.madhu.covid_19india;

import java.security.PrivateKey;

public class StateDataPOJO {

    private String confirmed;
    private String active;
    private String name;
    private String recovered;
    private String deaths;

    public StateDataPOJO() {
    }

    public StateDataPOJO(String confirmed, String active, String name, String recovered, String deaths) {
        this.confirmed = confirmed;
        this.active = active;
        this.name = name;
        this.recovered = recovered;
        this.deaths = deaths;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public String getActive() {
        return active;
    }

    public String getName() {return name;}

    public String getRecovered() {return recovered;}

    public String getDeaths() {
        return deaths;
    }
}
