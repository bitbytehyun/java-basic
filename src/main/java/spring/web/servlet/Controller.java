package spring.web.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
    ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response);
}
