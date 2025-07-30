package spring.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

public class SimpleDispatcherServlet extends HttpServlet {
    private final Map<String, Controller> handlerMapping = new HashMap<>();
    private final SimpleViewResolver viewResolver = new SimpleViewResolver();


    @Override
    public void init() { // 프론트 컨트롤러가 뜰 때
        // 0. 초기 핸들러 매핑 등록 (key: URI, value: Controller)
        handlerMapping.put("/hello", new HelloController());
    }

    @Override
    protected void service( // 해당 서블릿은 하나, 다중 요청시 톰켓에서 받은 request 객체가 이 함수로 멀티쓰레딩 처리
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException {
        try {
            // 1. 핸들러 매핑
            String requestURI = request.getRequestURI();
            Controller controller = handlerMapping.get(requestURI);
            if (controller == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }

            // 2. 컨트롤러 호출하여, modelAndView 생성
            ModelAndView mv = controller.handleRequest(request, response);

            // 3. ViewResolver 로 View 객체 찾기 (=> rest api는 여기서 생략되고 모델 dto객체 직렬화 반환)
            View view = viewResolver.resolveView(mv.getViewName());

            // 4. View 랜더링 : 모델 데이터를 html로 출력
            view.render(mv.getModel(), request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }


}
