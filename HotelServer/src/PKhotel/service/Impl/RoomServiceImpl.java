package PKhotel.service.Impl;


import PKhotel.bean.Person;
import PKhotel.bean.Room;
import PKhotel.dao.RoomDao;
import PKhotel.service.RoomService;
import PKhotel.util.DButil;

import java.util.List;

public class RoomServiceImpl implements RoomService {

    RoomDao roomDao = new RoomDao();

    @Override
    public List<Room> queAll(DButil dButil) {
        List<Room> roomList = null;
        try{
            roomList = roomDao.queAll(dButil);
        }catch (Exception e){
            e.printStackTrace();
        }
        return roomList;
    }

    @Override
    public boolean changeName(Room p, DButil dButil) {
        boolean isok = false;
        try{
            isok = roomDao.changeName(p,dButil);
        }catch (Exception e){
            e.printStackTrace();
        }
        return isok;
    }

    @Override
    public boolean changeBednum(Room p, DButil dButil) {
        boolean isok = false;
        try{
            isok = roomDao.changeBednum(p,dButil);
        }catch (Exception e){
            e.printStackTrace();
        }
        return isok;
    }

    @Override
    public boolean changeSize(Room p, DButil dButil) {
        boolean isok = false;
        try{
            isok = roomDao.changeSize(p,dButil);
        }catch (Exception e){
            e.printStackTrace();
        }
        return isok;
    }

    @Override
    public boolean changePrice(Room p, DButil dButil) {
        boolean isok = false;
        try{
            isok = roomDao.changePrice(p,dButil);
        }catch (Exception e){
            e.printStackTrace();
        }
        return isok;
    }

    @Override
    public boolean changekongtiao(Room p, DButil dButil) {
        boolean isok = false;
        try{
            isok = roomDao.changekongtiao(p,dButil);
        }catch (Exception e){
            e.printStackTrace();
        }
        return isok;
    }

    @Override
    public boolean changetv(Room p, DButil dButil) {
        boolean isok = false;
        try{
            isok = roomDao.changetv(p,dButil);
        }catch (Exception e){
            e.printStackTrace();
        }
        return isok;
    }

    @Override
    public boolean changeweiyu(Room p, DButil dButil) {
        boolean isok = false;
        try{
            isok = roomDao.changeweiyu(p,dButil);
        }catch (Exception e){
            e.printStackTrace();
        }
        return isok;
    }

    @Override
    public boolean changecfj(Room p, DButil dButil) {
        boolean isok = false;
        try{
            isok = roomDao.changecfj(p,dButil);
        }catch (Exception e){
            e.printStackTrace();
        }
        return isok;
    }

    @Override
    public boolean changedianhua(Room p, DButil dButil) {
        boolean isok = false;
        try{
            isok = roomDao.changedianhua(p,dButil);
        }catch (Exception e){
            e.printStackTrace();
        }
        return isok;
    }
}
