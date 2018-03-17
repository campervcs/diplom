package com.igumnov.common.webserver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface RestControllerInterface {

    Object response(HttpServletRequest request, HttpServletResponse response ,Object postObject) throws WebServerException;
}
