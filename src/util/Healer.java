package util;

import model.Hero;

public interface Healer {
    // No body! Just the signature.
    // "Anyone who claims to be a Healer MUST know how to heal a Hero."
    void heal(Hero target);
}
