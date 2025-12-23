public class Mage extends Hero implements Healer {
    private float mana;

    public Mage(String name, int level, float hp, float mana) {

        super(name, level, hp);

        this.mana = mana;
    }

    public float getMana() {
        return this.mana;
    }

    @Override
    public void status() {
        super.status();
        System.out.println("He is a Mage and has " + this.getMana() + " mana points!");
    }

    @Override
    public void attack(Destructible target) throws RPGException {

        if (this == target) {
            throw new RPGException("You are confused! You cannot attack yourself.");
        }
        if (target.getHp() <= 0) {
            throw new RPGException("Stop! " + target.getName() + " is already dead.");
        }
        if (this.getWeapon() == null) {
            throw new RPGException("You have no weapon equipped!");
        }

        else {
            target.takeDamage(this.getWeapon().getDamage());

            System.out.println(
                    String.format("The Infamous %s Casts %s Barrage using his %s and inflicts %d %s damage to %s!",
                            this.getName(), this.getWeapon().getType(), this.getWeapon().getName(),
                            this.getWeapon().getDamage(),
                            this.getWeapon().getType(), target.getName()));

            target.status();
        }
    }

    @Override
    public void heal(Hero target) {

        float newHp = target.getHp() + 50;
        target.setHp(newHp);

        System.out.println(this.getName() + " casts a healing spell on " + target.getName() + "!");
    }
}
