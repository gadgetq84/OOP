package Domen;

import java.util.Comparator;
/**
 * Компаратор для сравнения групп поп ID
 */
public class GroupIdCompare implements Comparator<StudentGroup> {

    @Override
    public int compare(StudentGroup o1, StudentGroup o2) {
        return Integer.compare(o1.getIdGroup(), o2.getIdGroup());
    }
    
    
}
