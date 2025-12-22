package UseCases.RPG;

public interface Destructible {

    void takeDamage(float amount);

    String getName();

    float getHp();

    void status();

}
