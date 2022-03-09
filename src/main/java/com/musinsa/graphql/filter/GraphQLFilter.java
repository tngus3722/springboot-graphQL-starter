package com.musinsa.graphql.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.springframework.stereotype.Component;

@Component
@WebFilter(urlPatterns = "/*")
public class GraphQLFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter run!");
        chain.doFilter(request, response);
    }
}
