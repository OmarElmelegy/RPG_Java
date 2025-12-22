package UseCases.RPG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game_Old {
    public static void main(String[] args) {

        // 1. Create a "Party" (an array that can hold any kind of Hero)
        ArrayList<Hero> party = new ArrayList<Hero>();

        // 2. Add different types of heroes to the same array
        // Notice we are putting a Warrior and a Mage into a 'Hero' container!
        Warrior Conan = new Warrior("Conan", 10, 1000, 50);
        party.add(Conan);
        Mage Merlin = new Mage("Merlin", 10, 500, 200);
        party.add(Merlin);

        // 3. Loop through the party
        System.out.println("--- BATTLE START ---");

        for (Hero currentHero : party) {
            // Polymorphism in action:
            // The CODE says "Hero.status()", but Java runs "Warrior.status()" or
            // "Mage.status()"
            currentHero.status();
            currentHero.attack(Conan);
            System.out.println("------------------");
        }

        Conan.setHp(500);
        System.out.println(String.format("%s has been attacked, he now has %.1f health points!",
                Conan.getName(), Conan.getHp()));

        Healer[] medicalKit = new Healer[2];

        medicalKit[0] = Merlin; // A Mage is a Healer, we can do = (Mage) party.get(1); --> This is called
                                // downcasting
                                // along the inheritence tree
        medicalKit[1] = new Potion(); // A Potion is a Healer

        System.out.println("--- EMERGENCY! CONAN IS HURT ---");
        System.out.println("Conan HP before: " + Conan.getHp());

        // 3. Loop through everything that can heal
        // 3. Loop through everything that can heal
        for (Healer h : medicalKit) {
            h.heal(Conan);
        }

        System.out.println("Conan HP after: " + Conan.getHp());

        Map<String, Integer> inventory = new HashMap<>();

        inventory.put("Gold Coins", 1000);
        inventory.put("Wood", 50);

        System.out.println("Conan buys something with 50 gold!");
        inventory.put("Gold Coins", inventory.get("Gold Coins") - 50);
        System.out.println("The remaining gold is: " + inventory.get("Gold Coins"));

        try {
            inventory.put("Rusty Dagger", inventory.get("Rusty Dagger") - 1);
        } catch (NullPointerException e) {
            System.out.println("You checked your inventory for a Rusty Dagger and you did not find it..");
        }

        System.out.println("There currently is a total of " + Hero.getHeroCount() + " heroes in this world..");

        Conan.attack(Merlin);
        Merlin.attack(Conan);
        Weapon sword = new Weapon("Greatsword", 50, Element.PHYSICAL);
        Weapon fireSword = new Weapon("Fire Sword", 25, Element.FIRE);

        Conan.equip(sword);
        Conan.attack(Merlin); // Output: Conan attacks with Greatsword for 50 PHYSICAL damage!
        Weapon iceWand = new Weapon("Ice Wand", 40, Element.ICE);

        Conan.attack(Merlin);
        Merlin.attack(Conan);

        Conan.equip(sword);
        Merlin.equip(iceWand);
        Merlin.attack(Merlin);

        Merlin.equip(fireSword);
        Merlin.attack(Conan);
    }
}
