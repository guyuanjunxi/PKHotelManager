package PKhotel.bean;

public class Employees {
    private String id;
    private String name;
    private String sfzh;
    private String teleno;

    public Employees(String id,String name,String sfzh,String teleno){
        this.id = id;
        this.name = name;
        this.sfzh = sfzh;
        this.teleno = teleno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public String getSfzh(){
        return sfzh;
    }
    public String getTeleno(){
        return teleno;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSfzh(String sfzh){
        this.sfzh = sfzh;
    }
    public void setTeleno(String teleno){
        this.teleno = teleno;
    }
}
