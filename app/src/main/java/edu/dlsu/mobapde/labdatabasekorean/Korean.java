package edu.dlsu.mobapde.labdatabasekorean;

/**
 * Created by G301 on 11/7/2017.
 */

public class Korean {

    public static final String EXTRA_ID = "id";
    public static final String EXTRA_TOADD = "add";

    public static final String TABLE_NAME = "korean";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_KPOPGROUP = "kpopgroup";

    private long id;
    private String name;
    private int age;
    private String kpopGroup;

    public Korean(){}

    public Korean(String name, int age, String kpopGroup) {
        this.name = name;
        this.age = age;
        this.kpopGroup = kpopGroup;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getKpopGroup() {
        return kpopGroup;
    }

    public void setKpopGroup(String kpopGroup) {
        this.kpopGroup = kpopGroup;
    }
}
