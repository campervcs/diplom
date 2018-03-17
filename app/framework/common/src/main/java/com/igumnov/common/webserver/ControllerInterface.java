package com.igumnov.common.webserver;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface ControllerInterface {

    String process(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) throws WebServerException;

}
