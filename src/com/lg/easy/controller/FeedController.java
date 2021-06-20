package com.lg.easy.controller;

import com.lg.easy.dao.FeedDao;
import com.lg.easy.entity.Feed;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/feed")
public class FeedController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;utf-8");

        String pNumber =req.getParameter("pNumber");
        String pWeight =req.getParameter("pWeight");
        String pFood = req.getParameter("pFood");

        Feed obj =new Feed();
        obj.setFeed_number(pNumber);
        obj.setNew_weight(pWeight);
        obj.setFood(pFood);


        FeedDao feedDao =new FeedDao();
        int row = feedDao.publish(obj);
        int row1 = feedDao.change(obj);
        if (row>0&&row1>0){
            resp.getWriter().println("上传喂养记录成功");
        }
        else{
            resp.getWriter().println("上传喂养记录失败");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
