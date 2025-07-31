package spring.filter;


import java.util.List;

public class FilterChain {
    private final List<Filter> filters;
    private int currentPositon = 0;

    public FilterChain(List<Filter> filters) {
        this.filters = filters;
    }

    public void doFilter(Request request, Response response) {
        if (currentPositon < filters.size()) {
            Filter nextFilter = filters.get(currentPositon++);
            nextFilter.doFilter(request, response, this);
        } else {
            System.out.println(">> Controller or Servlet 실행");
            response.result = "응답 완료";
        }

    }

}
// 실행 예시
// Filter loggingFilter = new LoggingFilter();
// Filter AuthFilter = new AuthFilter();
// FilterChain chain = new FilterChain(Arrays.asList(loggingFilter, authFilter));
// Request req = new Request();
// Response res = new Response();

// chain.doFilter(req, res);
