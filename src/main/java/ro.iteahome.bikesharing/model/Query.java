package ro.iteahome.bikesharing.model;

import java.util.ArrayList;

public class Query {
    private String message;
    private ArrayList<String> queryList = new ArrayList<>();

    public Query(){}

    public Query(String message, ArrayList<String> queryList) {
        this.message = message;
        this.queryList = queryList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<String> getQueryList() {
        return queryList;
    }

    public void addQueryResult(String queryResult){
        this.queryList.add(queryResult);
    }
}



