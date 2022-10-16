package by.training.vintilov.filtres;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Objects;

@WebFilter(urlPatterns = "/loginServlet")
public class ErrorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (Objects.equals(servletRequest.getParameter("name"), "")) {
            servletRequest.getRequestDispatcher("/WEB-INF/jsp/errorJsp/emptyName.jsp").forward(servletRequest, servletResponse);
        }
        if (servletRequest.getParameter("checkbox") == null) {
            servletRequest.getRequestDispatcher("/WEB-INF/jsp/errorJsp/checkboxError.jsp").forward(servletRequest, servletResponse);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
    @Override
    public void destroy() {
    }
}
