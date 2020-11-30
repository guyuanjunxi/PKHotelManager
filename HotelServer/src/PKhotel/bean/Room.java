package PKhotel.bean;

public class Room {
    private String id;
    private String name;
    private String bednum;
    private String size;
    private String price;
    private String kongtiao;
    private String tv;
    private String weiyu;
    private String cfj;
    private String dianhua;

    public Room(String id,String name,String bednum,String size,String price,
                String kongtiao,String tv,String weiyu,String cfj,String dianhua){
        this.id = id;
        this.name = name;
        this.bednum = bednum;
        this.size = size;
        this.price = price;
        this.kongtiao = kongtiao;
        this.tv = tv;
        this.weiyu = weiyu;
        this.cfj = cfj;
        this.dianhua = dianhua;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBednum() {
        return bednum;
    }

    public void setBednum(String bednum) {
        this.bednum = bednum;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getKongtiao() {
        return kongtiao;
    }

    public void setKongtiao(String kongtiao) {
        this.kongtiao = kongtiao;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getWeiyu() {
        return weiyu;
    }

    public void setWeiyu(String weiyu) {
        this.weiyu = weiyu;
    }

    public String getCfj() {
        return cfj;
    }

    public void setCfj(String cfj) {
        this.cfj = cfj;
    }

    public String getDianhua() {
        return dianhua;
    }

    public void setDianhua(String dianhua) {
        this.dianhua = dianhua;
    }
}
