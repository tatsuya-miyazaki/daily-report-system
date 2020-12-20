package controllers.worktime;

import java.io.IOException;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import models.Worktime;
import utils.DBUtil;

/**
 * Servlet implementaervlet
 */
@WebServlet("/worktime/edit")
public class WorktimeEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorktimeEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**s
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();


        Worktime r =em.createNamedQuery("getMyWorktimesOfDate", Worktime.class)
        .setParameter("report_date", new Date(System.currentTimeMillis()))
        .setParameter("employee" , (Employee)request.getSession().getAttribute("login_employee"))
        .getSingleResult();

        em.close();

        Employee login_employee = (Employee)request.getSession().getAttribute("login_employee");
        if(r != null && login_employee.getId() == r.getEmployee().getId()) {
            request.setAttribute("r", r);
            request.setAttribute("_token", request.getSession().getId());
            request.getSession().setAttribute("report_id", r.getId());
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/worktimes/edit.jsp");
        rd.forward(request, response);
    }

}
