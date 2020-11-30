package PKhotel.service;

import PKhotel.bean.Person;
import PKhotel.bean.User;
import PKhotel.util.DButil;

import java.util.List;

public interface PersonService {
    public List<Person> queAll(DButil dButil);
    public boolean changeName(Person p,DButil dButil);
    public boolean changeSfzh(Person p, DButil dButil);
}
