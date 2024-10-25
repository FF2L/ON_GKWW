package com.example.demo2.servlet;

import com.example.demo2.dao_imp.DanhMuc_imp;
import com.example.demo2.model.DanhMuc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/DanhSachDanhMucMucServlet")
public class DanhSachDanhMucServlet extends HttpServlet {
    private DanhMuc_imp danhMuc_imp = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        danhMuc_imp = new DanhMuc_imp();
        List<DanhMuc> listDM = danhMuc_imp.getAllDanhMuc();
        req.setAttribute("listDM", listDM);
        req.getRequestDispatcher("/View/DanhSachDanhMuc.jsp").forward(req,resp);
        //req.setAttribute gán danh sách danh mục vào yêu cầu,
        // và req.getRequestDispatcher chuyển hướng yêu cầu đến tệp JSP để hiển thị danh sách.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            String tenDM = req.getParameter("tenDM");
            String nguoiQL =req.getParameter("nguoiQL");
            String ghiChu = req.getParameter("ghiChu");

            DanhMuc dm = new DanhMuc(tenDM, nguoiQL, ghiChu);
            if (action.equalsIgnoreCase("Them")){
                DanhMuc_imp dmImp = new DanhMuc_imp();
                dmImp.addDanhMuc(dm);
            }else if(action.equalsIgnoreCase("Delete")){
                DanhMuc_imp dmImp = new DanhMuc_imp();
                int maDM = Integer.parseInt(req.getParameter("maDM"));
                dmImp.deleteDanhMuc(maDM);
            }else if(action.equalsIgnoreCase("Update")){
                DanhMuc_imp dmImp = new DanhMuc_imp();
                int maDM = Integer.parseInt(req.getParameter("maDM"));
                DanhMuc danhMuc = new DanhMuc(maDM,tenDM,nguoiQL,ghiChu);
                dmImp.updatDanhMuc(danhMuc);
            }

            resp.sendRedirect( req.getContextPath()+"/DanhSachDanhMucMucServlet");
        }catch (Exception e){
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }

    }
}
