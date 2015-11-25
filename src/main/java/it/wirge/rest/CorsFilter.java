package it.wirge.rest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(filterName = "CorsFilter")
public class CorsFilter implements Filter {

    Logger logger = Logger.getLogger(this.getClass().getName());
    boolean allowCORS = false;

    public void destroy() {
        logger.info("destroy()");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;


        if (allowCORS || (httpServletRequest.getHeader("origin")!=null && httpServletRequest.getHeader("origin").contains("ticketone")))
        {
            httpServletResponse.addHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("origin"));
            httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, OPTIONS, DELETE");
            httpServletResponse.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Cookie, Set-Cookie");
            httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
        }
        chain.doFilter(httpServletRequest, httpServletResponse);    }

    public void init(FilterConfig config) throws ServletException {
        logger.info("init()");
        if("true".equals(config.getInitParameter("allowCORS"))) {
            logger.info("Allowing CORS requests");
            allowCORS = true;
        }
    }

}
