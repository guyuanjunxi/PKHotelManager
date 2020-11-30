package PKhotel.dao;

import PKhotel.bean.Employees;
import PKhotel.bean.Person;
import PKhotel.util.DButil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeesDao {
    public List<Employees> queAll(DButil dButil) {
        String sql = "select * from dagongren";
        List<Map<String,Object>> list = dButil.query(sql);
        List<Employees> employeesList = new ArrayList<>();
        Employees employees = null;
        for(Map<String,Object>map:list){
            employees = new Employees((String)map.get("id"),(String)map.get("name"),(String) map.get("sfzh"),(String)map.get("phone"));
            employeesList.add(employees);
        }
        return employeesList;
    }

    public boolean changeName(Employees p, DButil dButil) {
        String sql = "update dagongren set name=? where id=?";
        Object[] objects = {p.getName(),p.getId()};
        if(dButil.executeUpdate(sql,objects)==1) return true;
        else return false;
    }

    public boolean changeSfzh(Employees p, DButil dButil) {
        String sql = "update dagongren set sfzh=? where id=?";
        Object[] objects = {p.getSfzh(),p.getId()};
        if(dButil.executeUpdate(sql,objects)==1) return true;
        else return false;
    }

    public boolean changePhone(Employees p, DButil dButil) {
        String sql = "update dagongren set phone=? where id=?";
        Object[] objects = {p.getTeleno(),p.getId()};
        if(dButil.executeUpdate(sql,objects)==1) return true;
        else return false;
    }

    public boolean addEmployees(Employees p, DButil dButil) {
        String sql = "insert into dagongren(id,name,password,sfzh,phone) values(?, ?, ?, ?, ?)";
        Object[] objects = {p.getId(),p.getName(),"888",p.getSfzh(),p.getTeleno()};
        if(dButil.executeUpdate(sql,objects)==1) return true;
        else return false;
    }

    public boolean deleteEmployees(Employees p, DButil dButil) {
        String sql = "delete from dagongren where id=?";
        Object[] objects = {p.getId()};
        if(dButil.executeUpdate(sql,objects)==1) return true;
        else return false;
    }
}
