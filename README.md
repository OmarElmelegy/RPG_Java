# RPG Battle System

A complete turn-based RPG battle system demonstrating advanced object-oriented programming concepts in Java.

## 📂 Project Structure

```
RPG/
├── src/                      # Source code
│   ├── game/                 # Game logic and main controller
│   │   └── Game.java        # Main game loop, save/load system
│   ├── model/                # Entity classes
│   │   ├── Hero.java        # Abstract hero base class
│   │   ├── Warrior.java     # Warrior implementation
│   │   ├── Mage.java        # Mage implementation
│   │   ├── Monster.java     # Enemy class
│   │   ├── Weapon.java      # Weapon class + Element enum
│   │   └── Potion.java      # Healing item
│   └── util/                 # Utilities and interfaces
│       ├── Destructible.java    # Damage-taking interface
│       ├── Healer.java          # Healing interface
│       ├── RPGException.java    # Custom exception
│       └── Inventory.java       # Generic inventory system
├── bin/                      # Compiled .class files (generated)
├── data/                     # Game data
│   └── save.txt             # Game save file
├── docs/                     # Documentation
│   ├── README.md            # Detailed documentation
│   ├── RPG_UML.md          # UML class descriptions
│   └── RPG_System.puml     # PlantUML source
├── resources/                # Images and diagrams
│   └── RPG_System_Class_Diagram.png
└── .vscode/                  # VS Code configuration
```

## 🚀 Quick Start

```bash
# Compile the project
javac -d bin src/**/*.java

# Run the game
java -cp bin game.Game
```

Or use VS Code's "Run Java" button on `src/game/Game.java`.

## 📖 Documentation

See [`docs/README.md`](docs/README.md) for complete documentation including:
- How to play
- Architecture overview
- Design patterns
- Learning objectives
- UML diagrams

## 🛠️ Requirements

- Java 11 or higher
- VS Code with Extension Pack for Java (recommended)
- Graphviz (for UML diagram rendering with PlantUML)

## 📄 License

Educational project for learning purposes.
