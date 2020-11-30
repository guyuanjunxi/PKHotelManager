package PKhotel.service.Impl;

import PKhotel.bean.Employees;
import PKhotel.dao.EmployeesDao;
import PKhotel.service.EmployeesService;
import PKhotel.util.DButil;

import java.util.List;

public class EmployeesServiceImpl implements EmployeesService {

    EmployeesDao employeesDao = new EmployeesDao();

    @Override
    public List<Employees> queAll(DButil dButil) {
        List<Employees> employeesList = null;
        try{
            employeesList = employeesDao.queAll(dButil);
        }catch (Exception e){
            e.printStackTrace();
        }
        return employeesList;
    }

    @Override
    public boolean changeName(Employees p, DButil dButil) {
        boolean isok = false;
        try{
            isok = employeesDao.changeName(p,dButil);
        }catch (Exception e){
            e.printStackTrace();
        }
        return isok;
    }

    @Override
    public boolean changeSfzh(Employees p, DButil dButil) {
        boolean isok = false;
        try{
            isok = employeesDao.changeSfzh(p,dButil);
        }catch (Exception e){
            e.printStackTrace();
        }
        return isok;
    }

    @Override
    public boolean changePhone(Employees p, DButil dButil) {
        boolean isok = false;
        try{
            isok = employeesDao.changePhone(p,dButil);
        }catch (Exception e){
            e.printStackTrace();
        }
        return isok;
    }

    @Override
    public boolean addEmployees(Employees p, DButil dButil) {
        boolean isok = false;
        try{
            isok = employeesDao.addEmployees(p,dButil);
        }catch (Exception e){
            e.printStackTrace();
        }
        return isok;
    }

    @Override
    public boolean deleteEmployees(Employees p, DButil dButil) {
        boolean isok = false;
        try{
            isok = employeesDao.deleteEmployees(p,dButil);
        }catch (Exception e){
            e.printStackTrace();
        }
        return isok;
    }
}
