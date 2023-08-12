package com.springboot.watchresponse.Controller;

public class ResponseRequest{
    public ResponseRequest(String watchkey, String response) {
        this.watchkey = watchkey;
        this.response = response;
    }

    private String watchkey;

    private String response;

    public String getWatchkey() {
        return watchkey;
    }

    public void setWatchkey(String watchkey) {
        this.watchkey = watchkey;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "ResponseRequest{" +
                "watchkey='" + watchkey + '\'' +
                ", response='" + response + '\'' +
                '}';
    }

}
