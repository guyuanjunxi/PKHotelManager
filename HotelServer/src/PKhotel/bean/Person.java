package PKhotel.bean;
public class Person{

    private String id;
    private String name;
    private String sfzh;


    public Person(String id,String name,String sfzh){
        this.id = id;
        this.name = name;
        this.sfzh = sfzh;

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

    public void setName(String name){
        this.name = name;
    }
    public void setSfzh(String sfzh){
        this.sfzh = sfzh;
    }



}