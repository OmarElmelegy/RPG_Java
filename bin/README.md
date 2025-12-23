# RPG Battle System

A complete turn-based RPG battle system demonstrating advanced object-oriented programming concepts in Java.

## 🎮 How to Play

Run `Game.java` to start the game. You'll be prompted to load a saved game or start fresh.

**Controls:**
- `1` - Attack the enemy
- `2` - Drink a potion to restore 20 HP (capped at 100 max HP)

**Features:**
- Turn-based combat system
- Save/Load game progress from `Data/save.txt`
- Weapon system with damage types (FIRE, ICE, PHYSICAL)
- Generic inventory system for weapon storage
- Combat mechanics with critical hits and miss chances
- Custom exception handling for game errors

## 🏗️ Architecture

**Interfaces:**
- `Destructible` - Contract for entities that can take damage and be destroyed
  - Methods: `takeDamage()`, `getHp()`, `getName()`, `status()`
- `Healer` - Contract for entities that can heal heroes
  - Method: `heal(Hero)`
- `Comparable<Weapon>` - Enables weapon sorting by damage

**Abstract Classes:**
- `Hero` - Base class for all playable characters
  - Implements `Destructible`
  - Contains: name, level, HP, weapon, inventory
  - Abstract method: `attack(Destructible)`
  - Subclasses: `Warrior`, `Mage`

**Concrete Classes:**
- `Warrior extends Hero` - Melee fighter with rage mechanic
  - 20% miss chance, 10% critical hit chance (2x damage)
  - Throws `RPGException` for invalid attacks
- `Mage extends Hero implements Healer` - Magic user with mana
  - Can attack enemies and heal allies (+50 HP)
  - Throws `RPGException` for invalid attacks
- `Monster implements Destructible` - Enemy entities
- `Weapon implements Comparable<Weapon>` - Equipment with damage and element
- `Potion implements Healer` - Consumable healing item (+100 HP)
- `Inventory<T>` - Generic container for storing items
  - Type parameter must extend `Comparable<T>`
  - Features: add, get, sort, print items
- `RPGException extends Exception` - Custom checked exception for game errors
- `Game` - Main controller with save/load system and battle loop

**Enums:**
- `Element` - Damage types: FIRE, ICE, PHYSICAL

## 📊 UML Diagram

![Hero Combat System Class Diagram](Data/RPG_System_Class_Diagram.png)

See [`RPG_UML.md`](RPG_UML.md) for detailed class relationships and descriptions.

## 🎯 Key Design Patterns

1. **Inheritance Hierarchy**
   - `Hero` → `Warrior`, `Mage`
   - Enables code reuse and polymorphism

2. **Interface Segregation**
   - `Destructible` - Combat-capable entities
   - `Healer` - Healing-capable entities
   - `Comparable` - Sortable items

3. **Composition over Inheritance**
   - Hero **has-a** Weapon (not is-a)
   - Hero **has-a** Inventory

4. **Polymorphism**
   - Different `attack()` implementations per hero type
   - Multiple `Healer` implementations (Mage, Potion)

5. **Generics**
   - `Inventory<T extends Comparable<T>>` for type-safe collections

6. **Exception Handling**
   - Custom `RPGException` for game logic errors
   - Prevents invalid game states (attacking self, dead enemies, etc.)

## 🚀 Running the Project

```bash
javac Game.java
java Game
```

Or use VS Code's "Run Java" button on `Game.java`.

## 🛠️ Requirements
- Java 11 or higher
- VS Code with Extension Pack for Java (recommended)
- Graphviz (for UML diagram rendering with PlantUML)

## 📝 Learning Objectives

- **Abstract classes and interfaces** - Defining contracts and base behavior
- **Inheritance hierarchies** - Code reuse through class extension
- **Polymorphism** - Different implementations of the same method
- **File I/O** - Saving and loading game state
- **Exception handling** - Custom exceptions for game logic
- **Generics** - Type-safe collections with `Inventory<T>`
- **Game loop implementation** - Turn-based combat system
- **Object composition** - Building complex objects from simpler ones
- **Static members** - Class-level tracking (hero count)

## 📁 Project Structure

```
RPG/
├── Data/
│   └── save.txt              # Game save file
├── Game.java                 # Main game controller
├── Hero.java                 # Abstract hero base class
├── Warrior.java              # Warrior implementation
├── Mage.java                 # Mage implementation
├── Monster.java              # Enemy class
├── Weapon.java               # Weapon class + Element enum
├── Inventory.java            # Generic inventory system
├── Destructible.java         # Damage-taking interface
├── Healer.java               # Healing interface
├── Potion.java               # Healing item
├── RPGException.java         # Custom exception
├── RPG_UML.md               # UML diagram documentation
└── README.md                 # This file
```

## 📄 License
Educational project for learning purposes.
