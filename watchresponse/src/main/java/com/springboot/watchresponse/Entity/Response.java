package com.springboot.watchresponse.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "watchresponse")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "watchkey")
    private String watchkey;

    @Column(name = "yes")
    private int YesResponse;

    @Column(name = "no")
    private int NoResponse;

    @Column(name="total")
    private int total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Response(){}

    public Response(String watchkey, int yesResponse, int noResponse) {
        this.watchkey = watchkey;
        YesResponse = yesResponse;
        NoResponse = noResponse;
    }

    public String getWatchkey() {
        return watchkey;
    }

    public void setWatchkey(String watchkey) {
        this.watchkey = watchkey;
    }

    public int getYesResponse() {
        return YesResponse;
    }

    public void setYesResponse(int yesResponse) {

        this.YesResponse = yesResponse;
        this.total = this.YesResponse + this.NoResponse;
    }

    public int getNoResponse() {
        return NoResponse;
    }

    public void setNoResponse(int noResponse) {

        this.NoResponse = noResponse;
        this.total = this.YesResponse + this.NoResponse;
    }

    @Override
    public String toString() {
        return "Response{" +
                "id=" + id +
                ", watchkey='" + watchkey + '\'' +
                ", YesResponse=" + YesResponse +
                ", NoResponse=" + NoResponse +
                ", total=" + total +
                '}';
    }
}
