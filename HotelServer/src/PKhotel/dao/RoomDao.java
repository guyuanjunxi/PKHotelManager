package PKhotel.dao;

import PKhotel.bean.Person;
import PKhotel.bean.Room;
import PKhotel.util.DButil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoomDao {
    public static List<Room> queAll(DButil dButil) {
        String sql = "select * from room";
        List<Map<String,Object>> list = dButil.query(sql);
        List<Room> roomList = new ArrayList<>();
        Room room = null;
        for(Map<String,Object>map:list){
            room = new Room((String)map.get("id"),(String)map.get("name"),(String) map.get("bednum"),(String)map.get("size")
                    ,(String)map.get("price"),(String)map.get("kongtiao"),(String)map.get("tv"),(String)map.get("weiyu")
                    ,(String)map.get("cfj"),(String)map.get("dianhua"));
            roomList.add(room);
        }
        return roomList;
    }

    public boolean changeName(Room p, DButil dButil) {
        String sql = "update room set name=? where id=?";
        Object[] objects = {p.getName(),p.getId()};
        if(dButil.executeUpdate(sql,objects)==1) return true;
        else return false;
    }

    public boolean changeBednum(Room p, DButil dButil) {
        String sql = "update room set bedbun=? where id=?";
        Object[] objects = {p.getBednum(),p.getId()};
        if(dButil.executeUpdate(sql,objects)==1) return true;
        else return false;
    }

    public boolean changeSize(Room p, DButil dButil) {
        String sql = "update room set size=? where id=?";
        Object[] objects = {p.getSize(),p.getId()};
        if(dButil.executeUpdate(sql,objects)==1) return true;
        else return false;
    }

    public boolean changePrice(Room p, DButil dButil) {
        String sql = "update room set price=? where id=?";
        Object[] objects = {p.getPrice(),p.getId()};
        if(dButil.executeUpdate(sql,objects)==1) return true;
        else return false;
    }

    public boolean changekongtiao(Room p, DButil dButil) {
        String sql = "update room set kongtiao=? where id=?";
        Object[] objects = {p.getKongtiao(),p.getId()};
        if(dButil.executeUpdate(sql,objects)==1) return true;
        else return false;
    }

    public boolean changetv(Room p, DButil dButil) {
        String sql = "update room set tv=? where id=?";
        Object[] objects = {p.getTv(),p.getId()};
        if(dButil.executeUpdate(sql,objects)==1) return true;
        else return false;
    }

    public boolean changeweiyu(Room p, DButil dButil) {
        String sql = "update room set weiyu=? where id=?";
        Object[] objects = {p.getWeiyu(),p.getId()};
        if(dButil.executeUpdate(sql,objects)==1) return true;
        else return false;
    }

    public boolean changecfj(Room p, DButil dButil) {
        String sql = "update room set cfj=? where id=?";
        Object[] objects = {p.getCfj(),p.getId()};
        if(dButil.executeUpdate(sql,objects)==1) return true;
        else return false;
    }

    public boolean changedianhua(Room p, DButil dButil) {
        String sql = "update room set dianhua=? where id=?";
        Object[] objects = {p.getDianhua(),p.getId()};
        if(dButil.executeUpdate(sql,objects)==1) return true;
        else return false;
    }
}
