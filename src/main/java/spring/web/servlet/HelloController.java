package spring.web.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("helloView");
        mv.addObject("message", "Hello World!"); // 뷰에 보낼 model (데이터) 저장
        return mv;
    }
}
