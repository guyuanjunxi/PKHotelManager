package PKhotel.service;


import PKhotel.bean.Room;
import PKhotel.util.DButil;

import java.util.List;

public interface RoomService {
    public List<Room> queAll(DButil dButil);
    public boolean changeName(Room p,DButil dButil);
    public boolean changeBednum(Room p,DButil dButil);
    public boolean changeSize(Room p,DButil dButil);
    public boolean changePrice(Room p,DButil dButil);
    public boolean changekongtiao(Room p,DButil dButil);
    public boolean changetv(Room p,DButil dButil);
    public boolean changeweiyu(Room p,DButil dButil);
    public boolean changecfj(Room p,DButil dButil);
    public boolean changedianhua(Room p,DButil dButil);
}
