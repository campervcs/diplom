package com.igumnov.common.webserver;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BinaryHandler extends HttpServlet {

    BinaryInterface binaryInterface;
    public BinaryHandler(BinaryInterface i) {
        binaryInterface = i;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int status = HttpServletResponse.SC_OK;
        try {
            byte[] ret = binaryInterface.response(request,response);
            ServletOutputStream responseOutputStream =
                    response.getOutputStream();
            responseOutputStream.write(ret);
            responseOutputStream.flush();
            responseOutputStream.close();


        } catch (WebServerException e) {
            status = HttpServletResponse.SC_BAD_REQUEST;
            response.setContentType("text/html; charset=utf-8");
            response.setStatus(status);

            PrintWriter out = response.getWriter();

            out.write(e.getMessage());
        }


    }
}
