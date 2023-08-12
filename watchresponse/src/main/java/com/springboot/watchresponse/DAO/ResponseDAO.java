package com.springboot.watchresponse.DAO;


import com.springboot.watchresponse.Entity.Response;
import com.springboot.watchresponse.Controller.ResponseRequest;

public interface ResponseDAO {


    Response insertResponse(ResponseRequest answer);

    Response selectResponse(String watchkey);

    Response updateResponse(Response response,ResponseRequest answer);



}
