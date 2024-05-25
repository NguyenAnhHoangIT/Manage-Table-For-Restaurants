package Busisness_logic;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JspExtensionFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        // Khởi tạo
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String url = httpRequest.getRequestURI();
        
        // Kiểm tra nếu URL có đuôi .jsp
        if (url.endsWith(".jsp")) {
            // Loại bỏ đuôi .jsp
            String newUrl = url.substring(0, url.lastIndexOf(".jsp"));
            // Chuyển hướng request tới URL mới
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect(newUrl);
        } else {
            // Nếu không phải là URL có đuôi .jsp, chuyển tiếp request/response cho filter tiếp theo trong chuỗi filter
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
        // Giải phóng tài nguyên
    }
}
