import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Game {

    private static void saveHero(Hero hero) {
        try {
            FileWriter writer = new FileWriter("Data/save.txt");

            writer.write("Name:" + hero.getName() + "\n");
            writer.write("Class:" + hero.getClass().getSimpleName() + "\n");
            writer.write("Level:" + hero.getLevel() + "\n");
            writer.write("HP:" + hero.getHp() + "\n");
            writer.write("Weapon:" + hero.getWeapon().getName() + "," + hero.getWeapon().getDamage() + ","
                    + hero.getWeapon().getType() + "\n");

            writer.close();
            System.out.println("--> Game Progress Saved to 'save.txt'!");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }

    public static Hero loadHero() {
        Hero loadedHero = null;
        String type = "";
        String name = "";
        float hp = 0;
        int level = 0;
        String weaponName = "";
        int weaponDamage = 0;
        Element weaponElement = Element.PHYSICAL;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("Data/save.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Class:")) {
                    type = line.split(":")[1].trim();
                } else if (line.startsWith("Name:")) {
                    name = line.split(":")[1].trim();
                } else if (line.startsWith("HP:")) {
                    hp = Float.parseFloat(line.split(":")[1].trim());
                } else if (line.startsWith("Level:")) {
                    level = Integer.parseInt(line.split(":")[1].trim());
                } else if (line.startsWith("Weapon:")) {
                    String weapon = line.split(":")[1];
                    weaponName = weapon.split(",")[0].trim();
                    weaponDamage = Integer.parseInt(weapon.split(",")[1].trim());
                    weaponElement = Element.valueOf(weapon.split(",")[2].trim());
                }
            }
            reader.close();

            if (type.equals("Warrior")) {
                loadedHero = new Warrior(name, level, hp, 0);
            } else if (type.equals("Mage")) {
                loadedHero = new Mage(name, level, hp, 0);
            }

            if (loadedHero != null && !weaponName.isEmpty()) {
                loadedHero.equip(new Weapon(weaponName, weaponDamage, weaponElement));
            }

            System.out.println("--> Save loaded successfully!");

        } catch (Exception e) {
            System.out.println("Error loading save file.");
            e.printStackTrace();
            return null;
        }

        return loadedHero;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hero player;

        System.out.println("Do you want to load your save? [y/n]");
        String choice = scanner.nextLine();

        if (choice.equals("y")) {
            player = loadHero();
            if (player == null) {
                System.out.println("Failed to load. Starting new game...");
                player = new Warrior("Conan", 1, 100, 0);
                player.equip(new Weapon("Fire Axe", 40, Element.FIRE));
            }
        } else {
            player = new Warrior("Conan", 1, 100, 0);
            player.equip(new Weapon("Fire Axe", 40, Element.FIRE));
        }

        player.pickupWeapon(new Weapon("Rusty Dagger", 5, Element.PHYSICAL));
        player.pickupWeapon(new Weapon("Ice Spear", 30, Element.ICE));

        // --- ANONYMOUS INNER CLASS ---
        // We create a special "Monolith" that implements Destructible on the fly!
        Destructible monolith = new Destructible() {
            // We define the state right here inside the curly braces
            private float hp = 9999;

            @Override
            public void takeDamage(float amount) {
                System.out.println(">> CLANG! You hit the stone. It vibrates silently.");
                // It takes no damage (Invincible)
            }

            @Override
            public String getName() {
                return "Ancient Monolith";
            }

            @Override
            public float getHp() {
                return hp;
            }

            @Override
            public void status() {
                System.out.println("The Monolith stands eternal.");
            }
        };

        // TEST: Attack the ghost object to prove it works!
        System.out.println("\n--- MYSTERY ENCOUNTER ---");
        try {
            player.attack(monolith); // Polymorphism in action!
        } catch (RPGException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Monster enemy = new Monster("Orc Grunt", 150);
        System.out.println("--- BATTLE START ---");
        System.out.println("A wild " + enemy.getName() + " appears!");

        // Game Loop
        while (player.getHp() > 0 && enemy.getHp() > 0) {

            System.out.println("\n--------------------------------");
            System.out.println(player.getName() + " HP: " + player.getHp());
            System.out.println(enemy.getName() + " HP: " + enemy.getHp());
            System.out.println("Choose Action: [1] Attack  [2] Drink Potion [3] Swap Weapon [4] Sort Inventory");
            System.out.print("> ");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                try {
                    player.attack(enemy);
                } catch (RPGException e) {
                    // e.getMessage() retrieves the string we wrote in the throw statement
                    System.out.println(">> IMPOSSIBLE: " + e.getMessage());
                }

            } else if (input.equals("2")) {
                float healAmount = 20;
                player.setHp(player.getHp() + healAmount);
                System.out.println("You drink a potion and recover " + healAmount + " HP.");

            } else if (input.equals("3")) {
                // 1. Access the inventory (We need to add a getter to Hero for this!)
                Inventory<Weapon> bag = player.getInventory();

                // 2. Show items
                bag.printItems();

                // 3. Ask user to pick
                System.out.print("Select weapon index: ");
                String indexStr = scanner.nextLine();
                int index = Integer.parseInt(indexStr);

                // 4. Equip it
                if (index >= 0 && index < bag.size()) {
                    Weapon newWeapon = bag.get(index);
                    player.equip(newWeapon);
                    System.out.println("You equipped " + newWeapon.getName() + "!");
                } else {
                    System.out.println("Invalid selection!");
                }
            } else if (input.equals("4")) {
                player.getInventory().sortItems();
                player.getInventory().printItems();

            } else {
                System.out.println("You stumbled and missed your turn!");
            }
            // Check if enemy died
            if (enemy.getHp() <= 0) {
                System.out.println("\n*** VICTORY! ***");
                System.out.println("You defeated the " + enemy.getName() + "!");
                saveHero(player);
                scanner.close();
                return;
            }

            // Enemy's turn
            System.out.println("The " + enemy.getName() + " attacks you!");
            player.takeDamage(10);

            // Check if player died
            if (player.getHp() <= 0) {
                System.out.println("\n*** GAME OVER ***");
                System.out.println("You died...");
                scanner.close();
                return;
            }
        }

        scanner.close();
    }
}