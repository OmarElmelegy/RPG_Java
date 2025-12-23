public class Monster implements Destructible {

    private String name;
    private float hp;

    public Monster(String name, float hp) {
        this.name = name;
        this.setHp(hp);

    }

    public void setHp(float hp) {
        if (hp < 0) {
            this.hp = 0;
        } else {
            this.hp = hp;
        }
    }

    public float getHp() {
        return this.hp;
    }

    public String getName() {
        return this.name;
    }

    public void status() {
        System.out.println(
                String.format("%s Has %.1f Health Points", this.getName(), this.getHp()));
    }

    public void takeDamage(float amount) {
        this.setHp(hp - amount);
    }
}
