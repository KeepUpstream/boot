package com.example.boot.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class CorsFilter implements Filter {

      @Override
      public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
           HttpServletResponse res = (HttpServletResponse) response;
           String [] allowDomains = {"http://127.0.0.1:8085","http://localhost:8085"};
           Set<String> allowOrigins = new HashSet<String>(Arrays.asList(allowDomains));
           String originHeader = ((HttpServletRequest) request).getHeader("Origin");
           if(allowOrigins.contains(originHeader)){
               res.addHeader("Access-Control-Allow-Credentials", "true");
               res.addHeader("Access-Control-Allow-Origin", originHeader);
               res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
               res.addHeader("Access-Control-Allow-Headers", "Content-Type,X-CAF-Authorization-Token,sessionToken,X-TOKEN");
               if (((HttpServletRequest) request).getMethod().equals("OPTIONS")) {
                   response.getWriter().println("ok");
                   return;
               }
           }
          chain.doFilter(request, response);

        }
    @Override
    public void destroy() {
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}
