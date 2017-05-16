package dispatch;

import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(
    urlPatterns = { "/gefiltertUndAsync.jsp" },
//    servletNames = {},
    asyncSupported = true
)
public class FilterAsyncDispatcher implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, 
            FilterChain chain) throws IOException, ServletException {
    
        if( request.isAsyncStarted() ) {
            chain.doFilter(request, response);
        } else {
            //Containerspezifisch (nicht in der Prüfung:)
            request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
            
            AsyncContext asyncContext = request.startAsync();
            asyncContext.dispatch();
        }
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
