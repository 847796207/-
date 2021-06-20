package com.lg.easy.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@MultipartConfig //支持文件上传
@WebServlet("/upload.do")
public class FileUploadController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;utf-8");

        Part mfile = req.getPart("mfile");

        String filename = mfile.getSubmittedFileName();
        //UUID.randomUUID()+
        //String path =req.getServletContext().getRealPath("/upload/");
        String path ="D:/实习/LivestockManagement/web/img/";
        File dir =new File(path);
        if (!dir.exists()){
            dir.mkdirs();
        }
        mfile.write(path+filename);
        System.setProperty("Path","img/"+filename);
        resp.getWriter().println("img/"+filename);
    }
}
