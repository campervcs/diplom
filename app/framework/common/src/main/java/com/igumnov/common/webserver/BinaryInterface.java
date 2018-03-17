package com.igumnov.common.webserver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BinaryInterface {
    byte[] response(HttpServletRequest request, HttpServletResponse response) throws WebServerException;
}
