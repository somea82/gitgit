package com.springboot.watchresponse.Controller;




import com.springboot.watchresponse.DAO.ResponseDAO;
import com.springboot.watchresponse.Entity.Response;
import com.springboot.watchresponse.Repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {

    private final ResponseRepository responseRepository;
    private final ResponseDAO responseDAO;

    @Autowired
    public ResponseController(ResponseRepository responseRepository,ResponseDAO responseDAO){
        this.responseRepository = responseRepository;
        this.responseDAO = responseDAO;
    }

    @PostMapping("/api/check-response")
    public String ReturnResponse(@RequestBody ResponseRequest request) {
        String PostWatchkey = request.getWatchkey();
        System.out.println(PostWatchkey);
        try {
            Response response1 = responseRepository.findByWatchkey(PostWatchkey);
            if (response1 != null) {
                responseDAO.updateResponse(response1, request);
                return response1.toString();

            } else {
                Response response2 = responseDAO.insertResponse(request);
                responseRepository.save(response2);
                return response2.toString();

            }


        } catch (Exception e) {
            return e.toString();

        }
    }



}
