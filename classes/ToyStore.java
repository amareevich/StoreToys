package classes;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys = new ArrayList<>();

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateWeight(int id, int weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public Toy selectToy() {
        int totalWeight = toys.stream().mapToInt(Toy::getWeight).sum();
        Random random = new Random();
        int randomNumber = random.nextInt(totalWeight);
        int currentWeight = 0;
        Toy selectedToy = null;

        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (randomNumber < currentWeight) {
                selectedToy = toy;
                break;
            }
        }

        return selectedToy;
    }

    public void giveOutToy() {
        Toy selectedToy = selectToy();
        if (selectedToy != null) {
            System.out.println("Поздравляем!!! Вам выпала игрушка " + selectedToy.getName());
            selectedToy.setQuantity(selectedToy.getQuantity() - 1);
            toys.remove(selectedToy);

            try (FileWriter fileWriter = new FileWriter("winners.txt", true)) {
                fileWriter.write(selectedToy.getName() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Игрушек для раздачи нет");
        }
    }
}

