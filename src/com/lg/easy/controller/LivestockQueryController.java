package com.lg.easy.controller;

import com.alibaba.fastjson.JSONObject;
import com.lg.easy.dao.LivestockDao;
import com.lg.easy.entity.livestock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/livestock")
public class LivestockQueryController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;utf-8");

        String page = req.getParameter("page");
        String keywords = req.getParameter("keywords");

        LivestockDao livestockDao = new LivestockDao();
        List<livestock> list = livestockDao.findByPage(page,keywords);

        String jsonString = JSONObject.toJSONString(list);

        resp.getWriter().println(jsonString);

    }
}
