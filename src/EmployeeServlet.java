import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EmployeeServlet extends HttpServlet {
    private List<Employee> employees = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        LocalDate joiningDate = LocalDate.parse(request.getParameter("joiningDate"));

        Employee newEmployee = new Employee(id, name, dateOfBirth, email, joiningDate, role);
        employees.add(newEmployee);

        response.sendRedirect(request.getContextPath() + "/EmployeeServlet?action=list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("list")) {
            calculateLeaves();
            request.setAttribute("employees", employees);
            request.getRequestDispatcher("employeeList.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
        }
    }

    private void calculateLeaves() {
        for (Employee emp : employees) {
            int vacationLeave = emp.calculateVacationLeave();
            int sickLeave = emp.calculateSickLeave();
            emp.setVacationLeave(vacationLeave);
            emp.setSickLeave(sickLeave);
        }
    }
}


