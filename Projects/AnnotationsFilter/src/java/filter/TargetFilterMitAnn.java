package filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/*
    <filter>
        <filter-name>FilterBelastung</filter-name>
        <filter-class>filter.TargetFilterBelastung</filter-class>
        
        <async-supported>false</async-supported>
        
        <init-param>
            <param-name>n1</param-name>
            <param-value>v1</param-value>
        </init-param>
        <init-param>
            <param-name>n2</param-name>
            <param-value>v2</param-value>
        </init-param>
        
    </filter>
    <filter-mapping>
        <filter-name>FilterBelastung</filter-name>
        <url-pattern>/target.jsp</url-pattern>
        
        <!--
        <servlet-name>Servlet-Name</servlet-name>
        -->
        <dispatcher>REQUEST</dispatcher>
        <dispatcher>FORWARD</dispatcher>
    </filter-mapping>
*/

@WebFilter(
    filterName = "My Filter Name",   //Bitte den Attribut-Namen merken (bei @WebServlet: 'name')

//    value = { "/target.jsp" },
    urlPatterns = { "/target.jsp" },
        
    asyncSupported = false,
    initParams = {
        @WebInitParam(name = "n1", value = "Wert 1"),
        @WebInitParam(name = "n2", value = "Wert 2")
    },
    
//    servletNames = { "Servlet-Name-1", "Servlet-Name-2" }
    
    dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD } //Exam!!!
)
public class TargetFilterMitAnn implements Filter {

    private String initParam1;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        initParam1 = filterConfig.getInitParameter("n1");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        System.out.println("--> Filter mit Ann");
        
        request.setAttribute("filter-att-2", initParam1);
        
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}
