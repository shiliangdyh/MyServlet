import javax.servlet.*;
import java.io.IOException;

public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
// 获取初始化参数
        String site = filterConfig.getInitParameter("Site");
        // 输出初始化参数
        System.out.println("网站名称: " + site);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
// 输出站点名称
        System.out.println("站点网址：http://www.runoob.com");
        String name = servletRequest.getParameter("name");
        if (name.equals("abc")) {

        }
        filterChain.doFilter(servletRequest, servletResponse);
//        if ("abc".equals(name)) {
//            // 把请求传回过滤链
//            filterChain.doFilter(servletRequest, servletResponse);
//        }else {
//            servletResponse.setContentType("text/html;charset=GBK");
//            PrintWriter writer = servletResponse.getWriter();
//            writer.println("<b>name不正确<b/>");
//        }

    }

    @Override
    public void destroy() {

    }
}
