public abstract class Hero implements Destructible {

    private static int heroCount = 0;

    private String name;
    private int level;
    private float hp;
    private Weapon currentWeapon;


    private Inventory<Weapon> weaponBag;
    

    public Hero(String name, int level, float hp) {
        this.name = name;
        this.setLevel(level);
        this.setHp(hp);
        this.weaponBag = new Inventory<>();
        
        heroCount++;
    }

    public float getHp() {
        return this.hp;
    }

    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public static int getHeroCount() {
        return heroCount;
    }

    public Weapon getWeapon() {
        if (currentWeapon == null) {
            Weapon Fists = new Weapon("Fists", 1, Element.PHYSICAL);
            this.equip(Fists);
        }
        return this.currentWeapon;
    }

    public Inventory<Weapon> getInventory() {
        return this.weaponBag;
    }

    public void pickupWeapon(Weapon w) {
        this.weaponBag.add(w);
    }

    public void setHp(float hp) {
        if (hp < 0) {
            this.hp = 0;
        } else {
            this.hp = hp;
        }
    }

    public void setLevel(int level) {
        if (level < 0) {
            this.level = 0;
        } else {

            this.level = level;
        }
    }

    public void status() {
        System.out.println(
                String.format("%s Is level %d Has %.1f Health Points", this.getName(), this.getLevel(), this.getHp()));
    }

    public void equip(Weapon w) {
        this.currentWeapon = w;
    }

    public void takeDamage(float amount) {
        this.setHp(hp - amount);
    }

    public abstract void attack(Destructible target) throws RPGException;

    

}
