package model;

import util.Healer;

public class Potion implements Healer {

    @Override
    public void heal(Hero target) {
        target.setHp(target.getHp() + 100);
        System.out.println("The potion restored 100 HP to " + target.getName());
    }
}
