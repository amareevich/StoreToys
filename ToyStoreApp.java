import classes.*;

public class ToyStoreApp {
    public static void main(String[] args) {
        Toy toy1 = new Toy(1, "Медведь", 5, 25);
        Toy toy2 = new Toy(2, "Кукла", 7, 20);
        Toy toy3 = new Toy(3, "Машинка", 10, 15);
        Toy toy4 = new Toy(4, "Бэтмэн", 9, 21);

        ToyStore toyStore = new ToyStore();
        toyStore.addToy(toy1);
        toyStore.addToy(toy2);
        toyStore.addToy(toy3);
        toyStore.addToy(toy4);

        toyStore.updateWeight(1, 30);

        toyStore.giveOutToy();
    }
}