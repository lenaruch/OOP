package family_tree.family_tree;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public interface TreeNode<T> {
    void setId(long id);
    long getId();
    T getFather();
    T getMother();
    boolean addChild(T Human);
    boolean addParent(T Human);
    String getName();
    LocalDate getDeathDay();
    LocalDate getBirthDay();
    List<T> getParents();
    List<T> getChildren();
    T getSpouse();
    void setSpouse(T Human);




}
