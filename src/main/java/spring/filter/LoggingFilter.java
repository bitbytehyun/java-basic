package spring.filter;

public class LoggingFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        System.out.println("LoggingFilter.doFilter 요청 데이터: " + request.data);
        chain.doFilter(request, response);
        System.out.println("LoggingFilter.doFilter 응답 데이터: " + response.result);
    }
}
