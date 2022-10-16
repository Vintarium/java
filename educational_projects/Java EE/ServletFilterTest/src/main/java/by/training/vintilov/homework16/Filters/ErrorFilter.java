package by.training.vintilov.homework16.Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "checkFilter", urlPatterns = {"/catalog", "/order"})
public class ErrorFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        if (((HttpServletRequest) req).getSession().getAttribute("checkbox") == null || !((HttpServletRequest) req).getSession().getAttribute("checkbox").equals("on")) {
            ((HttpServletResponse) resp).sendRedirect(((HttpServletRequest) req).getContextPath() + "/error");
        }

        if (((HttpServletRequest) req).getSession().getAttribute("name") == null || ((HttpServletRequest) req).getSession().getAttribute("name").equals("")) {
            ((HttpServletResponse) resp).sendRedirect(((HttpServletRequest) req).getContextPath() + "/errorLogin");
        }

        chain.doFilter(req, resp);
    }

    public void destroy() {
    }


}
