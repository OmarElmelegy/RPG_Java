# RPG Battle System

A complete turn-based RPG battle system demonstrating advanced object-oriented programming concepts in Java.

#### 🎮 How to Play
Run `Game.java` to start a battle between a Warrior and an Orc.

**Controls:**
- `1` - Attack the enemy
- `2` - Drink a potion to restore health

**Features:**
- Turn-based combat system
- Weapon and element system
- Auto-save game progress to `Data/save.txt`

#### 🏗️ Architecture

**Interfaces:**
- `Destructible` - Contract for entities that can take damage
- `Healer` - Contract for entities that can heal heroes

**Classes:**
- `Hero` (abstract) - Base class for all heroes
  - `Warrior` - Melee fighter with rage mechanic
  - `Mage` - Magic user with mana and healing abilities
- `Monster` - Enemy entities
- `Weapon` - Equipment with damage and element types
- `Potion` - Consumable healing item

**Enums:**
- `Element` - Damage types (FIRE, ICE, PHYSICAL)

#### 📊 UML Diagram

![Hero Combat System Class Diagram](Data/Hero%20Combat%20System%20Class-2025-12-22-013733.png)

See `RPG_UML.md` for detailed class relationships and descriptions.

#### Key Design Patterns
- **Inheritance** - Hero subclasses (Warrior, Mage)
- **Interface Implementation** - Destructible, Healer
- **Composition** - Hero has-a Weapon
- **Polymorphism** - Different attack() implementations
- **Static Members** - Hero count tracking

## 🚀 Running the Project

```bash
javac Game.java
java Game
```

Or use VS Code's "Run Java" button on `Game.java`.

## 🛠️ Requirements
- Java 11 or higher
- VS Code with Extension Pack for Java (recommended)

## 📝 Learning Objectives

- Abstract classes and interfaces
- Inheritance hierarchies
- Polymorphism in action
- File I/O for save/load
- Game loop implementation
- Object composition

## 📄 License
Educational project for learning purposes.
