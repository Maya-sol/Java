class Dog extends Animal {
    Dog(int idNum, double height1, Supervisor supervise) {
        id = idNum;
        height = height1;
        supervisor = supervise;
    }

    @Override
    void makeSound() {
        System.out.println("Woof");
    }
}