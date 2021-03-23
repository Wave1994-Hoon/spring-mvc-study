package servlet.servlet.web.frontcontroller.v2;

import servlet.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * V1 구조
 * 1. Client -> HTTP 요청
 * 2. FrontController -> URL 매핑 정보에서 컨트롤러 조회
 * 3. 조회된 컨트롤러 호출
 * 5. MyView 반환
 * 6. render 호출
 * 7. 해당 JSP forward
 * 8. Response
 * */

public interface ControllerV2 {

    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
