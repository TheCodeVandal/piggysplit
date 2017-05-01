package objects;

import java.util.ArrayList;

/**
 * Created by July on 01/05/2017.
 */

public class ArrayListPeople{

    //TODO exclude, manage people.
    //TODO get by name, get by id.
    //TODO generate proper Id.

    private int index;
    private ArrayList<People> people;

    public ArrayListPeople(){
        index = 0;
        people = new ArrayList<>();
    }

    public boolean addNewPerson(String name, String lastName)
    {
        //TODO check if person already exist.
        people.add(new People(name, lastName, index));
        index++;
        return true;
    }

    public boolean addNewPerson(String name)
    {
        return addNewPerson(name, "lastname");
    }


}
