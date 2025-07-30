package spring.web.servlet;

public class SimpleViewResolver {
    public View resolveView(String viewName) {
        return new View("/WEB-INF/views/" + viewName + ".jsp");
    }
}
