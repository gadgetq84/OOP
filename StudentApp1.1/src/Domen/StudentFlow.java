package Domen;

import java.util.Iterator;
import java.util.List;

/**
 * @apiNote Класс описывающий поток студентов
 */
public class StudentFlow implements Iterable<StudentGroup> {

    private List<StudentGroup> flow;
    private Integer idFlow;

    /**
     * @apiNote Конструктор класса
     * @param flow
     * @param idFlow
     */
    public StudentFlow(List<StudentGroup> flow, Integer idFlow) {
        this.flow = flow;
        this.idFlow = idFlow;
    }

    public int GetGroupsCount() {
        return flow.size();
    }

    /**
     * @apiNote метод возвращает лист групп в потоке
     * @return
     */
    public List<StudentGroup> getFlow() {
        return flow;
    }

    /**
     * @apiNote назначить потоку лист групп
     * @param flow
     */
    public void setFlow(List<StudentGroup> flow) {
        this.flow = flow;
    }

    /**
     * Возвращаем id потока
     * 
     * @return idFlow
     */
    public Integer getIdFlow() {
        return idFlow;
    }

    /**
     * Устанавливаем id потока
     * 
     * @param idFlow
     */
    public void setIdFlow(Integer idFlow) {
        this.idFlow = idFlow;
    }
/**
 * Вспомогательный метод для ToString
 * @param flow
 * @return String
 */
    public String StrBuild(List<StudentGroup> flow) {
        StringBuilder sb = new StringBuilder();
        for (StudentGroup grp : flow) {
            // sb.append("Группа = " + Integer.toString(grp.getIdGroup())+"\n\r");
             for (Student std : grp) {
            sb.append(std.toString()+"Группа = " + Integer.toString(grp.getIdGroup())+"\n\r");
             }
        }
        return sb.toString();
    }

    /**
     * Переопределяем метод toString в нашем классе
     */
    @Override
    public String toString() {
        return "Поток = " + idFlow + "\n\r"
                + "Кол-во групп = " + this.GetGroupsCount() + "\n\r" +
                StrBuild(flow) + "\n\r";

    }

    /**
     * Переопределяем итератор
     */

    @Override
    public Iterator<StudentGroup> iterator() {
        return new Iterator<StudentGroup>() {

            private int counter;

            @Override
            public boolean hasNext() {

                if (counter < flow.size()) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public StudentGroup next() {
                return flow.get(counter++);
            }

        };
    }

}
