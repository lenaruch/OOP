package family_tree;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

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

    // Метод для добавления ребенка
    public boolean addChild(Human child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    // Метод для добавления родителя
    public boolean addParent(Human parent){
        if (!children.contains(parent)){
            children.add(parent);
            return true;
        }
        return false;
    }

    // Метод получения отца
    public Human getFather(){
        for (Human parent: parents){
            if (parent.getGender() == Gender.Male){
                return parent;
            }
        }
        return null;
    }


    // Метод получения матери
    public Human getMother(){
        for (Human parent: parents){
            if (parent.getGender() == Gender.Female){
                return parent;
            }
        }
        return null;
    }

    public int getAge(){
        if (deathDay == null){
            return getPeriod(birthDay, LocalDate.now());
        } else {
            return (getPeriod(birthDay, deathDay));
        }
    }

    // Метод для вычисления возраста
    private int getPeriod(LocalDate birthDay, LocalDate deathDay) {
        Period diff = Period.between(birthDay,deathDay);
        return diff.getYears();
    }

    // Метод получения пола
    public Gender getGender(){return gender;}

    public String getName(){return name;}
    public long getId(){return id;}
    public void setId(long id){this.id = id;}
    public void setSpouse(Human spouse){this.spouse=spouse;}
    public Human getSpouse(){return spouse;}
    public LocalDate getBirthDay(){return birthDay;}
    public LocalDate getDeathDay(){return deathDay;}
    public List<Human> getParents() {return parents;}
    public List<Human> getChildren()  {return children;}
    public void setBirthDay(LocalDate birthDay){this.birthDay=birthDay;}
    public void setDeathDay(LocalDate deathDay){this.deathDay=deathDay;}

    @Override
    public String toString() {
        return getInfo();
    }

    private String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id:");
        sb.append(id);
        sb.append(", имя:");
        sb.append(name);
        sb.append(", пол:");
        sb.append(gender);
        sb.append(", возраст:");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    private String getSpouseInfo() {
        String res = "супруг(а): ";
        if (spouse == null){
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    private String getFatherInfo() {
        String res = "отец: ";
        Human father = getFather();
        if (father != null){
            res += father.getName();
        } else {
            res += "неизвестно";
        }
        return res;
    }

    private String getMotherInfo() {
        String res = "мать: ";
        Human mother = getMother();
        if (mother != null){
            res += mother.getName();
        } else {
            res += "неизвестно";
        }
        return res;
    }

    private String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутсвуют");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}
