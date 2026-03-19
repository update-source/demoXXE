package com.xxe.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.xxe.wrappers.XmlBodyRequestWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/product/*")
public class XmlRequestNormalizationFilter implements Filter {
    
  private final List<String> XML_METHODS = Arrays.asList("POST", "PUT", "PATCH");

  /** 
   * @param request
   * @param response
   * @param chain
   * @throws IOException
   * @throws ServletException
   */
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    
    if (request instanceof HttpServletRequest httpRequest) {
      String contentType = httpRequest.getContentType();
      String method = httpRequest.getMethod();

      if (XML_METHODS.contains(method) && contentType != null && 
        (contentType.contains("application/xml") || contentType.contains("text/xml"))) {
        XmlBodyRequestWrapper wrappedRequest = new XmlBodyRequestWrapper(httpRequest);
        chain.doFilter(wrappedRequest, response); 
        return;
      }
    }
    
    chain.doFilter(request, response);
  }
}