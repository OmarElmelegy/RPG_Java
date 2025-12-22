# Java Playground

A collection of Java programming exercises and projects for learning and practicing object-oriented programming concepts.

## 📁 Project Structure

### Head First Java (HF_J)
Learning exercises from Head First Java book:

#### Chapter 2 - Object Basics
- `GameLauncher.java` - Game launcher implementation
- `GuessGame.java` - Number guessing game
- `Player.java` - Player class
- `Movie.java` - Movie object example
- `MovieTestDrive.java` - Movie test driver

#### Chapter 5 - Simple DotCom Game
- `SimpleDotCom.java` - Basic DotCom ship class
- `SimpleDotComGame.java` - Single-ship game logic
- `SimpleDotComTestDrive.java` - Test driver
- `GameHelper.java` - User input helper

#### Chapter 6 - Full DotCom Game
- `DotCom.java` - Enhanced DotCom ship with website names
- `DotComBust.java` - **Main game** - Sink three dot-com websites
- `DotComGame.java` - Alternative game implementation
- `GameHelper.java` - User input and grid placement helper

### Use Cases - RPG System
A complete turn-based RPG battle system demonstrating advanced OOP concepts.

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

![Hero Combat System Class Diagram](UseCases/RPG/Data/Hero%20Combat%20System%20Class-2025-12-22-013733.png)

See `RPG_UML.md` for detailed class relationships and descriptions.

#### Key Design Patterns
- **Inheritance** - Hero subclasses (Warrior, Mage)
- **Interface Implementation** - Destructible, Healer
- **Composition** - Hero has-a Weapon
- **Polymorphism** - Different attack() implementations
- **Static Members** - Hero count tracking

## 🚀 Running the Projects

### DotCom Game (Chapter 6)
```bash
cd HF_J/Ch6
javac DotComBust.java
java DotComBust
```

### RPG Game
```bash
cd UseCases/RPG
javac Game.java
java UseCases.RPG.Game
```

Or use VS Code's "Run Java" button on any main class.

## 🛠️ Requirements
- Java 11 or higher
- VS Code with Extension Pack for Java (recommended)

## 📝 Learning Objectives

### Head First Java Chapters
- **Ch2**: Classes, objects, methods, instance variables
- **Ch5**: ArrayLists, loops, user input
- **Ch6**: Multiple objects, collections, enhanced game logic

### RPG Project
- Abstract classes and interfaces
- Inheritance hierarchies
- Polymorphism in action
- File I/O for save/load
- Game loop implementation
- Object composition

## 📄 License
Educational project for learning purposes.
