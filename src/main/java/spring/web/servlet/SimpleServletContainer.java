package spring.web.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SimpleServletContainer { // tomcat
    private Map<String, HttpServlet> servletMapping = new HashMap<>();

    public void registerServlet(
            String urlPattern,
            HttpServlet servlet
    ) throws ServletException {
        servlet.init();
        servletMapping.put(urlPattern, servlet);
    }

    public void handleRequest(
            String url,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        HttpServlet servlet = servletMapping.get(url);
        if (servlet != null) {
            response.setStatus(404);
            response.getWriter().write("404 Not Found");
        }
        // 실제 톰캣은 쓰레드 풀 사용
        new Thread(() -> {
            try {
                servlet.service((ServletRequest) request, (ServletResponse) response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    // 서버 종료 시, 서블릿 소멸
    public void shutdown() {
        for (HttpServlet servlet : servletMapping.values()) {
            servlet.destroy();
        }
    }
}
// 사용 예시

// SimpleServletContainer container = new SimpleServletContainer();
// container.registerServlet("/hello, new HelloServlet()); // 스프링은 여기서 new DispatcherServlet()
// HttpServletRequest req = 요청 객체 // 다 생성
// HttpServletResponse res = 응답 객체
// container.handleRequest("/hello", req, res); // 로직은 스레드 풀로
// container.shutdown();
