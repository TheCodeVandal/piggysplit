package objects;

import java.io.Serializable;

/**
 * Created by July on 01/12/2016.
 */

public class People implements Serializable{
    private static final long serialVersionUID = -3159503622776473874L;

    private String name;
    private String lastName;
    private int index;

    public People(String name, String lastName, int index){
        this.name = name;
        this.lastName = lastName;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIndex() {
        return index;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
