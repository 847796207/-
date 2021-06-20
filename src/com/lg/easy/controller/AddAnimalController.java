package com.lg.easy.controller;

import com.lg.easy.dao.FeedDao;
import com.lg.easy.dao.LivestockDao;
import com.lg.easy.entity.Feed;
import com.lg.easy.entity.livestock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddAnimalController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;utf-8");

        String pNumber =req.getParameter("pNumber");
        String pWeight =req.getParameter("pWeight");
        String pRegin = req.getParameter("pRegin");
        String pCategory =req.getParameter("pCategory");
        String pOrigin= req.getParameter("pOrigin");

        livestock obj =new livestock();
        String pAvater = System.getProperty("Path");

        obj.setNumber(pNumber);
        obj.setWeight(pWeight);
        obj.setRegin(pRegin);
        obj.setCategory(pCategory);
        obj.setOrigin(pOrigin);
        obj.setAvater(pAvater);
        obj.setFeed("no");
        LivestockDao livestockDao =new LivestockDao();
        int row = livestockDao.addNewAnimal(obj);

        if (row>0){
            resp.getWriter().println("上传禽畜资料成功");
        }
        else{
            resp.getWriter().println("上传禽畜资料失败");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}