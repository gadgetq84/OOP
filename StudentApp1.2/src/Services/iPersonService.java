package Services;

import java.util.List;

public interface iPersonService<T> {
    List<T> getAll();
    T create(String firstName, int age);
    int getAgeAverage();

}
