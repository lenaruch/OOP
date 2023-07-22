package family_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();
        System.out.println(tree);
    }

    static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        Human valera = new Human("Валера", Gender.Male, LocalDate.of(1977,4,12));
        tree.add(valera);
        Human elena = new Human("Елена", Gender.Female, LocalDate.of(1968,8,27));
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
