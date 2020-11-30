package PKhotel.web.servlet;

import PKhotel.bean.Employees;
import PKhotel.service.Impl.EmployeesServiceImpl;
import PKhotel.util.DButil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name="deleteEmployeesServlet")
public class DeleteEmployeesServlet extends HttpServlet {
    DButil dButil = new DButil();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        try(PrintWriter out = response.getWriter()){
            String id = request.getParameter("id").trim();

            EmployeesServiceImpl service = new EmployeesServiceImpl();
            List<Employees> employeesList = service.queAll(dButil);
            Map<String,String> params = new HashMap<>();
            JSONObject jsonObject = new JSONObject();

            boolean hasId = false;
            //id是否存在
            for(Employees employees:employeesList){
                if(id.equals(employees.getId())){
                    hasId = true;
                    break;
                }
            }

            if(!hasId) {
                params.put("Result","TheIdNotExists");
            }else{
                service.deleteEmployees(new Employees(id,null,null,null),dButil);
                params.put("Result","DeleteSucceed");
            }

            jsonObject.put("params",params);
            out.write(jsonObject.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
