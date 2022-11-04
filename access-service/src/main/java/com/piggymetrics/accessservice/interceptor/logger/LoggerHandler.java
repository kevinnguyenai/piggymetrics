package com.piggymetrics.accessservice.interceptor.logger;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggerHandler implements HandlerInterceptor{
    
    private static Logger logger = LoggerFactory.getLogger(LoggerHandler.class);

    /**
     * @author Kevin
     */
    @Override
    public boolean preHandle(
        final HttpServletRequest request,
        final HttpServletResponse response,
        final Object handler) throws Exception {
            logger.info("[preHandle][" + request + "]" + "[" + request.getMethod() + "]" + request.getRequestURI() + getParameters(request));
            return true;
        }

    /**
     * @author Kevin
     */
    @Override
    public void postHandle(
        final HttpServletRequest request,
        final HttpServletResponse response,
        final Object handler,
        final ModelAndView modelAndView) throws Exception {
            logger.info("[postHandle][" + request + "]");
        }

    @Override
    public void afterCompletion(
        final HttpServletRequest request,
        final HttpServletResponse response,
        final Object handler,
        final Exception ex) throws Exception {
            if (ex != null)
                ex.printStackTrace();
            logger.info("[afterCompletion][" + request + "][exception: " + ex + "]");
        }
    
    
    /**
     * @author Kevin
     * @param request is HttpServletRequest
     * @return ?args=.... as String 
     */
    private String getParameters(final HttpServletRequest request) {
        final StringBuffer posted = new StringBuffer();
        final Enumeration<?> e = request.getParameterNames();
        if (e != null) {
            posted.append("?");
        }
        while (e != null && e.hasMoreElements()) {
            if (posted.length() > 1) {
                posted.append("&");
            }
            final String curr = (String) e.nextElement();
            posted.append(curr)
                .append("=");
            if (curr.contains("password") || curr.contains("answer") || curr.contains("pwd")) {
                posted.append("*****");
            } else {
                posted.append(request.getParameter(curr));
            }
        }

        final String ip = request.getHeader("X-FORWARDED-FOR");
        final String ipAddr = (ip == null) ? getRemoteAddr(request) : ip;
        if (!Strings.isNullOrEmpty(ipAddr)) {
            posted.append("&_psip=" + ipAddr);
        }
        return posted.toString();
    }

    /**
     * @author Kevin
     * @param request
     * @return
     */
    private String getRemoteAddr(final HttpServletRequest request) {
        final String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
        if (ipFromHeader != null && ipFromHeader.length() > 0) {
            logger.debug("ip from proxy - X-FROWARDED-FOR : " + ipFromHeader);
            return ipFromHeader;
        }
        return request.getRemoteAddr();
    }
}
