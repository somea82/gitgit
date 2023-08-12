package com.springboot.watchresponse.DAO;



import com.springboot.watchresponse.Entity.Response;
import com.springboot.watchresponse.Repository.ResponseRepository;
import com.springboot.watchresponse.Controller.ResponseRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResponseDAOImpl implements ResponseDAO{

    private final ResponseRepository responseRepository;

    @Autowired
    public ResponseDAOImpl(ResponseRepository responseRepository) {this.responseRepository=responseRepository;}


    // WatchKey로 DB 안에 Response 객체가 없다는 것을 찾았을 경우 새로
    // DB안에 Response 객체를 만들어 넣기 위해 만든 매서드입니다.
    @Override
    public Response insertResponse(ResponseRequest answer) {
        Response response1 = new Response(); //Response 생성
        response1.setWatchkey(answer.getWatchkey()); //Response watchkey 설정

        if (answer.getResponse().equals("Y")) { //만약 프론트에서 온 답변이 Y일 경우
            response1.setYesResponse(1); //Response객체의 YesResponse응답을 1로
            response1.setNoResponse(0);
            response1.setTotal(response1.getNoResponse()+ response1.getYesResponse());
            return response1;

        } else {
            response1.setNoResponse(1);
            response1.setYesResponse(0);
            response1.setTotal(response1.getNoResponse() + response1.getYesResponse());
            return response1;
        }


    }



    @Override
    public Response selectResponse(String watchkey) {
        return null;
    }

    // 이것은 만약 watchkey로 Response 객체가 조회되었을 경우
    // Response의 Yes와 No 값을 업데이트하기 위한 매서드입니다.
    @Override
    @Transactional
    public Response updateResponse(Response response , ResponseRequest answer) {
        //파라미터로 response객체와 프론트에서 온 answer 객체를 받습니다.
        if(answer.getResponse().equals("Y")) {
            //만약 프론트에서 온 Response값이 Y일 경우 기존의 YesResponse에서 1을 더해줍니다.
            response.setYesResponse(response.getYesResponse() + 1);
        }else{
            response.setNoResponse(response.getNoResponse()+1);
        }
        return response;
    }


}
