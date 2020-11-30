package PKhotel.service.Impl;

import PKhotel.bean.Person;
import PKhotel.dao.PersonDao;
import PKhotel.service.PersonService;
import PKhotel.util.DButil;

import java.util.List;

public class PersonServiceImpl implements PersonService {
    PersonDao personDao = new PersonDao();
    @Override
    public List<Person> queAll(DButil dButil) {
        List<Person> personList = null;
        try{
            personList = personDao.queAll(dButil);
        }catch (Exception e){
            e.printStackTrace();
        }
        return personList;
    }

    @Override
    public boolean changeName(Person p, DButil dButil) {
        boolean isok = false;
        try{
            isok = personDao.changeName(p,dButil);
        }catch (Exception e){
            e.printStackTrace();
        }
        return isok;
    }

    @Override
    public boolean changeSfzh(Person p, DButil dButil) {
        boolean isok = false;
        try{
            isok = personDao.changeSfzh(p,dButil);
        }catch (Exception e){
            e.printStackTrace();
        }
        return isok;
    }



}
