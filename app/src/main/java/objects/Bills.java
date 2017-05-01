package objects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by July on 01/12/2016.
 */

public class Bills implements Serializable {
    private static final long serialVersionUID = -8573736262605632335L;

    private String billName;
    private ArrayList<Double> divisionsList;
    private Double total;
    private Double divideBy;
    private boolean paid;
    private int responsibleIndex;


    public Bills(int responsibleIndex, String billName, Double total, Double[] divisionsList, boolean paid) throws Exception{
        if (divisionsList.length < 1){
            //TODO Verify if this list has the same size of the people list. throw exception otherwise.
            throw new Exception("Exception: Wrong number of elements in this list.");
        }
        this.billName = billName;
        this.total = total;
        this.divisionsList = new ArrayList<>();
        for (int i = 0; i < divisionsList.length; i++){
            this.divisionsList.add(divisionsList[i]);
        }
        this.divideBy = generateDividedBy(this.divisionsList);
        this.paid = paid;
        this.responsibleIndex = responsibleIndex;
    }

    public int getResponsibleIndex() {
        return responsibleIndex;
    }

    public void setResponsibleIndex(int responsibleIndex) {
        this.responsibleIndex = responsibleIndex;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    private Double generateDividedBy(ArrayList<Double> divisionsList){
        Double sum = 0.0;
        for (Double div : divisionsList){
            sum+=div;
        }
        return sum;
    }

    public String getBillName() {
        return billName;
    }


    public void setBillName(String billName) {
        this.billName = billName;
    }


    public ArrayList<Double> getDivisionsList() {
        return divisionsList;
    }


    public void setDivisionsList(ArrayList<Double> divisionsList) {
        this.divisionsList = divisionsList;
    }


    public Double getTotal() {
        return total;
    }


    public void setTotal(Double total) {
        this.total = total;
    }


    public Double getDivideBy() {
        return divideBy;
    }


    public void setDivideBy(Double divideBy) {
        this.divideBy = divideBy;
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
