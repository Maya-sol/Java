class Horse extends Animal {
    Horse(int idNum, double height1, Supervisor supervise) {
        id = idNum;
        height = height1;
        supervisor = supervise;
    }

    @Override
    void makeSound() {
        System.out.println("Neigh");
    }
}