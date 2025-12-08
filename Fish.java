class Fish extends Animal {
    Fish(int idNum, double height1, Supervisor supervise) {
        id = idNum;
        height = height1;
        supervisor = supervise;
    }

    @Override
    void makeSound() {
    }
}