package PKhotel.web.servlet;

import PKhotel.bean.Person;
import PKhotel.bean.Room;
import PKhotel.service.Impl.PersonServiceImpl;
import PKhotel.service.Impl.RoomServiceImpl;
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

@WebServlet(name="changeRoomServlet")
public class ChangeRoomServlet extends HttpServlet {
    DButil dButil = new DButil();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        try(PrintWriter out = response.getWriter()){
            String id = request.getParameter("id").trim();
            String name = request.getParameter("name").trim();
            String bednum = request.getParameter("bednum").trim();
            String size = request.getParameter("size").trim();
            String price = request.getParameter("price").trim();
            String kongtiao = request.getParameter("kongtiao").trim();
            String tv = request.getParameter("tv").trim();
            String weiyu = request.getParameter("weiyu").trim();
            String cfj = request.getParameter("cfj").trim();
            String dianhua = request.getParameter("dianhua").trim();
            boolean result = false;
            RoomServiceImpl service = new RoomServiceImpl();

            Map<String,String> params = new HashMap<>();
            JSONObject jsonObject = new JSONObject();

            if(!name.equals("")){
                result = service.changeName(new Room(id,name,null,null,null,null
                        ,null,null,null,null),dButil);
            }

            if(!bednum.equals("")){
                result = service.changeBednum(new Room(id,null,bednum,null,null,null
                        ,null,null,null,null),dButil);
            }

            if(!size.equals("")){
                result = service.changeSize(new Room(id,null,null,size,null,null
                        ,null,null,null,null),dButil);
            }

            if(!price.equals("")){
                result = service.changeName(new Room(id,null,null,null,price,null
                        ,null,null,null,null),dButil);
            }

            if(!kongtiao.equals("")){
                result = service.changeName(new Room(id,null,null,null,null,kongtiao
                        ,null,null,null,null),dButil);
            }

            if(!tv.equals("")){
                result = service.changeName(new Room(id,null,null,null,null,null
                        ,tv,null,null,null),dButil);
            }

            if(!weiyu.equals("")){
                result = service.changeName(new Room(id,null,null,null,null,null
                        ,null,weiyu,null,null),dButil);
            }

            if(!cfj.equals("")){
                result = service.changeName(new Room(id,null,null,null,null,null
                        ,null,null,cfj,null),dButil);
            }

            if(!dianhua.equals("")){
                result = service.changeName(new Room(id,null,null,null,null,null
                        ,null,null,null,dianhua),dButil);
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
