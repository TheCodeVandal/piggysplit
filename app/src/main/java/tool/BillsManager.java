package tool;

import objects.Bills;
import objects.People;
import objects.Results;

import java.util.ArrayList;

/**
 * Created by July on 01/12/2016.
 */

public class BillsManager {

    public static ArrayList<Double> totalToBePaid(ArrayList<Bills> bills, int qttPeople){
        ArrayList<Double> totals = new ArrayList<>();
        for(int i = 0; i < qttPeople; i++){
            totals.add(0.0);
        }
        //TODO All bills have the same amount of divisionList? If yes continue.
        for (int i = 0; i < bills.get(0).getDivisionsList().size(); i++){
            Double sum = 0.0;
            for (Bills bill : bills){
                sum += (bill.getTotal()/bill.getDivideBy())*bill.getDivisionsList().get(i);
            }
            totals.set(i, sum);
        }
        return totals;
    }

    public static ArrayList<Double> amountPaid(ArrayList<Bills> bills, ArrayList<People> people) throws Exception{
        if (!isIndexCorrect(bills, people)){
            throw  new Exception("Wrong index found in the bills list");
        }
        ArrayList<Double> alreadyPaid = new ArrayList<>();
        for (People p : people){
            alreadyPaid.add(0.0);
        }
        for (Bills bill : bills){
            Double sum = alreadyPaid.get(bill.getResponsibleIndex()) + bill.getTotal();
            alreadyPaid.set(bill.getResponsibleIndex(), sum);
        }

        return alreadyPaid;

    }

    public static boolean isIndexCorrect(ArrayList<Bills> bills, ArrayList<People> people){
        for (Bills bill : bills){
            if (!(bill.getResponsibleIndex() < people.size())){
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Double> missingPayment(ArrayList<Double> totalsToPay, ArrayList<Double> alreadyPaid) {
        // TODO Check if both arrays have the same size.
        ArrayList<Double> missPay = new ArrayList<>();
        for (Double i : totalsToPay){
            missPay.add(0.0);
        }
        for (int i = 0; i < totalsToPay.size(); i++){
            missPay.set(i, totalsToPay.get(i) - alreadyPaid.get(i));
        }
        return missPay;
    }

    public static ArrayList<Results> processingBills(ArrayList<People> tenants, ArrayList<Double> missingPay) {
        // TODO It is the simplest algorithm. Needs improvement.

        ArrayList<Results> results = new ArrayList<>();
        while(true){
            // Find the biggest negative.
            int indexNeg = -1;
            Double bigNeg = 0.0;
            for (int i = 0; i < missingPay.size(); i++){
                if (missingPay.get(i) < bigNeg){
                    bigNeg = missingPay.get(i);
                    indexNeg = i;
                }
            }
            // Find the biggest positive.
            int indexPos = -1;
            Double bigPos = 0.0;
            for (int i = 0; i < missingPay.size(); i++){
                if (missingPay.get(i) > bigPos){
                    bigPos = missingPay.get(i);
                    indexPos = i;
                }
            }
            if (indexPos == -1 || indexNeg == -1){
                //TODO Something is need to verify efficiency and check if everything is correct.
                break;
            }

            if (bigPos + bigNeg > 0){
                // Positive is bigger than negative.
                results.add(new Results(tenants.get(indexPos), -1*bigNeg, tenants.get(indexNeg)));

                missingPay.set(indexPos, bigPos + bigNeg);
                missingPay.set(indexNeg, 0.0);

            } else if (bigPos + bigNeg < 0){
                // Negative is bigger.
                results.add(new Results(tenants.get(indexPos), bigPos, tenants.get(indexNeg)));

                missingPay.set(indexPos, 0.0);
                missingPay.set(indexNeg, bigPos + bigNeg);

            } else{
                // Zero!!!
                results.add(new Results(tenants.get(indexPos), bigPos, tenants.get(indexNeg)));

                missingPay.set(indexPos, 0.0);
                missingPay.set(indexNeg, 0.0);
            }
        }

        return results;
    }
}
