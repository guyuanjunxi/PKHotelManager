package PKhotel.dao;

import PKhotel.bean.Person;
import PKhotel.util.DButil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonDao{

    public List<Person> queAll(DButil dbutil) throws Exception{
        String sql = "select * from manager";
        List<Map<String,Object>> list = dbutil.query(sql);
        List<Person> personList = new ArrayList<>();
        Person person = null;
        for(Map<String,Object>map:list){
            person = new Person((String)map.get("id"),(String)map.get("name"),(String) map.get("sfzh"));
            personList.add(person);
        }
        return personList;
    }

    public boolean changeName(Person p, DButil dButil) {
        String sql = "update manager set name=? where id=?";
        Object[] objects = {p.getName(),p.getId()};
        if(dButil.executeUpdate(sql,objects)==1) return true;
        else return false;
    }

    public boolean changeSfzh(Person p, DButil dButil) {
        String sql = "update manager set sfzh=? where id=?";
        Object[] objects = {p.getSfzh(),p.getId()};
        if(dButil.executeUpdate(sql,objects)==1) return true;
        else return false;
    }

}