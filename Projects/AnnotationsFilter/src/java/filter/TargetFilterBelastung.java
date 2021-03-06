package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TargetFilterBelastung implements Filter {
    
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, 
            FilterChain chain) throws IOException, ServletException {
        
        System.out.println("--> Filter aus DD");
        
        String initParam = filterConfig.getInitParameter("n1");
        request.setAttribute("filter-att", "Mein init-Parameter n1: " + initParam);
        
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
    
}
