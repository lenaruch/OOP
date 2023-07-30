package family_tree.family_tree;

import family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<E extends TreeNode> implements Iterator<E> {
    private int index;
    private List<E> list;
    public FamilyTreeIterator(List<E> humanList) {
        this.list = humanList;
    }

    @Override
    public boolean hasNext(){
        return list.size()>index;
    }

    @Override
    public E next() {
        return list.get(index++);
    }

}
