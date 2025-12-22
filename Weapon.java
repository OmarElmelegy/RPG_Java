package UseCases.RPG;

enum Element {

    FIRE,
    ICE,
    PHYSICAL;

}

public class Weapon {

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
}
