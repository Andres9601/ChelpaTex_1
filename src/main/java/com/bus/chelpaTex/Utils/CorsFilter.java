package com.bus.chelpaTex.Utils;

		
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CorsFilter implements Filter {
   @Override
   public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
      HttpServletResponse response = (HttpServletResponse) res;
      response.setHeader("Access-Control-Allow-Origin", "*");
      response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
      response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
      response.setHeader("Access-Control-Allow-Headers", "x-firebase-auth, Content-Type");
      chain.doFilter(req, res);
   }

   @Override
   public void init(FilterConfig filterConfig) throws ServletException {}

   @Override
   public void destroy() {}
}






