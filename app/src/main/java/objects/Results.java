package objects;

import java.io.Serializable;

/**
 * Created by July on 01/12/2016.
 */

public class Results implements Serializable{

    private static final long serialVersionUID = -3159503699776473874L;

    private People pays;
    private Double value;
    private People receive;

    public Results(People pays, Double value, People receive){
        this.pays = pays;
        this.value = value;
        this.receive = receive;
    }


    public People getPays() {
        return pays;
    }
    public void setPays(People pays) {
        this.pays = pays;
    }
    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    public People getReceive() {
        return receive;
    }
    public void setReceive(People receive) {
        this.receive = receive;
    }
}
