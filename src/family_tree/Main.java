package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.family_tree.FamilyTreeIterator;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/family_tree/data/tree.out";
        FileHandler fileHandler = new FileHandler();

        FamilyTree tree = testTree();
        System.out.println(tree);

        fileHandler.save(tree, filePath);

        //FileHandler fileHandler = new FileHandler();
        //FamilyTree tree = (FamilyTree) fileHandler.read(filePath);
        //System.out.println(tree);


    }

    static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        Human valera = new Human("Валера", Gender.Male, LocalDate.of(1977,4,12));
        Human elena = new Human("Елена", Gender.Female, LocalDate.of(1968,8,27));
        tree.add(valera);
        tree.add(elena);
        tree.setWedding(valera.getId(), elena.getId());

        Human egor = new Human("Егор", Gender.Male, LocalDate.of(1994,8,2),valera,elena);
        tree.add(egor);
        Human alena = new Human("Алена", Gender.Female, LocalDate.of(1998,1,10),valera, elena);
        tree.add(alena);

        Human anfisa = new Human("", Gender.Female, LocalDate.of(1945,7,19));
        anfisa.addChild(valera);
        tree.add(anfisa);

        return tree;
    }

}
