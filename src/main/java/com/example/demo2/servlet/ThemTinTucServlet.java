package com.example.demo2.servlet;

import com.example.demo2.dao_imp.DanhMuc_imp;
import com.example.demo2.dao_imp.TinTuc_imp;
import com.example.demo2.model.DanhMuc;
import com.example.demo2.model.TinTuc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/ThemTinTucServlet")
public class ThemTinTucServlet extends HttpServlet {
    private TinTuc_imp tinTuc_imp = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DanhMuc_imp danhMuc_imp = new DanhMuc_imp();
        List<DanhMuc> listdm = danhMuc_imp.getAllDanhMuc();
        req.setAttribute("listdm", listdm);
        req.getRequestDispatcher("/View/ThemTinTuc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            tinTuc_imp = new TinTuc_imp();
            int maDM = Integer.parseInt(req.getParameter("maDM"));
            String tieuDe = req.getParameter("tieuDe");
            String noiDungTT = req.getParameter("noiDungTT");
            String LienKet = req.getParameter("lienKet");

            TinTuc tt = new TinTuc(new DanhMuc(maDM),tieuDe,noiDungTT,LienKet);
            tinTuc_imp.addTinTuc(tt);
            resp.sendRedirect(req.getContextPath()+"/ThemTinTucServlet");
        }catch (Exception e){
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
