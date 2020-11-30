package PKhotel.dao;

import PKhotel.bean.User;
import PKhotel.util.DButil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDao {

    public List<User> queAll(DButil dbutil) throws Exception {
        String sql = "select * from manager";
        List<Map<String,Object>> list = dbutil.query(sql);
        List<User> userList = new ArrayList<>();
        User user = null;
        for(Map<String,Object> map:list){
            user = new User((String)map.get("id"),(String)map.get("password"));
            userList.add(user);
        }
        return userList;
    }

    public boolean changePassword(User user, DButil dButil){
        String sql = "update manager set password=? where id=?";
        Object[] objects = {user.getPassword(),user.getUsername()};
        if(dButil.executeUpdate(sql,objects)==1) return true;
        else return false;
    }
}
