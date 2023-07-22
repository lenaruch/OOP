package family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Human {
    private long id;
    private String name;
    private LocalDate birthDay;
    private LocalDate deathDay;
    private Gender gender;
    private List<Human> parents;
    private List<Human> children;
    private Human spouse;

    // Конструктор со всеми агрументами
    public Human(String name, Gender gender, LocalDate birthDay, LocalDate deathDay,
                 Human father, Human mother) {
        long id = -1;
        this.name = name;
        this.birthDay = birthDay;
        this.deathDay = deathDay;
        this.gender = gender;
        parents = new ArrayList<>();
        if (father != null){
            parents.add(father);
        }
        if (mother != null){
            parents.add(father);
        }
        children = new ArrayList<>();
    }

    // Конструктор с 3 аргументами (Имя, Пол, День Рождения)
    public Human(String name, Gender gender, LocalDate birthDay) {
        this(name, gender, birthDay, null, null, null);
    }

    // Конструктор с 5 аргументами (Имя, Пол, День Рождения, Папа, Мама)
    public Human(String name, Gender gender, LocalDate birthDay, Human father, Human mother) {
        this(name, gender, birthDay, null, father, mother);
    }

}
