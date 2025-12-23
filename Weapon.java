enum Element {

    FIRE,
    ICE,
    PHYSICAL;

}

public class Weapon implements Comparable<Weapon> {

    private String name;
    private int damage;
    private Element type;

    public Weapon(String name, int damage, Element type) {
        this.setName(name);
        this.setDamage(damage);
        this.setType(type);
    }

    public Element getType() {
        return type;
    }

    public void setType(Element type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        // This defines how the object looks when printed
        return this.name + " (" + this.damage + " DMG | " + this.type + ")";
    }

    @Override
    public int compareTo(Weapon other) {
        // We want to sort by DAMAGE.
        // Logic: Return negative if 'this' is smaller, positive if 'this' is larger.

        // Ascending order (10, 20, 50)
        return this.damage - other.damage;

        // If you want Descending (50, 20, 10), swap them:
        // return other.damage - this.damage;
    }
}
