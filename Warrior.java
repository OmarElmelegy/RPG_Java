package UseCases.RPG;

import java.util.Random;

public class Warrior extends Hero {

    private float rage;
    private Random rand = new Random();

    public Warrior(String name, int level, float hp, float rage) {

        super(name, level, hp);

        this.rage = rage;
    }

    public float getRage() {
        return rage;
    }

    @Override
    public void status() {
        super.status();
        System.out.println("He is a warrior and has " + this.getRage() + " rage points!");
    }

    @Override
    public void attack(Destructible target) {
        if (this == target) {
            System.out.println("You cannot attack yourself!");
            return;
        }

        int roll = rand.nextInt(100); // Returns 0 to 99

        if (roll < 20) {
            System.out.println(String.format("Conan swung his %s but MISSED!", this.getWeapon().getName()));
        }

        if (roll > 90) {
            int dmg = this.getWeapon().getDamage() * 2;
            target.takeDamage(dmg);

            System.out.println(String.format(
                    "CRITICAL HIT! Conan deals DOUBLE damage! \nThe Mighty %s Swings his %s and inflicts %d %s damage to %s!",
                    this.getName(), this.getWeapon().getName(), dmg,
                    this.getWeapon().getType(), target.getName()));

            target.status();
        }

        else {
            int dmg = this.getWeapon().getDamage();
            target.takeDamage(dmg);

            System.out.println(String.format("The Mighty %s Swings his %s and inflicts %d %s damage to %s!",
                    this.getName(), this.getWeapon().getName(), dmg,
                    this.getWeapon().getType(), target.getName()));

            target.status();
        }
    }
}
