package cn.edu.niit.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ClassName EncodingFilter
 * @Description TODO
 * @Author SY
 * @Date 2021/3/30
 **/
@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
public class EncodingFilter  implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
            ServletException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        chain.doFilter(req,resp);
    }
}