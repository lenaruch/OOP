package family_tree.human;

import java.util.Comparator;

public class HumanComporatorByName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2){
        return o1.getName().compareTo(o2.getName());
    }
}
