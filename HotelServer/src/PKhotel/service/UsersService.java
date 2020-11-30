package PKhotel.service;

import PKhotel.bean.User;
import PKhotel.util.DButil;

import java.util.List;

public interface UsersService {
    public List<User> queAll(DButil dButil);
    public int verifyLogin(User u, DButil dButil);
    public boolean changePassword(User u,DButil dButil);
}
