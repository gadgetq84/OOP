package Domen;

import java.util.Iterator;
import java.util.List;

public class StudentGroup implements Iterable<Student>, Comparable<StudentGroup> {
    private List<Student> group;
    private Integer idGroup;

    public StudentGroup(List<Student> group, Integer idGroup) {
        this.group = group;
        this.idGroup = idGroup;
    }

    public int GetStudentCount() {
        return group.size();
    }

    public List<Student> getGroup() {
        return group;
    }

    public void setGroup(List<Student> group) {
        this.group = group;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }
/**
 * Вспомогательный метод для ToString
 * @param group
 * @return
 */
    public String StrBuild(List<Student> group) {
        StringBuilder sb = new StringBuilder();
        for (Student std: group)
        {
            sb.append(std.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    // @Override
    // public String toString() {
    // return "StudentGroup{" +
    // "group=" + group +
    // ", idGroup=" + idGroup +
    // '}';
    // }

    @Override
    public String toString() {
        return "Номер группы = " + this.getIdGroup()+"\n" +
                "Кол-во Студентов = "+ this.GetStudentCount()+"\n"
                 + this.StrBuild(group);
    }

    @Override
    public Iterator<Student> iterator() {
        return new Iterator<Student>() {

            private int counter;

            @Override
            public boolean hasNext() {

                if (counter < group.size()) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public Student next() {
                return group.get(counter++);
            }

        };

    }

    @Override
    public int compareTo(StudentGroup o) {
        if (this.GetStudentCount() > o.GetStudentCount()) {
            return 1;
        } else if (this.GetStudentCount() < o.GetStudentCount()) {
            return -1;
        } else
            return 0;
    }

}
