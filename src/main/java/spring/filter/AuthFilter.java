package spring.filter;

public class AuthFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        if (request.data.contains("token")) {
            System.out.println("Auth 인증 성공");
            chain.doFilter(request, response);
        } else {
            System.out.println("Auth 인증 실패");
            response.result = "인증 실패";
        }
    }
}
