package storage;

import controller.EmployeeManager;
import model.Employee;

import java.util.Comparator;

public class MyComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getName().compareTo(o2.getName())>0){
            return -1;
        }else
            if (o1.getName().compareToIgnoreCase(o2.getName())<0){
                return 1;
            }else {
                if (o1.getAge().compareTo(o2.getAge())>0){
                    return -1;
                }else
                    if (o1.getAge().compareTo(o2.getAge())<0){
                        return 1;
                    }else {
                        return 0;
                    }

            }
    }
}

