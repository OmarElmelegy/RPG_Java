package UseCases.RPG;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; // Import the Scanner

public class Game {

    private static void saveHero(Hero hero) {
        try {
            // "false" means overwrite the file. "true" would append to the end.
            FileWriter writer = new FileWriter("UseCases/RPG/Data/save.txt"); 
            
            // We write the data in a format that is easy to read later
            // Format: Key:Value
            writer.write("Name:" + hero.getName() + "\n");
            writer.write("Level:" + hero.getLevel() + "\n");
            writer.write("HP:" + hero.getHp() + "\n");
            writer.write("Weapon:" + hero.getWeapon().getName() + "\n");
            
            writer.close(); // Closes the stream and saves the file
            System.out.println("--> Game Progress Saved to 'save.txt'!");
            
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace(); // Helpful to see exactly what went wrong
        }
    }

    public static void main(String[] args) {

        // 1. Setup the Arena
        Scanner scanner = new Scanner(System.in);

        Warrior player = new Warrior("Conan", 1, 100, 0);
        // Give the player a weapon so they don't use Fists!
        player.equip(new Weapon("Fire Axe", 40, Element.FIRE));

        Monster enemy = new Monster("Orc Grunt", 150);

        System.out.println("--- BATTLE START ---");
        System.out.println("A wild " + enemy.getName() + " appears!");

        // 2. The Game Loop
        // Run as long as BOTH are alive
        while (player.getHp() > 0 && enemy.getHp() > 0) {

            // --- UI: Show Status ---
            System.out.println("\n--------------------------------");
            System.out.println(player.getName() + " HP: " + player.getHp());
            System.out.println(enemy.getName() + " HP: " + enemy.getHp());
            System.out.println("Choose Action: [1] Attack  [2] Drink Potion");
            System.out.print("> ");

            // --- INPUT: Read Player Choice ---
            String input = scanner.nextLine();

            if (input.equals("1")) {
                // Write the code here...
                player.attack(enemy);

            } else if (input.equals("2")) {
                // For now, just manually add HP: player.setHp(player.getHp() + 20);
                player.setHp(player.getHp() + 20);
                System.out.println("You drink a potion and recover health.");

            } else {
                System.out.println("You stumbled and missed your turn!");
            }

            // --- CHECK: Did enemy die? ---
            if (enemy.getHp() == 0) {
                System.out.println("VICTORY! You defeated the " + enemy.getName());
                saveHero(player);
                break; // Break out of the loop immediately
            }

            // --- ENEMY TURN ---
            System.out.println("The " + enemy.getName() + " attacks you!");
            // enemy doesn't have a weapon, so just manually damage the player:
            player.takeDamage(10);

            // --- CHECK: Did player die? ---
            if (player.getHp() == 0) {
                System.out.println("GAME OVER... You died.");
                saveHero(player);
            }
        }

        // 3. Cleanup
        scanner.close(); // Always close scanners to prevent memory leaks
    }
}