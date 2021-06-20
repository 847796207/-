package com.lg.easy.controller;

import com.lg.easy.dao.FeedDao;
import com.lg.easy.dao.VaccineDao;
import com.lg.easy.entity.Feed;
import com.lg.easy.entity.Vaccine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vaccine")
public class VaccineController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;utf-8");

        String pNumber =req.getParameter("pNumber");
        String pVaccine =req.getParameter("pVaccine");


        Vaccine obj =new Vaccine();
        obj.setStock_number(pNumber);
        obj.setVaccine(pVaccine);



        VaccineDao vaccineDao =new VaccineDao();
        int row = vaccineDao.publish(obj);
        int row1 = vaccineDao.change(obj);
        if (row>0&&row1>0){
            resp.getWriter().println("上传接种记录成功");
        }
        else{
            resp.getWriter().println("上传接种记录失败");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
