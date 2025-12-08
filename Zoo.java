import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    void GetByHeight(double heightCheck) {
        for (Animal i : animals.values()) {
            if (i.height > heightCheck) {
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