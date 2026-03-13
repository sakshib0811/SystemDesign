package Models;

import java.util.*;

public class Restaurant {
    String restid;
    String restName;
    String restGst;
    String restEnail;
    String restPhn;
    Map<String, MenuItem> catalog = new HashMap<>();

    public Restaurant(String id, String restName, String restGst, String restEnail, String restPhn) {
        this.restid = id;
        this.restName = restName;
        this.restGst = restGst;
        this.restEnail = restEnail;
        this.restPhn = restPhn;
    }

    public String getRestid() {
        return restid;
    }

    public void setRestid(String restid) {
        this.restid = restid;
    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public String getRestGst() {
        return restGst;
    }

    public void setRestGst(String restGst) {
        this.restGst = restGst;
    }

    public String getRestEnail() {
        return restEnail;
    }

    public void setRestEnail(String restEnail) {
        this.restEnail = restEnail;
    }

    public String getRestPhn() {
        return restPhn;
    }

    public void setRestPhn(String restPhn) {
        this.restPhn = restPhn;
    }

    public Map<String, MenuItem> getCatalog() {
        return catalog;
    }

    public void setCatalog(Map<String, MenuItem> catalog) {
        this.catalog = catalog;
    }

    @Override
    public String toString() {
        return "Restaurant [restName=" + restName + ", restGst=" + restGst + ", restEnail=" + restEnail + ", restPhn="
                + restPhn + ", catalog=" + catalog + "]";
    }

}
