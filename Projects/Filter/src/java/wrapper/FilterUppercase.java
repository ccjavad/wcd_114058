package wrapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Locale;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class FilterUppercase implements Filter {
    
//    class MyResponse implements HttpServletResponse {
//        
//        private HttpServletResponse realResponse;
//        private PrintWriter out;
//
//        public MyResponse(HttpServletResponse realResponse) {
//            this.realResponse = realResponse;
//            
//            try {
//                out = new PrintWriter("C:\\Users\\apatrin\\Desktop\\servletout.txt");
//            } catch(IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        public PrintWriter getWriter() {
//            return out;
//        }
//
//        @Override
//        public void addCookie(Cookie cookie) {
//            realResponse.addCookie(cookie);
//        }
//        
//        //anderen Methoden ähnlich wie die addCookie realisieren
//        //...
//    }
    
    class MyResponse extends HttpServletResponseWrapper {

        private PrintWriter out;
        private StringWriter sw = new StringWriter();
        
        public MyResponse(HttpServletResponse realResponse) {
            super(realResponse);
            out = new PrintWriter(sw);
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return out;
        }
        
        String getText() {
            out.close();
            return sw.toString();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, 
            FilterChain chain) throws IOException, ServletException {
        
        MyResponse myResponse = new MyResponse((HttpServletResponse)response);
        chain.doFilter(request, myResponse);
        
        String text = myResponse.getText();
        text = text.toUpperCase();
        response.getWriter().print(text);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
