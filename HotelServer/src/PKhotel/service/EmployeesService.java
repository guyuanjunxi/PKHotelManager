package PKhotel.service;

import PKhotel.bean.Employees;
import PKhotel.bean.Person;
import PKhotel.util.DButil;

import java.util.List;

public interface EmployeesService {
    public List<Employees> queAll(DButil dButil);
    public boolean changeName(Employees p,DButil dButil);
    public boolean changeSfzh(Employees p, DButil dButil);
    public boolean changePhone(Employees p,DButil dButil);
    public boolean addEmployees(Employees p,DButil dButil);
    public boolean deleteEmployees(Employees p,DButil dButil);
}
