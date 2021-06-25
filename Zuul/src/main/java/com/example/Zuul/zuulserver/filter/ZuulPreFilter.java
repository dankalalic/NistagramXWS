package com.example.Zuul.zuulserver.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ZuulPreFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre ";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    private void setFailedRequest(String body, int code) {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setResponseStatusCode(code);
        if (ctx.getResponseBody() == null) {
            ctx.setResponseBody(body);
            ctx.setSendZuulResponse(false);
        }
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();


        String authHeader = request.getHeader("Authorization");
        String token = "";

        if (authHeader != null && authHeader.contains("Bearer "))
            token = authHeader.replace("Bearer ", "");

        return null;
    }

}