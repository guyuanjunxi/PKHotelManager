package PKhotel.web.servlet;

import PKhotel.bean.Employees;
import PKhotel.bean.Person;
import PKhotel.service.Impl.EmployeesServiceImpl;
import PKhotel.service.Impl.PersonServiceImpl;
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
import java.util.Map;

@WebServlet(name="changeEmployeesServlet")
public class ChangeEmployeesServlet extends HttpServlet {
    DButil dButil = new DButil();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        try(PrintWriter out = response.getWriter()){
            String id = request.getParameter("id").trim();
            String name = request.getParameter("name").trim();
            String sfzh = request.getParameter("sfzh").trim();
            String phone = request.getParameter("phone").trim();
            boolean result = false;
            EmployeesServiceImpl service = new EmployeesServiceImpl();

            Map<String,String> params = new HashMap<>();
            JSONObject jsonObject = new JSONObject();

            if(!name.equals("")){
                //params.put("Result","ChangeNameSucceed");
                //params.put("Result","ChangeFail");
                result = service.changeName(new Employees(id,name,null,null),dButil);
            }

            if(!sfzh.equals("")){
                //params.put("Result","ChangeSfzhSucceed");
                //params.put("Result","ChangeFail");
                result = service.changeSfzh(new Employees(id,null,sfzh,null),dButil);
            }

            if(!phone.equals("")){
                //params.put("Result","ChangePhoneSucceed");
                //params.put("Result","ChangeFail");
                result = service.changePhone(new Employees(id,null,null,phone),dButil);
            }

            if(result){
                params.put("Result","ChangeSucceed");
            }else {
                params.put("Result","ChangeFail");
            }

            jsonObject.put("params",params);
            out.write(jsonObject.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
