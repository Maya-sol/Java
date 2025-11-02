import java.util.*;
import java.io.*;


class Supervisor {
    int id;
    String name;

    Supervisor(int idNum, String fullName) {
        id = idNum;
        name = fullName;
    }
}


abstract class Animal {
    int id;
    double hight;
    Supervisor supervisor;

    abstract void makeSound();
}

class Cat extends Animal {
    Cat(int idNum, double height1, Supervisor supervise) {
        id = idNum;
        hight = height1;
        supervisor = supervise;
    }

    @Override
    void makeSound() {
        System.out.println("Meow");
    }

}

class Dog extends Animal {
    Dog(int idNum, double height1, Supervisor supervise) {
        id = idNum;
        hight = height1;
        supervisor = supervise;
    }

    @Override
    void makeSound() {
        System.out.println("Woof");
    }
}

class Hippo extends Animal {
    Hippo(int idNum, double height1, Supervisor supervise) {
        id = idNum;
        hight = height1;
        supervisor = supervise;
    }

    @Override
    void makeSound() {
        System.out.println("Roar");
    }
}

class Horse extends Animal {
    Horse(int idNum, double height1, Supervisor supervise) {
        id = idNum;
        hight = height1;
        supervisor = supervise;
    }

    @Override
    void makeSound() {
        System.out.println("Neigh");
    }
}

class Fish extends Animal {
    Fish(int idNum, double height1, Supervisor supervise) {
        id = idNum;
        hight = height1;
        supervisor = supervise;
    }

    @Override
    void makeSound() {
    }
}

class Zoo {
    Map<Integer, Animal> animals;
    ArrayList<String> observation;

    Zoo() {
        animals = new HashMap<>();
        observation = new ArrayList<>();
    }

    Zoo(Map<Integer, Animal> existingZoo) {
        animals = existingZoo;
    }

    void Add(Animal animal) {
        if (animals.containsKey(animal.id)) {
            System.out.println("This id is taken!");
            return;
        }
        animals.put(animal.id, animal);
    }

    boolean SearchById(int idNum) {
        if (animals.containsKey(idNum)) {
            return true;
        }
        return false;
    }

    void DeleteById(int idNum) {
        if (animals.containsKey(idNum)) {
            animals.remove(idNum);
        } else {
            System.out.println("No animal with such Id");
        }
    }

    void AssignSupervisor(Supervisor newSuper, int animalId) {
        if (animals.containsKey(animalId)) {
            Animal change = animals.get(animalId);
            change.supervisor = newSuper;
            Observer(newSuper.id);
        } else {
            System.out.println("Animal was not found");
        }
    }

    void GetAllAnimalsWithSupId(int supId) {
        for (Animal i : animals.values()) {
            if (i.supervisor.id == supId) {
                System.out.print(i.id + " ");
            }
        }
        System.out.println();
    }

    void GetAllAnimalsWithSupName(String nameCheck) {
        for (Animal i : animals.values()) {
            if (i.supervisor.name.equals(nameCheck)) {
                System.out.print(i.id + " ");
            }
        }
        System.out.println();
    }

    void GetByHight(double hightCheck) {
        for (Animal i : animals.values()) {
            if (i.hight > hightCheck) {
                System.out.print(i.id + " ");
            }
        }
        System.out.println();
    }

    void GetAnimalsWithSound() {
        for (Animal i : animals.values()) {
            if (!(i instanceof Fish)) {
                System.out.print(i.id + " ");
            }
        }
        System.out.println();
    }

    void FindAnimalsSameType(String type) {
        if (type.equals("Fish")) {
            for (Animal i : animals.values()) {
                if (!(i instanceof Fish)) {
                    System.out.print(i.id + " ");
                }
            }
        } else if (type.equals("Cat")) {
            for (Animal i : animals.values()) {
                if (!(i instanceof Cat)) {
                    System.out.print(i.id + " ");
                }
            }
        } else if (type.equals("Dog")) {
            for (Animal i : animals.values()) {
                if (!(i instanceof Dog)) {
                    System.out.print(i.id + " ");
                }
            }
        } else if (type.equals("Hippo")) {
            for (Animal i : animals.values()) {
                if (!(i instanceof Hippo)) {
                    System.out.print(i.id + " ");
                }
            }
        } else if (type.equals("Horse")) {
            for (Animal i : animals.values()) {
                if (!(i instanceof Horse)) {
                    System.out.print(i.id + " ");
                }
            }
        } else {
            System.out.println("This type doesn't exist");
            return;
        }
        System.out.println();
    }

    void Observer(int id) {
        observation.add("Supervisor " + id + "was changed");
    }

}


public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
    }
}
