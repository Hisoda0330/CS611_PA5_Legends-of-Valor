Guide Readme

Required sections: Header, Files, Program Advantage/Notes, How to compile and run, I/O Example

# CS611-Assignment 5
## Legend of Valor
---------------------------------------------------------------------------

Member 1:
- Name: Jinpeng Huang
- Email: jinpeng@bu.edu
- Student ID: U19568777

Member 2:
- Name: Zishuo Liu
- Email: zsliu@bu.edu
- Student ID: U22679932

## Files
---------------------------------------------------------------------------

1. Legends_Monsters_and_Heroes folder: Use of the stats files that was provided in blackboard. 
But with a slight twist of the attack and defense of the monsters for easier start and debug.

**src/:**
1. Game.java: The interface to start the games

**src/controller/command:**
1. AttackCommand.java:Class to represent the attack function. Presses "k"

2. CastSpellCommand.java:Class represents the hero to cast spell.When the user presses the "C".

3. ChangeArmorCommand:The class for hero to equip the armor.Presses "o"

4. ChangeWeaponCommand: Class for heroes to equip weapon.Presses "e"

5. HelpCommand: The introduction to the game.When user presses the "h".

6. InfoCommand: The class to show the information:when pressed the "i", SHOW the information of heroes and monsters.

7. KeyboardCommand: The interface for all keyboard commands. The superclass of another keyboard command.  The command is Not case-sensitive

8. MarketCommand:The class to represent the market, market only set in the Nexus place. Presses "m"

9. MonsterAttackCommand:Attack class for the monsters.

10. MonsterMoveCommand: The Move command for monster.

11. MoveCommand: The Heroes' Move command .Control left, right, forward, back, through  a, d, w, s

12. QuitCommand:The Quit command.When user presses "Q".

13. RecallCommand:The class for hero came back to the Nexus. User need to press "r".

14. TeleportCommand:The Move command. Transfer one lane to another lane.When the player presses "t".

15. UsePotionCommand:The class for heroes to use the potion.When the user presses the "U".

**src/controller:**

1. Controller.java: Implement main game controller, manages game world, hero creation, movement controls, and commands of game. Also plays music and observe message for display.

2. Input.java: Handles user input, prompts user to enter correct type of input, such as integer or character.

3. MessageObserver.java: Defines an interface for observing messages, respond to messages for display notifications or logs.

4. MusicPlayer.java: Plays background music using audio file music.wav.

5. Color.java:  Add the necessary bold color to the character display in the screen.

6. ValorController: The controller for play the ValorController 

7. IController: The interface for controller.


**src/model:**

1. Constants.java: Stores constant stats for the game, such as exp increase percent.

2. Dice.java: Provide methods for handling random events, simulate probability.

3. FileLoader.java: Contains a method to load data from a file to read game data. Loading entities, heros, items, spells, etc.

4. World.java: Represents the game world, modeled as a 8x8 grid with different types of space(inaccessible, market, and common). It initializes the world layout.

5. Coordinate: Represents a coordinate of map.

**src/model/hero/item:**

1. Item.java: Defines an abstract base class for items in game. Each item has a name, price, and level.

2. ItemFactory.java: Declares an ItemFactory interface for creating specific item instances, providing a way to instantiate different item types consistently.

**src/model/hero/item/armor:**

1. Armor.java: Defines the armor class, extends Item and implements DefenseAble. Represents how much damage armor reduce.

2. ArmorFactory.java: Implements the ItemFactory interface and provides a factory for creating Armor items. Reads Armory.txt using FileLoader, storing in list of Armor objects.

3. DefenseAble.java: Interface represent item that provide defensive capabilities, like armor.

**src/model/hero/item/potion:**

1. EnhanceAble.java: Interface intended for potions that defines how a potion enhances a hero's attribute.

2. Potion.java: Defines the Potion class, exstends Item and implements EnhanceAble. Potions affect specific hero attributes like health, strength, dexterity, and agility.

3. PotionFactory.java: Implements ItemFactory to create Potion objects. Reads potion data from Potion.txt using FileLoader, storing detail on potions and their attribute effects.

**src/model/hero/item/spell:**

1. FireSpell.java: Extends Spell and represents a fire-based spell, magicAttack method reduces monster's defense.

2. IceSpell.java:Extends Spell and represents a ice-based spell, magicAttack method reduces monster's attack damage.

3. LightningSpell.java:Extends Spell and represents a lightning-based spell, magicAttack method reduces monster's dodge ability.

4. MagicAttackAble.java: An interface with methods that defines behavior for items or abilities that perform magic attacks.

5. Spell.java: An abstract class representing a generic spell, provides attributes for damage and cost, methods for applying magic damage to monster and calculate dmage from hero based on dexterity.

6. SpellFactory.java: Implements ItemFactory to create Spell objects. It loads spells from IceSpell.txt, FireSpells.txt, LightningSpells.txt, alternates loading spell from each list.

**src/model/hero/item/weapon:**

1. AttackAble.java: An interface that returns the damage value of an attack-capable item, such as weapon.

2. Weapon.java: Represents a weapon item, extends Item and implements Attackable, with attributes for damage and hands. Includes toString() to display weapon details and implement damage.

3. WeaponFactory.java: Implements ItemFactory to create Weapon instances. Loads weapon from Weaponry.txt using FileLoader and store in a list.

**src/model/market:**

1. Market.java: Represents a market that holds a list of item, provide methods to add, retrieve, and remove items, and display.

2. MarketFactory.java: Defines an interface with a createMarket() method. Generate markets with specific inventories.

3. RandomMarketFactory.java: Implements MarketFacotry to create markets with random items. Generates a market fills with 10 items randomly from WeaponFactory, ArmorFacotry, PotionFactory, and SpellFactory.

**src/model/space:**

1. CommonSpaceActivity.java: Defines the behavior in a common space where hero may encounter monsters and engage in battles. If battle occurs, it creates a monster group and manages rounds of combat, and rewards in exp and gold if win.
   The class include methods for battle actions, such as hero attacks, spell casting, using potions, and equipping items.

2. InaccessibleSpaceActivity: Represents an inaccessible space where heroes cannot enter. When attempted, system prompts a message indicating entry not allowed.

3. MarketSpaceActivity: Represents a market space where heroes can buy or sell items.  The marketMenu allows each hero to choose actions and verifies inventory levels, hero levels, and gold availability before transactions.

4. Space.java: Represents a generic space on the game board with attributes for its row, col, type, and an associated SpaceActivity.

5. SpaceActivity.java: An interface for space activities that takes a hero group and triggers actions when they enter a specific space.

**src/model/user:**

1. User.java: A base class representing users, such as heroes or monsters, with attributes like name, level, and hp. Includes methods for taking damage, healing, leveling up, and managing message notifications for actions, such as receiving damage or leveling up.

2. UserFactory.java: An interface defining a factory for creating User instances. The createUser() method returns a new user, supporting the factory method pattern.

3. UserGroup.java: A generic container for managing a group of User instances (ex. heroes or monsters). It iterates to create hero group and check if user are defeated, and retrieve non-defeated heros for battle.

**src/model/user/hero:**

1. Hero.java: Extends User to represent a hero with additional attributes(exp,mp,gold,strength,dex.,agility). Also controls the inventory and equipped items. Also handles leveling up, using potion, equipping items, handling battle prep and outcomes. Hero regain
   HP and MP each battle, level up based on exp, and use different equipment to enhance attack and defense.

2. HeroFactory.java: Implements UserFactory to create Hero instances by reading data files from Warriors.txt, Sorcerers.txt, Paladins.txt and store in a list of heroes. Use createUser() randomly selects and removes a hero from the list.

3. HeroGroup.java: Extends UserGroup to manage a group of heroes, with additional attributes for the current Space and atMarket status.

4. HeroIncreaseStrategy.java: An interface defines strategy for increasing hero skills when it levels up. The method increaseSkill(Hero hero) is implemented in specific strategy classes for different hero types.

5. Inventory.java: It manages a hero's inventory with item object, such as weapons, armor, potions, and spells. Also allow add, remove, and displaying items and retrieving the details of item.

6. Paladin.java: Represent Paladin hero types and inherit from Hero. Each is initialized with its respective skill increase strategy.

7. PaladinSkillIncreaseStrategy.java: Implement HeroIncreaseStrategy for Paladin hero type. Defines Paladin’s attributes (strength, agility, dexterity) increased when level up, favoring particular attributes based on Paladin hero type.

8. Sorcerer.java: Represent Sorcerer hero types and inherit from Hero. Each is initialized with its respective skill increase strategy.

9. SorcercerSkillIncreaseStrategy.java: Implement HeroIncreaseStrategy for Paladin hero type. Defines Paladin’s attributes (strength, agility, dexterity) increased when level up, favoring particular attributes based on Sorcerer hero type.

10. Warrior.java: Represent Warrior hero types and inherit from Hero. Each is initialized with its respective skill increase strategy.

11. WarriorSkillIncreaseStrategy.java: Implement HeroIncreaseStrategy for Paladin hero type. Defines Paladin’s attributes (strength, agility, dexterity) increased when level up, favoring particular attributes based on Warrior hero type.

**src/model/user/monster:**

1. Dragon.java: It represents Dragon type monsters. It inherits from Monster class and passes its stats(name,level,damage,defense,dodge) to the superclass.

2. Exoskeleton.java: It represents Exoskeleton type monsters. It inherits from Monster class and passes its stats(name,level,damage,defense,dodge) to the superclass.

3. Monster.java: Represents a generic monster with stats for damage, defense, and dodge. It has methods to decrease each attribute by a certain percentage, used when monsters are affected by different types of spells.

4. MonsterFactory.java: Implements UserFactory to create Monster instances. It reads monster data from files such(Dragons.txt, Exoskeletons.txt, Spirits.txt) and filters them based on a specified level.  Also returns monster for appropriate level accroding to heros.

5. MonsterGroup.java: Extends UserGroup to manage a group of monsters, specifically formatting the monster group’s details for display.

6. Spirit.java: It represents Spirit type monsters. It inherits from Monster class and passes its stats(name,level,damage,defense,dodge) to the superclass.

## Program Advantages/Notes
---------------------------------------------------------------------------

The program support two games: 
1.Monsters and Heroes 
2.Legends of Valor

In the second game, the maps need to show only when player pressed I, to show the map.  
**Game INFO**
- '*' is the location of hero's party
- '$' is the location of shop
- '#' is an unaccessible area
- '.' is common area where possibly encounter monster

**HOW TO MOVE:**
- W/w: move up
- A/a: move left
- S/s: move down
- D/d: move right
- Q/q: quit game
- I/i: show information
- M/m: enter market

**Enhance User Experience:**

1. Contains dungeon music to match the theme of the game.
2. Adds background story of the game and summarize the goal of the game.
3. Provides simple guideline of how to play the game.
4. Provides easy and simple controls for the game, allowing user to get start with the game easier.
5. Validates each user input, preventing the game to crash when player enter wrong input, and prevent it to crash when don't play by the rule. such as going out of the board, or inside the restricted area.
6. The user can select two games at the beginning. 

**Good OO Design:**

1. Classes like Hero, Monster, Item, Space, and Inventory have their distinct roles. Separates the file allows to locate, debug, and update without affecting unrelated parts
2. Each class encapsulates specific attributes and behaviors, so it allows each class to focus on its responsibility and easier management.
3. Class Hero, Monster, and Item uses inheritance with subclasses(Warrior, Sorcercer, Dragon) inheriting common behaviors and traits.
4. Use polymorphism to allow the use of interface and abstract classes.(Item, SpaceActivity, UserFactory, etc..) to define behaviors. Allows flexible interaction and behaviors.
5. Use of design pattern,
    - Factory Pattern: (HeroFactory, MonsterFactory, ItemFactory) create their own object without specifying exact class type. With the object creation, it is easy to add new hero type or item without modifying the current code.
    - Strategy Pattern: (HeroIncreaseStrategy, WarriorIncreaseStrategy, SorcercerSkillIncreaseStrategy) allow vary level up behaviors based on hero type. It is flexible for future behavior change without modifying hero class itself.
    - Observer Pattern: (MessageObserver interface and notifyMessage method) helps object to receive message about the game event, can be updated or expand mutiple observers in the future.
6. The naming of each file represents specific aspect of the game, making it clear and easy to locate within the code.
7.  The program is easy to extend with the use of OOD design principles and separation of files within folders help keep methods concise and classes focused.
8. THe map use "I" to display, to save the space. 

## How to compile and run
---------------------------------------------------------------------------

1. Navigate to the directory CS611_PA5_Legends-of-Valor and then enter into "src" OR (cd src)
2. Run in src dir:
    1. javac *.java
    2. java Game
3. Then the game will start 

## Input/Output Example
---------------------------------------------------------------------------
```

SELECT THE GAME TO PLAY:
1. Legends: Monsters and Heroes
2. Legends of Valor
0. Quit

Please select: 1

Welcome to game "Monsters and Heroes":
In a mystery dungeon where is full of darkness reigns, and monstrous creaturesâ??dragons, armored exoskeletons, and elusive spiritsâ??terrorize.
A legendary team of heroes sets forth from all around the league to break the ancient curse, each armed with powers: the Warrior, Sorcerer, and
the Paladin comes together with incredible powers.

The heroes brave treacherous zones, battling monsters at every turn. Along the way, they find hidden markets to buy potions, weapons, spells, and armor essentialfor survival. Each 
different monster in the evil dungeon tests their skills uniquelyâ??dragons breathe fire, exoskeletons have near-unbreakable armor, and spirits dodgeand disappear, requiring both strategy and courage.

With each victory, the heroes grow stronger, preparing for the ultimate confrontation with the dark force behind the evil curse in the dungeon.
Together, they strive to defeat it and restore peace to the land.


GAME INFO:
* is the location of hero's party
$ is the location of shop
# is not accessible
. is common area where possibly encounter monster

HOW TO MOVE:
W/w: move up
A/a: move left
S/s: move down
D/d: move right
Q/q: quit game
I/i: show information
M/m: enter market

Enter the size of hero party: 3
---------------------------------
| #*| $ | # | # | . | $ | . | $ |
---------------------------------
| $ | . | # | . | . | $ | $ | . |
---------------------------------
| # | # | . | . | . | $ | # | . |
---------------------------------
| . | . | . | . | $ | $ | . | . |
---------------------------------
| # | $ | . | . | $ | . | . | . |
---------------------------------
| # | . | . | $ | $ | # | $ | $ |
---------------------------------
| $ | . | . | $ | . | # | $ | . |
---------------------------------
| . | . | # | . | . | . | . | $ |
---------------------------------

enter W/A/S/D/Q/I: Q

Bye!

Another game start: 

SELECT THE GAME TO PLAY:
1. Legends: Monsters and Heroes
2. Legends of Valor
0. Quit

Please select: 2
Select difficulity: 
1. Easy
2. Medium
3. Hard
Please select: 1

Welcome to game "Legends of Valor":

In a land torn by war, monsters rise from their Nexus, threatening to overrun the world. From the Heroes' Nexus,
a brave team of three Warrior, Sorcerer, and Paladin sets out to stop the invasion and bring peace to the land.

The heroes must navigate through three perilous lanes, each filled with monsters, obstacles, and special terrain that boosts
their abilities. Bushes make heroes quicker, Caves make them harder to hit, and Koulou makes them stronger.
Monsters attack relentlessly, moving closer to the Heroes' Nexus with every turn. The heroes must fight back using their weapons,
spells, and teamwork. Along the way, they can buy potions, weapons, and gear to prepare for the battles ahead.

The goal is simple: reach the Monsters' Nexus before the monsters reach yours. Only the strongest and smartest team will survive.
Are you ready for the adventure?

HOW TO PLAY:

MOVEMENT:
W/w: move up
A/a: move left
S/s: move down
D/d: move right
M/m: enter market
I/i: show hero/monster info

ATTACK/FIGHT:
K/k: attack monster
C/c: cast spell
U/u: use potion

EQUIPE:
E/e: equip weapon
O/o: equip armor

TP/RECALL:
T/t: teleport
R/r: recall

GAME INFO:
Q/q: quit game
H/h: help

N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |    M1|   | X X X |   |       |   |    M2|   | X X X |   |       |   |    M3|
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

P - P - P   K - K - K   I - I - I   P - P - P   K - K - K   I - I - I   P - P - P   B - B - B
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   K - K - K   I - I - I   P - P - P   K - K - K   I - I - I   P - P - P   B - B - B

P - P - P   P - P - P   I - I - I   P - P - P   B - B - B   I - I - I   P - P - P   B - B - B
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   P - P - P   I - I - I   P - P - P   B - B - B   I - I - I   P - P - P   B - B - B

B - B - B   B - B - B   I - I - I   K - K - K   C - C - C   I - I - I   P - P - P   P - P - P
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
B - B - B   B - B - B   I - I - I   K - K - K   C - C - C   I - I - I   P - P - P   P - P - P

B - B - B   C - C - C   I - I - I   B - B - B   P - P - P   I - I - I   O - O - O   C - C - C
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
B - B - B   C - C - C   I - I - I   B - B - B   P - P - P   I - I - I   O - O - O   C - C - C

O - O - O   K - K - K   I - I - I   C - C - C   K - K - K   I - I - I   P - P - P   K - K - K
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
O - O - O   K - K - K   I - I - I   C - C - C   K - K - K   I - I - I   P - P - P   K - K - K

C - C - C   C - C - C   I - I - I   C - C - C   K - K - K   I - I - I   P - P - P   O - O - O
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
C - C - C   C - C - C   I - I - I   C - C - C   K - K - K   I - I - I   P - P - P   O - O - O

N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
| H1    |   |       |   | X X X |   | H2    |   |       |   | X X X |   | H3    |   |       |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

Heros:
Hero H1(Reverie_Ashels)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           100         900         800         700         400         7/10        2500
No items in Inventory.
Hero H2(Skye_Soar)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           100         1000        700         400         500         5/10        2500
No items in Inventory.
Hero H3(Reverie_Ashels)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           100         900         800         700         400         7/10        2500
No items in Inventory.
Monsters:
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           100         10          0           10%
Monster M2(Casper)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Monster M3(Blinky)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H1(Reverie_Ashels) left nexus space.

Hero H1(Reverie_Ashels) enter cave space.
Hero H1(Reverie_Ashels) increased 40 agility.

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H2(Skye_Soar) left nexus space.

Hero H2(Skye_Soar) enter cave space.
Hero H2(Skye_Soar) increased 50 agility.

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H3(Reverie_Ashels) left nexus space.

Hero H3(Reverie_Ashels) enter plain space.
Monster M1 move down.
Monster M2 move down.
Monster M3 move down.

Hero H1(Reverie_Ashels) regain 10 HP and 90 MP
Hero H2(Skye_Soar) regain 10 HP and 100 MP
Hero H3(Reverie_Ashels) regain 10 HP and 90 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: w

Hero removed an obstacle.

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H2(Skye_Soar) left cave space.
Hero H2(Skye_Soar) decreased 55 agility.

Hero H2(Skye_Soar) enter cave space.
Hero H2(Skye_Soar) increased 49 agility.

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H3(Reverie_Ashels) left plain space.

Hero H3(Reverie_Ashels) enter plain space.
Monster M1 move down.
Monster M2 move down.
Monster M3 move down.

Hero H1(Reverie_Ashels) regain 11 HP and 99 MP
Hero H2(Skye_Soar) regain 11 HP and 110 MP
Hero H3(Reverie_Ashels) regain 11 HP and 99 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: I
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

P - P - P   K - K - K   I - I - I   P - P - P   K - K - K   I - I - I   P - P - P   B - B - B
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   K - K - K   I - I - I   P - P - P   K - K - K   I - I - I   P - P - P   B - B - B

P - P - P   P - P - P   I - I - I   P - P - P   B - B - B   I - I - I   P - P - P   B - B - B
|       |   |    M1|   | X X X |   |       |   |    M2|   | X X X |   |       |   |    M3|
P - P - P   P - P - P   I - I - I   P - P - P   B - B - B   I - I - I   P - P - P   B - B - B

B - B - B   B - B - B   I - I - I   K - K - K   C - C - C   I - I - I   P - P - P   P - P - P
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
B - B - B   B - B - B   I - I - I   K - K - K   C - C - C   I - I - I   P - P - P   P - P - P

B - B - B   C - C - C   I - I - I   B - B - B   P - P - P   I - I - I   O - O - O   C - C - C
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
B - B - B   C - C - C   I - I - I   B - B - B   P - P - P   I - I - I   O - O - O   C - C - C

P - P - P   K - K - K   I - I - I   C - C - C   K - K - K   I - I - I   P - P - P   K - K - K
|       |   |       |   | X X X |   | H2    |   |       |   | X X X |   | H3    |   |       |
P - P - P   K - K - K   I - I - I   C - C - C   K - K - K   I - I - I   P - P - P   K - K - K

C - C - C   C - C - C   I - I - I   C - C - C   K - K - K   I - I - I   P - P - P   O - O - O
| H1    |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
C - C - C   C - C - C   I - I - I   C - C - C   K - K - K   I - I - I   P - P - P   O - O - O

N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

Heros:
Hero H1(Reverie_Ashels)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           121         1089        800         700         440         7/10        2500
No items in Inventory.
Hero H2(Skye_Soar)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           121         1210        700         400         544         5/10        2500
No items in Inventory.
Hero H3(Reverie_Ashels)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           121         1089        800         700         400         7/10        2500
No items in Inventory.
Monsters:
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           100         10          0           10%
Monster M2(Casper)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Monster M3(Blinky)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%

H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: T
1. Hero H2(Skye_Soar)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           121         1210        700         400         544         5/10        2500
No items in Inventory.
2. Hero H3(Reverie_Ashels)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           121         1089        800         700         400         7/10        2500
No items in Inventory.
0. Cancel
Your choice: 1

Hero H1(Reverie_Ashels) left cave space.
Hero H1(Reverie_Ashels) decreased 44 agility.
Hero H1(Reverie_Ashels) teleport to another nexus.

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H2(Skye_Soar) left cave space.
Hero H2(Skye_Soar) decreased 54 agility.

Hero H2(Skye_Soar) enter bush space.
Hero H2(Skye_Soar) increased 40 dexterity.

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero removed an obstacle.
Monster M1 move down.
Monster M2 move down.
Monster M3 move down.

Hero H1(Reverie_Ashels) regain 12 HP and 108 MP
Hero H2(Skye_Soar) regain 12 HP and 121 MP
Hero H3(Reverie_Ashels) regain 12 HP and 108 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H1(Reverie_Ashels) left koulou space.
Hero H1(Reverie_Ashels) decreased 80 strength.

Hero H1(Reverie_Ashels) enter plain space.

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H2(Skye_Soar) left bush space.
Hero H2(Skye_Soar) decreased 44 dexterity.

Hero H2(Skye_Soar) enter koulou space.
Hero H2(Skye_Soar) increased 70 strength.

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H3(Reverie_Ashels) left plain space.

Hero H3(Reverie_Ashels) enter plain space.
Monster M1 move down.

Monster M2(Casper)  vs  Hero H2(Skye_Soar)
Monster M2(Casper)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Hero H2(Skye_Soar)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           133         1331        770         396         490         5/10        2500
No items in Inventory.
Monster M2(Casper)'s attack damage is 10
Hero H2(Skye_Soar)'s defense is 0
Monster M2(Casper) attacked Hero H2(Skye_Soar) for 10 damage!

Monster M3(Blinky)  vs  Hero H3(Reverie_Ashels)
Monster M3(Blinky)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Hero H3(Reverie_Ashels)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           133         1197        800         700         400         7/10        2500
No items in Inventory.
Monster M3(Blinky)'s attack damage is 10
Hero H3(Reverie_Ashels)'s defense is 0
Monster M3(Blinky) attacked Hero H3(Reverie_Ashels) for 10 damage!

Hero H1(Reverie_Ashels) regain 13 HP and 119 MP
Hero H2(Skye_Soar) regain 12 HP and 133 MP
Hero H3(Reverie_Ashels) regain 12 HP and 119 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H1(Reverie_Ashels) left plain space.

Hero H1(Reverie_Ashels) enter cave space.
Hero H1(Reverie_Ashels) increased 39 agility.

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: I
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

P - P - P   K - K - K   I - I - I   P - P - P   K - K - K   I - I - I   P - P - P   B - B - B
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   K - K - K   I - I - I   P - P - P   K - K - K   I - I - I   P - P - P   B - B - B

P - P - P   P - P - P   I - I - I   P - P - P   B - B - B   I - I - I   P - P - P   B - B - B
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   P - P - P   I - I - I   P - P - P   B - B - B   I - I - I   P - P - P   B - B - B

B - B - B   B - B - B   I - I - I   K - K - K   C - C - C   I - I - I   P - P - P   P - P - P
|       |   |       |   | X X X |   | H2    |   | H1 M2|   | X X X |   |       |   |    M3|
B - B - B   B - B - B   I - I - I   K - K - K   C - C - C   I - I - I   P - P - P   P - P - P

B - B - B   C - C - C   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   C - C - C
|       |   |    M1|   | X X X |   |       |   |       |   | X X X |   | H3    |   |       |
B - B - B   C - C - C   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   C - C - C

P - P - P   K - K - K   I - I - I   C - C - C   K - K - K   I - I - I   P - P - P   K - K - K
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   K - K - K   I - I - I   C - C - C   K - K - K   I - I - I   P - P - P   K - K - K

C - C - C   C - C - C   I - I - I   C - C - C   K - K - K   I - I - I   P - P - P   O - O - O
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
C - C - C   C - C - C   I - I - I   C - C - C   K - K - K   I - I - I   P - P - P   O - O - O

N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

Heros:
Hero H1(Reverie_Ashels)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           146         1316        720         700         435         7/10        2500
No items in Inventory.
Hero H2(Skye_Soar)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           135         1464        770         396         490         5/10        2500
No items in Inventory.
Hero H3(Reverie_Ashels)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           135         1316        800         700         400         7/10        2500
No items in Inventory.
Monsters:
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           100         10          0           10%
Monster M2(Casper)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Monster M3(Blinky)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M2(Casper)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Select a monster to attack: 1

Hero H2(Skye_Soar)  vs  Monster M2(Casper)
Hero H2(Skye_Soar)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           135         1464        770         396         490         5/10        2500
No items in Inventory.
Monster M2(Casper)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Monster M2(Casper) dodged Hero H2(Skye_Soar)'s attack.

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: I
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

P - P - P   K - K - K   I - I - I   P - P - P   K - K - K   I - I - I   P - P - P   B - B - B
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   K - K - K   I - I - I   P - P - P   K - K - K   I - I - I   P - P - P   B - B - B

P - P - P   P - P - P   I - I - I   P - P - P   B - B - B   I - I - I   P - P - P   B - B - B
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   P - P - P   I - I - I   P - P - P   B - B - B   I - I - I   P - P - P   B - B - B

B - B - B   B - B - B   I - I - I   K - K - K   C - C - C   I - I - I   P - P - P   P - P - P
|       |   |       |   | X X X |   | H2    |   | H1 M2|   | X X X |   |       |   |    M3|
B - B - B   B - B - B   I - I - I   K - K - K   C - C - C   I - I - I   P - P - P   P - P - P

B - B - B   C - C - C   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   C - C - C
|       |   |    M1|   | X X X |   |       |   |       |   | X X X |   | H3    |   |       |
B - B - B   C - C - C   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   C - C - C

P - P - P   K - K - K   I - I - I   C - C - C   K - K - K   I - I - I   P - P - P   K - K - K
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   K - K - K   I - I - I   C - C - C   K - K - K   I - I - I   P - P - P   K - K - K

C - C - C   C - C - C   I - I - I   C - C - C   K - K - K   I - I - I   P - P - P   O - O - O
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
C - C - C   C - C - C   I - I - I   C - C - C   K - K - K   I - I - I   P - P - P   O - O - O

N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

Heros:
Hero H1(Reverie_Ashels)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           146         1316        720         700         435         7/10        2500
No items in Inventory.
Hero H2(Skye_Soar)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           135         1464        770         396         490         5/10        2500
No items in Inventory.
Hero H3(Reverie_Ashels)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           135         1316        800         700         400         7/10        2500
No items in Inventory.
Monsters:
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           100         10          0           10%
Monster M2(Casper)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Monster M3(Blinky)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: d

Hero H3(Reverie_Ashels) left plain space.

Hero H3(Reverie_Ashels) enter cave space.
Hero H3(Reverie_Ashels) increased 40 agility.
Monster M1 move down.

Monster M2(Casper)  vs  Hero H1(Reverie_Ashels)
Monster M2(Casper)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Hero H1(Reverie_Ashels)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           146         1316        720         700         435         7/10        2500
No items in Inventory.
Monster M2(Casper)'s attack damage is 10
Hero H1(Reverie_Ashels)'s defense is 0
Monster M2(Casper) attacked Hero H1(Reverie_Ashels) for 10 damage!

Monster M3(Blinky)  vs  Hero H3(Reverie_Ashels)
Monster M3(Blinky)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Hero H3(Reverie_Ashels)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           135         1316        800         700         440         7/10        2500
No items in Inventory.
Monster M3(Blinky)'s attack damage is 10
Hero H3(Reverie_Ashels)'s defense is 0
Monster M3(Blinky) attacked Hero H3(Reverie_Ashels) for 10 damage!

Hero H1(Reverie_Ashels) regain 13 HP and 131 MP
Hero H2(Skye_Soar) regain 13 HP and 146 MP
Hero H3(Reverie_Ashels) regain 12 HP and 131 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M2(Casper)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Select a monster to attack: 1

Hero H1(Reverie_Ashels)  vs  Monster M2(Casper)
Hero H1(Reverie_Ashels)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           149         1447        720         700         435         7/10        2500
No items in Inventory.
Monster M2(Casper)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Hero H1(Reverie_Ashels)'s attack damage is 36
Monster M2(Casper)'s defense is 0
Hero H1(Reverie_Ashels) attacked Monster M2(Casper) for 36 damage!

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M2(Casper)
Level       HP          Damage      Defense     Dodge
1           64          10          0           5%
Select a monster to attack: 1

Hero H2(Skye_Soar)  vs  Monster M2(Casper)
Hero H2(Skye_Soar)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           148         1610        770         396         490         5/10        2500
No items in Inventory.
Monster M2(Casper)
Level       HP          Damage      Defense     Dodge
1           64          10          0           5%
Hero H2(Skye_Soar)'s attack damage is 38
Monster M2(Casper)'s defense is 0
Hero H2(Skye_Soar) attacked Monster M2(Casper) for 38 damage!

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M3(Blinky)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Select a monster to attack: 1

Hero H3(Reverie_Ashels)  vs  Monster M3(Blinky)
Hero H3(Reverie_Ashels)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           137         1447        800         700         440         7/10        2500
No items in Inventory.
Monster M3(Blinky)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Hero H3(Reverie_Ashels)'s attack damage is 40
Monster M3(Blinky)'s defense is 0
Hero H3(Reverie_Ashels) attacked Monster M3(Blinky) for 40 damage!
Monster M1 move down.

Monster M2(Casper)  vs  Hero H1(Reverie_Ashels)
Monster M2(Casper)
Level       HP          Damage      Defense     Dodge
1           26          10          0           5%
Hero H1(Reverie_Ashels)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           149         1447        720         700         435         7/10        2500
No items in Inventory.
Monster M2(Casper)'s attack damage is 10
Hero H1(Reverie_Ashels)'s defense is 0
Monster M2(Casper) attacked Hero H1(Reverie_Ashels) for 10 damage!

Monster M3(Blinky)  vs  Hero H3(Reverie_Ashels)
Monster M3(Blinky)
Level       HP          Damage      Defense     Dodge
1           60          10          0           5%
Hero H3(Reverie_Ashels)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           137         1447        800         700         440         7/10        2500
No items in Inventory.
Monster M3(Blinky)'s attack damage is 10
Hero H3(Reverie_Ashels)'s defense is 0
Monster M3(Blinky) attacked Hero H3(Reverie_Ashels) for 10 damage!

Hero H1(Reverie_Ashels) regain 13 HP and 144 MP
Hero H2(Skye_Soar) regain 14 HP and 161 MP
Hero H3(Reverie_Ashels) regain 12 HP and 144 MP
Monster M4 is spawned
Monster M5 is spawned
Monster M6 is spawned


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M2(Casper)
Level       HP          Damage      Defense     Dodge
1           26          10          0           5%
Select a monster to attack: 1

Hero H1(Reverie_Ashels)  vs  Monster M2(Casper)
Hero H1(Reverie_Ashels)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           152         1591        720         700         435         7/10        2500
No items in Inventory.
Monster M2(Casper)
Level       HP          Damage      Defense     Dodge
1           26          10          0           5%
Hero H1(Reverie_Ashels)'s attack damage is 36
Monster M2(Casper)'s defense is 0
Hero H1(Reverie_Ashels) attacked Monster M2(Casper) for 36 damage!
Monster M2(Casper) was defeated.
Hero H1(Reverie_Ashels) got 500 gold.
Hero H1(Reverie_Ashels) got 2 experiences.
Hero H2(Skye_Soar) got 500 gold.
Hero H2(Skye_Soar) got 2 experiences.
Hero H3(Reverie_Ashels) got 500 gold.
Hero H3(Reverie_Ashels) got 2 experiences.

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
No monster in range.

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: I
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |    M4 |   | X X X |   |       |   |    M5 |   | X X X |   |       |   |    M6 |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

P - P - P   K - K - K   I - I - I   P - P - P   K - K - K   I - I - I   P - P - P   B - B - B
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   K - K - K   I - I - I   P - P - P   K - K - K   I - I - I   P - P - P   B - B - B

P - P - P   P - P - P   I - I - I   P - P - P   B - B - B   I - I - I   P - P - P   B - B - B
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   P - P - P   I - I - I   P - P - P   B - B - B   I - I - I   P - P - P   B - B - B

B - B - B   B - B - B   I - I - I   K - K - K   C - C - C   I - I - I   P - P - P   P - P - P
|       |   |       |   | X X X |   | H2    |   | H1    |   | X X X |   |       |   |    M3|
B - B - B   B - B - B   I - I - I   K - K - K   C - C - C   I - I - I   P - P - P   P - P - P

B - B - B   C - C - C   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   C - C - C
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   | H3    |
B - B - B   C - C - C   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   C - C - C

P - P - P   K - K - K   I - I - I   C - C - C   K - K - K   I - I - I   P - P - P   K - K - K
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   K - K - K   I - I - I   C - C - C   K - K - K   I - I - I   P - P - P   K - K - K

C - C - C   C - C - C   I - I - I   C - C - C   K - K - K   I - I - I   P - P - P   O - O - O
|       |   |    M1|   | X X X |   |       |   |       |   | X X X |   |       |   |       |
C - C - C   C - C - C   I - I - I   C - C - C   K - K - K   I - I - I   P - P - P   O - O - O

N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

Heros:
Hero H1(Reverie_Ashels)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           152         1591        720         700         435         9/10        3000
No items in Inventory.
Hero H2(Skye_Soar)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           162         1771        770         396         490         7/10        3000
No items in Inventory.
Hero H3(Reverie_Ashels)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           139         1591        800         700         440         9/10        3000
No items in Inventory.
Monsters:
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           100         10          0           10%
Monster M3(Blinky)
Level       HP          Damage      Defense     Dodge
1           60          10          0           5%
Monster M4(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           100         10          0           10%
Monster M5(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           100         10          0           10%
Monster M6(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           100         10          0           10%

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H2(Skye_Soar) left koulou space.
Hero H2(Skye_Soar) decreased 77 strength.

Hero H2(Skye_Soar) enter plain space.

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H3(Reverie_Ashels) left cave space.
Hero H3(Reverie_Ashels) decreased 44 agility.

Hero H3(Reverie_Ashels) enter plain space.
Monster M1 move down.

Monster M3(Blinky)  vs  Hero H3(Reverie_Ashels)
Monster M3(Blinky)
Level       HP          Damage      Defense     Dodge
1           60          10          0           5%
Hero H3(Reverie_Ashels)(Sorcerer)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           139         1591        800         700         396         9/10        3000
No items in Inventory.
Monster M3(Blinky)'s attack damage is 10
Hero H3(Reverie_Ashels)'s defense is 0
Monster M3(Blinky) attacked Hero H3(Reverie_Ashels) for 10 damage!
Monster M4 move down.
Monster M5 move down.
Monster M6 move down.

Hero H1(Reverie_Ashels) regain 15 HP and 159 MP
Hero H2(Skye_Soar) regain 16 HP and 177 MP
Hero H3(Reverie_Ashels) regain 12 HP and 159 MP
Monsters won!



SELECT THE GAME TO PLAY:
1. Legends: Monsters and Heroes
2. Legends of Valor
0. Quit

Please select: 2
Select difficulity: 
1. Easy
2. Medium
3. Hard
Please select: 1

Welcome to game "Legends of Valor":

In a land torn by war, monsters rise from their Nexus, threatening to overrun the world. From the Heroes' Nexus, 
a brave team of three Warrior, Sorcerer, and Paladin sets out to stop the invasion and bring peace to the land.

The heroes must navigate through three perilous lanes, each filled with monsters, obstacles, and special terrain that boosts
their abilities. Bushes make heroes quicker, Caves make them harder to hit, and Koulou makes them stronger.
Monsters attack relentlessly, moving closer to the Heroes' Nexus with every turn. The heroes must fight back using their weapons,
spells, and teamwork. Along the way, they can buy potions, weapons, and gear to prepare for the battles ahead.

The goal is simple: reach the Monsters' Nexus before the monsters reach yours. Only the strongest and smartest team will survive.
Are you ready for the adventure?

HOW TO PLAY:

MOVEMENT:
W/w: move up
A/a: move left
S/s: move down
D/d: move right
M/m: enter market
I/i: show hero/monster info

ATTACK/FIGHT:
K/k: attack monster
C/c: cast spell
U/u: use potion

EQUIPE:
E/e: equip weapon
O/o: equip armor

TP/RECALL:
T/t: teleport
R/r: recall

GAME INFO:
Q/q: quit game
H/h: help

N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |    M1|   | X X X |   |       |   |    M2|   | X X X |   |       |   |    M3|
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

O - O - O   B - B - B   I - I - I   P - P - P   B - B - B   I - I - I   C - C - C   K - K - K
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
O - O - O   B - B - B   I - I - I   P - P - P   B - B - B   I - I - I   C - C - C   K - K - K

K - K - K   K - K - K   I - I - I   K - K - K   C - C - C   I - I - I   B - B - B   P - P - P
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
K - K - K   K - K - K   I - I - I   K - K - K   C - C - C   I - I - I   B - B - B   P - P - P

P - P - P   K - K - K   I - I - I   K - K - K   P - P - P   I - I - I   P - P - P   C - C - C
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   K - K - K   I - I - I   K - K - K   P - P - P   I - I - I   P - P - P   C - C - C

B - B - B   C - C - C   I - I - I   P - P - P   K - K - K   I - I - I   C - C - C   P - P - P
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
B - B - B   C - C - C   I - I - I   P - P - P   K - K - K   I - I - I   C - C - C   P - P - P

P - P - P   P - P - P   I - I - I   B - B - B   C - C - C   I - I - I   B - B - B   C - C - C
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   P - P - P   I - I - I   B - B - B   C - C - C   I - I - I   B - B - B   C - C - C

O - O - O   P - P - P   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   O - O - O
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
O - O - O   P - P - P   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   O - O - O

N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
| H1    |   |       |   | X X X |   | H2    |   |       |   | X X X |   | H3    |   |       |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

Heros:
Hero H1(Undefeated_Yoj)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           100         400         800         400         700         7/10        2500
No items in Inventory.
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           100         400         700         800         600         6/10        2500
No items in Inventory.
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           100         400         700         800         600         6/10        2500
No items in Inventory.
Monsters:
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           100         10          0           10%
Monster M2(BigBad-Wolf)
Level       HP          Damage      Defense     Dodge
1           100         10          10          15%
Monster M3(Casper)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: M

Hero H1(Undefeated_Yoj)'s turn(b-buy, s-sell, q-cancel).
enter B/S/Q: B

Welcome to Market.
1. IceSpell, Name: Snow_Cannon, Price: 500, Level: 2, Damage: 650, MP Cost: 250
2. Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
3. FireSpell, Name: Flame_Tornado, Price: 700, Level: 4, Damage: 850, MP Cost: 300
4. Weapon, Name: Bow, Price: 300, Level: 2, Damage: 500, Hands: 2
5. Weapon, Name: Scythe, Price: 1000, Level: 6, Damage: 1100, Hands: 2
6. Weapon, Name: Axe, Price: 550, Level: 5, Damage: 850, Hands: 1
7. Potion, Name: Healing_Potion, Price: 250, Level: 1, Effective Amount: 100, Attribute Affected: Health
8. Potion, Name: Strength_Potion, Price: 200, Level: 1, Effective Amount: 75, Attribute Affected: Strength
9. Weapon, Name: TSwords, Price: 1400, Level: 8, Damage: 1600, Hands: 2
10. LightningSpell, Name: Lightning_Dagger, Price: 400, Level: 1, Damage: 500, MP Cost: 150
0. Quit
Your choice: 2
Hero H1(Undefeated_Yoj) bought a Sword

H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero removed an obstacle.

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: M

Hero H2(Eunoia_Cyn)'s turn(b-buy, s-sell, q-cancel).
enter B/S/Q: B

Welcome to Market.
1. Potion, Name: Healing_Potion, Price: 250, Level: 1, Effective Amount: 100, Attribute Affected: Health
2. Potion, Name: Strength_Potion, Price: 200, Level: 1, Effective Amount: 75, Attribute Affected: Strength
3. IceSpell, Name: Snow_Cannon, Price: 500, Level: 2, Damage: 650, MP Cost: 250
4. Potion, Name: Magic_Potion, Price: 350, Level: 2, Effective Amount: 100, Attribute Affected: Mana
5. Potion, Name: Luck_Elixir, Price: 500, Level: 4, Effective Amount: 65, Attribute Affected: Agility
6. Armor, Name: Platinum_Shield, Price: 150, Level: 1, Damage Reduction: 200
7. Potion, Name: Mermaid_Tears, Price: 850, Level: 5, Effective Amount: 100, Attribute Affected: Health/Mana/Strength/Agility
8. Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
9. Armor, Name: Breastplate, Price: 350, Level: 2, Damage Reduction: 600
10. Armor, Name: Full_Body_Armor, Price: 1000, Level: 2, Damage Reduction: 1100
0. Quit
Your choice: 10
Your level is too low.

Welcome to Market.
1. Potion, Name: Healing_Potion, Price: 250, Level: 1, Effective Amount: 100, Attribute Affected: Health
2. Potion, Name: Strength_Potion, Price: 200, Level: 1, Effective Amount: 75, Attribute Affected: Strength
3. IceSpell, Name: Snow_Cannon, Price: 500, Level: 2, Damage: 650, MP Cost: 250
4. Potion, Name: Magic_Potion, Price: 350, Level: 2, Effective Amount: 100, Attribute Affected: Mana
5. Potion, Name: Luck_Elixir, Price: 500, Level: 4, Effective Amount: 65, Attribute Affected: Agility
6. Armor, Name: Platinum_Shield, Price: 150, Level: 1, Damage Reduction: 200
7. Potion, Name: Mermaid_Tears, Price: 850, Level: 5, Effective Amount: 100, Attribute Affected: Health/Mana/Strength/Agility
8. Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
9. Armor, Name: Breastplate, Price: 350, Level: 2, Damage Reduction: 600
0. Quit
Your choice: 9
Your level is too low.

Welcome to Market.
1. Potion, Name: Healing_Potion, Price: 250, Level: 1, Effective Amount: 100, Attribute Affected: Health
2. Potion, Name: Strength_Potion, Price: 200, Level: 1, Effective Amount: 75, Attribute Affected: Strength
3. IceSpell, Name: Snow_Cannon, Price: 500, Level: 2, Damage: 650, MP Cost: 250
4. Potion, Name: Magic_Potion, Price: 350, Level: 2, Effective Amount: 100, Attribute Affected: Mana
5. Potion, Name: Luck_Elixir, Price: 500, Level: 4, Effective Amount: 65, Attribute Affected: Agility
6. Armor, Name: Platinum_Shield, Price: 150, Level: 1, Damage Reduction: 200
7. Potion, Name: Mermaid_Tears, Price: 850, Level: 5, Effective Amount: 100, Attribute Affected: Health/Mana/Strength/Agility
8. Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
0. Quit
Your choice: 8
Hero H2(Eunoia_Cyn) bought a Sword

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H2(Eunoia_Cyn) left nexus space.

Hero H2(Eunoia_Cyn) enter bush space.
Hero H2(Eunoia_Cyn) increased 80 dexterity.

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: w

Hero H3(Eunoia_Cyn) left nexus space.

Hero H3(Eunoia_Cyn) enter plain space.
Monster M1 move down.
Monster M2 move down.
Monster M3 move down.

Hero H1(Undefeated_Yoj) regain 10 HP and 40 MP
Hero H2(Eunoia_Cyn) regain 10 HP and 40 MP
Hero H3(Eunoia_Cyn) regain 10 HP and 40 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H1(Undefeated_Yoj) left nexus space.

Hero H1(Undefeated_Yoj) enter plain space.

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H2(Eunoia_Cyn) left bush space.
Hero H2(Eunoia_Cyn) decreased 88 dexterity.

Hero H2(Eunoia_Cyn) enter bush space.
Hero H2(Eunoia_Cyn) increased 79 dexterity.

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H3(Eunoia_Cyn) left plain space.

Hero H3(Eunoia_Cyn) enter bush space.
Hero H3(Eunoia_Cyn) increased 80 dexterity.
Monster M1 move down.
Monster M2 move down.
Monster M3 move down.

Hero H1(Undefeated_Yoj) regain 11 HP and 44 MP
Hero H2(Eunoia_Cyn) regain 11 HP and 44 MP
Hero H3(Eunoia_Cyn) regain 11 HP and 44 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H1(Undefeated_Yoj) left plain space.

Hero H1(Undefeated_Yoj) enter plain space.

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: I
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

O - O - O   B - B - B   I - I - I   P - P - P   B - B - B   I - I - I   C - C - C   K - K - K
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
O - O - O   B - B - B   I - I - I   P - P - P   B - B - B   I - I - I   C - C - C   K - K - K

K - K - K   K - K - K   I - I - I   K - K - K   C - C - C   I - I - I   B - B - B   P - P - P
|       |   |    M1|   | X X X |   |       |   |    M2|   | X X X |   |       |   |    M3|
K - K - K   K - K - K   I - I - I   K - K - K   C - C - C   I - I - I   B - B - B   P - P - P

P - P - P   K - K - K   I - I - I   K - K - K   P - P - P   I - I - I   P - P - P   C - C - C
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   K - K - K   I - I - I   K - K - K   P - P - P   I - I - I   P - P - P   C - C - C

B - B - B   C - C - C   I - I - I   P - P - P   K - K - K   I - I - I   C - C - C   P - P - P
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
B - B - B   C - C - C   I - I - I   P - P - P   K - K - K   I - I - I   C - C - C   P - P - P

P - P - P   P - P - P   I - I - I   B - B - B   C - C - C   I - I - I   B - B - B   C - C - C
| H1    |   |       |   | X X X |   | H2    |   |       |   | X X X |   | H3    |   |       |
P - P - P   P - P - P   I - I - I   B - B - B   C - C - C   I - I - I   B - B - B   C - C - C

P - P - P   P - P - P   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   O - O - O
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   P - P - P   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   O - O - O

N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

Heros:
Hero H1(Undefeated_Yoj)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           121         484         800         400         700         7/10        2000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           121         484         700         871         600         6/10        2000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           121         484         700         880         600         6/10        2500
No items in Inventory.
Monsters:
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           100         10          0           10%
Monster M2(BigBad-Wolf)
Level       HP          Damage      Defense     Dodge
1           100         10          10          15%
Monster M3(Casper)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H2(Eunoia_Cyn) left bush space.
Hero H2(Eunoia_Cyn) decreased 87 dexterity.

Hero H2(Eunoia_Cyn) enter plain space.

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H3(Eunoia_Cyn) left bush space.
Hero H3(Eunoia_Cyn) decreased 88 dexterity.

Hero H3(Eunoia_Cyn) enter cave space.
Hero H3(Eunoia_Cyn) increased 60 agility.
Monster M1 move down.
Monster M2 move down.
Monster M3 move down.

Hero H1(Undefeated_Yoj) regain 12 HP and 48 MP
Hero H2(Eunoia_Cyn) regain 12 HP and 48 MP
Hero H3(Eunoia_Cyn) regain 12 HP and 48 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H1(Undefeated_Yoj) left plain space.

Hero H1(Undefeated_Yoj) enter bush space.
Hero H1(Undefeated_Yoj) increased 40 dexterity.

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: I
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

O - O - O   B - B - B   I - I - I   P - P - P   B - B - B   I - I - I   C - C - C   K - K - K
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
O - O - O   B - B - B   I - I - I   P - P - P   B - B - B   I - I - I   C - C - C   K - K - K

K - K - K   K - K - K   I - I - I   K - K - K   C - C - C   I - I - I   B - B - B   P - P - P
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
K - K - K   K - K - K   I - I - I   K - K - K   C - C - C   I - I - I   B - B - B   P - P - P

P - P - P   K - K - K   I - I - I   K - K - K   P - P - P   I - I - I   P - P - P   C - C - C
|       |   |    M1|   | X X X |   |       |   |    M2|   | X X X |   |       |   |    M3|
P - P - P   K - K - K   I - I - I   K - K - K   P - P - P   I - I - I   P - P - P   C - C - C

B - B - B   C - C - C   I - I - I   P - P - P   K - K - K   I - I - I   C - C - C   P - P - P
| H1    |   |       |   | X X X |   | H2    |   |       |   | X X X |   | H3    |   |       |
B - B - B   C - C - C   I - I - I   P - P - P   K - K - K   I - I - I   C - C - C   P - P - P

P - P - P   P - P - P   I - I - I   B - B - B   C - C - C   I - I - I   B - B - B   C - C - C
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   P - P - P   I - I - I   B - B - B   C - C - C   I - I - I   B - B - B   C - C - C

P - P - P   P - P - P   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   O - O - O
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   P - P - P   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   O - O - O

N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

Heros:
Hero H1(Undefeated_Yoj)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           133         532         800         440         700         7/10        2000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           133         532         700         784         600         6/10        2000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           133         532         700         792         660         6/10        2500
No items in Inventory.
Monsters:
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           100         10          0           10%
Monster M2(BigBad-Wolf)
Level       HP          Damage      Defense     Dodge
1           100         10          10          15%
Monster M3(Casper)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: D

Hero H2(Eunoia_Cyn) left plain space.

Hero H2(Eunoia_Cyn) enter koulou space.
Hero H2(Eunoia_Cyn) increased 70 strength.

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: D

Hero H3(Eunoia_Cyn) left cave space.
Hero H3(Eunoia_Cyn) decreased 66 agility.

Hero H3(Eunoia_Cyn) enter plain space.

Monster M1(Natsunomeryu)  vs  Hero H1(Undefeated_Yoj)
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           100         10          0           10%
Hero H1(Undefeated_Yoj)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           133         532         800         440         700         7/10        2000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M1(Natsunomeryu)'s attack damage is 10
Hero H1(Undefeated_Yoj)'s defense is 0
Monster M1(Natsunomeryu) attacked Hero H1(Undefeated_Yoj) for 10 damage!

Monster M2(BigBad-Wolf)  vs  Hero H2(Eunoia_Cyn)
Monster M2(BigBad-Wolf)
Level       HP          Damage      Defense     Dodge
1           100         10          10          15%
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           133         532         770         784         600         6/10        2000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M2(BigBad-Wolf)'s attack damage is 10
Hero H2(Eunoia_Cyn)'s defense is 0
Monster M2(BigBad-Wolf) attacked Hero H2(Eunoia_Cyn) for 10 damage!

Monster M3(Casper)  vs  Hero H3(Eunoia_Cyn)
Monster M3(Casper)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           133         532         700         792         594         6/10        2500
No items in Inventory.
Monster M3(Casper)'s attack damage is 10
Hero H3(Eunoia_Cyn)'s defense is 0
Monster M3(Casper) attacked Hero H3(Eunoia_Cyn) for 10 damage!

Hero H1(Undefeated_Yoj) regain 12 HP and 53 MP
Hero H2(Eunoia_Cyn) regain 12 HP and 53 MP
Hero H3(Eunoia_Cyn) regain 12 HP and 53 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: D

Hero H1(Undefeated_Yoj) left bush space.
Hero H1(Undefeated_Yoj) decreased 44 dexterity.

Hero H1(Undefeated_Yoj) enter cave space.
Hero H1(Undefeated_Yoj) increased 70 agility.

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M2(BigBad-Wolf)
Level       HP          Damage      Defense     Dodge
1           100         10          10          15%
Select a monster to attack: 1

Hero H2(Eunoia_Cyn)  vs  Monster M2(BigBad-Wolf)
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           135         585         770         784         600         6/10        2000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M2(BigBad-Wolf)
Level       HP          Damage      Defense     Dodge
1           100         10          10          15%
Hero H2(Eunoia_Cyn)'s attack damage is 38
Monster M2(BigBad-Wolf)'s defense is 10
Hero H2(Eunoia_Cyn) attacked Monster M2(BigBad-Wolf) for 28 damage!

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K 
1. Monster M3(Casper)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Select a monster to attack: 1

Hero H3(Eunoia_Cyn)  vs  Monster M3(Casper)
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           135         585         700         792         594         6/10        2500
No items in Inventory.
Monster M3(Casper)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Hero H3(Eunoia_Cyn)'s attack damage is 35
Monster M3(Casper)'s defense is 0
Hero H3(Eunoia_Cyn) attacked Monster M3(Casper) for 35 damage!

Monster M1(Natsunomeryu)  vs  Hero H1(Undefeated_Yoj)
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           100         10          0           10%
Hero H1(Undefeated_Yoj)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           135         585         800         396         770         7/10        2000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M1(Natsunomeryu)'s attack damage is 10
Hero H1(Undefeated_Yoj)'s defense is 0
Monster M1(Natsunomeryu) attacked Hero H1(Undefeated_Yoj) for 10 damage!

Monster M2(BigBad-Wolf)  vs  Hero H2(Eunoia_Cyn)
Monster M2(BigBad-Wolf)
Level       HP          Damage      Defense     Dodge
1           72          10          10          15%
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           135         585         770         784         600         6/10        2000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M2(BigBad-Wolf)'s attack damage is 10
Hero H2(Eunoia_Cyn)'s defense is 0
Monster M2(BigBad-Wolf) attacked Hero H2(Eunoia_Cyn) for 10 damage!

Monster M3(Casper)  vs  Hero H3(Eunoia_Cyn)
Monster M3(Casper)
Level       HP          Damage      Defense     Dodge
1           65          10          0           5%
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           135         585         700         792         594         6/10        2500
No items in Inventory.
Monster M3(Casper)'s attack damage is 10
Hero H3(Eunoia_Cyn)'s defense is 0
Monster M3(Casper) attacked Hero H3(Eunoia_Cyn) for 10 damage!

Hero H1(Undefeated_Yoj) regain 12 HP and 58 MP
Hero H2(Eunoia_Cyn) regain 12 HP and 58 MP
Hero H3(Eunoia_Cyn) regain 12 HP and 58 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           100         10          0           10%
Select a monster to attack: 1

Hero H1(Undefeated_Yoj)  vs  Monster M1(Natsunomeryu)
Hero H1(Undefeated_Yoj)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           137         643         800         396         770         7/10        2000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           100         10          0           10%
Hero H1(Undefeated_Yoj)'s attack damage is 40
Monster M1(Natsunomeryu)'s defense is 0
Hero H1(Undefeated_Yoj) attacked Monster M1(Natsunomeryu) for 40 damage!

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M2(BigBad-Wolf)
Level       HP          Damage      Defense     Dodge
1           72          10          10          15%
Select a monster to attack: 1

Hero H2(Eunoia_Cyn)  vs  Monster M2(BigBad-Wolf)
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           137         643         770         784         600         6/10        2000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M2(BigBad-Wolf)
Level       HP          Damage      Defense     Dodge
1           72          10          10          15%
Hero H2(Eunoia_Cyn)'s attack damage is 38
Monster M2(BigBad-Wolf)'s defense is 10
Hero H2(Eunoia_Cyn) attacked Monster M2(BigBad-Wolf) for 28 damage!

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M3(Casper)
Level       HP          Damage      Defense     Dodge
1           65          10          0           5%
Select a monster to attack: 1

Hero H3(Eunoia_Cyn)  vs  Monster M3(Casper)
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           137         643         700         792         594         6/10        2500
No items in Inventory.
Monster M3(Casper)
Level       HP          Damage      Defense     Dodge
1           65          10          0           5%
Hero H3(Eunoia_Cyn)'s attack damage is 35
Monster M3(Casper)'s defense is 0
Hero H3(Eunoia_Cyn) attacked Monster M3(Casper) for 35 damage!

Monster M1(Natsunomeryu)  vs  Hero H1(Undefeated_Yoj)
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           60          10          0           10%
Hero H1(Undefeated_Yoj)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           137         643         800         396         770         7/10        2000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M1(Natsunomeryu)'s attack damage is 10
Hero H1(Undefeated_Yoj)'s defense is 0
Monster M1(Natsunomeryu) attacked Hero H1(Undefeated_Yoj) for 10 damage!

Monster M2(BigBad-Wolf)  vs  Hero H2(Eunoia_Cyn)
Monster M2(BigBad-Wolf)
Level       HP          Damage      Defense     Dodge
1           44          10          10          15%
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           137         643         770         784         600         6/10        2000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M2(BigBad-Wolf)'s attack damage is 10
Hero H2(Eunoia_Cyn)'s defense is 0
Monster M2(BigBad-Wolf) attacked Hero H2(Eunoia_Cyn) for 10 damage!

Monster M3(Casper)  vs  Hero H3(Eunoia_Cyn)
Monster M3(Casper)
Level       HP          Damage      Defense     Dodge
1           30          10          0           5%
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           137         643         700         792         594         6/10        2500
No items in Inventory.
Monster M3(Casper)'s attack damage is 10
Hero H3(Eunoia_Cyn)'s defense is 0
Monster M3(Casper) attacked Hero H3(Eunoia_Cyn) for 10 damage!

Hero H1(Undefeated_Yoj) regain 12 HP and 64 MP
Hero H2(Eunoia_Cyn) regain 12 HP and 64 MP
Hero H3(Eunoia_Cyn) regain 12 HP and 64 MP
Monster M4 is spawned
Monster M5 is spawned
Monster M6 is spawned


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: iI
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: I
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |    M4 |   | X X X |   |       |   |    M5 |   | X X X |   |       |   |    M6 |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

O - O - O   B - B - B   I - I - I   P - P - P   B - B - B   I - I - I   C - C - C   K - K - K
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
O - O - O   B - B - B   I - I - I   P - P - P   B - B - B   I - I - I   C - C - C   K - K - K

K - K - K   K - K - K   I - I - I   K - K - K   C - C - C   I - I - I   B - B - B   P - P - P
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
K - K - K   K - K - K   I - I - I   K - K - K   C - C - C   I - I - I   B - B - B   P - P - P

P - P - P   K - K - K   I - I - I   K - K - K   P - P - P   I - I - I   P - P - P   C - C - C
|       |   |    M1|   | X X X |   |       |   |    M2|   | X X X |   |       |   |    M3|
P - P - P   K - K - K   I - I - I   K - K - K   P - P - P   I - I - I   P - P - P   C - C - C

B - B - B   C - C - C   I - I - I   P - P - P   K - K - K   I - I - I   C - C - C   P - P - P
|       |   | H1    |   | X X X |   |       |   | H2    |   | X X X |   |       |   | H3    |
B - B - B   C - C - C   I - I - I   P - P - P   K - K - K   I - I - I   C - C - C   P - P - P

P - P - P   P - P - P   I - I - I   B - B - B   C - C - C   I - I - I   B - B - B   C - C - C
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   P - P - P   I - I - I   B - B - B   C - C - C   I - I - I   B - B - B   C - C - C

P - P - P   P - P - P   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   O - O - O
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   P - P - P   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   O - O - O

N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

Heros:
Hero H1(Undefeated_Yoj)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           139         707         800         396         770         7/10        2000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           139         707         770         784         600         6/10        2000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           139         707         700         792         594         6/10        2500
No items in Inventory.
Monsters:
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           60          10          0           10%
Monster M2(BigBad-Wolf)
Level       HP          Damage      Defense     Dodge
1           44          10          10          15%
Monster M3(Casper)
Level       HP          Damage      Defense     Dodge
1           30          10          0           5%
Monster M4(Casper)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Monster M5(Blinky)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Monster M6(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           100         10          0           10%

H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           60          10          0           10%
Select a monster to attack: 1

Hero H1(Undefeated_Yoj)  vs  Monster M1(Natsunomeryu)
Hero H1(Undefeated_Yoj)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           139         707         800         396         770         7/10        2000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           60          10          0           10%
Hero H1(Undefeated_Yoj)'s attack damage is 40
Monster M1(Natsunomeryu)'s defense is 0
Hero H1(Undefeated_Yoj) attacked Monster M1(Natsunomeryu) for 40 damage!

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M2(BigBad-Wolf)
Level       HP          Damage      Defense     Dodge
1           44          10          10          15%
Select a monster to attack: 1

Hero H2(Eunoia_Cyn)  vs  Monster M2(BigBad-Wolf)
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           139         707         770         784         600         6/10        2000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M2(BigBad-Wolf)
Level       HP          Damage      Defense     Dodge
1           44          10          10          15%
Hero H2(Eunoia_Cyn)'s attack damage is 38
Monster M2(BigBad-Wolf)'s defense is 10
Hero H2(Eunoia_Cyn) attacked Monster M2(BigBad-Wolf) for 28 damage!

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: E
You have no weapon in inventory.

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M3(Casper)
Level       HP          Damage      Defense     Dodge
1           30          10          0           5%
Select a monster to attack: 1

Hero H3(Eunoia_Cyn)  vs  Monster M3(Casper)
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           139         707         700         792         594         6/10        2500
No items in Inventory.
Monster M3(Casper)
Level       HP          Damage      Defense     Dodge
1           30          10          0           5%
Hero H3(Eunoia_Cyn)'s attack damage is 35
Monster M3(Casper)'s defense is 0
Hero H3(Eunoia_Cyn) attacked Monster M3(Casper) for 35 damage!
Monster M3(Casper) was defeated.
Hero H1(Undefeated_Yoj) got 500 gold.
Hero H1(Undefeated_Yoj) got 2 experiences.
Hero H2(Eunoia_Cyn) got 500 gold.
Hero H2(Eunoia_Cyn) got 2 experiences.
Hero H3(Eunoia_Cyn) got 500 gold.
Hero H3(Eunoia_Cyn) got 2 experiences.

Monster M1(Natsunomeryu)  vs  Hero H1(Undefeated_Yoj)
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           20          10          0           10%
Hero H1(Undefeated_Yoj)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           139         707         800         396         770         9/10        2500
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M1(Natsunomeryu)'s attack damage is 10
Hero H1(Undefeated_Yoj)'s defense is 0
Monster M1(Natsunomeryu) attacked Hero H1(Undefeated_Yoj) for 10 damage!

Monster M2(BigBad-Wolf)  vs  Hero H2(Eunoia_Cyn)
Monster M2(BigBad-Wolf)
Level       HP          Damage      Defense     Dodge
1           16          10          10          15%
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           139         707         770         784         600         8/10        2500
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M2(BigBad-Wolf)'s attack damage is 10
Hero H2(Eunoia_Cyn)'s defense is 0
Monster M2(BigBad-Wolf) attacked Hero H2(Eunoia_Cyn) for 10 damage!
Monster M4 move down.
Monster M5 move down.
Monster M6 move down.

Hero H1(Undefeated_Yoj) regain 12 HP and 70 MP
Hero H2(Eunoia_Cyn) regain 12 HP and 70 MP
Hero H3(Eunoia_Cyn) regain 13 HP and 70 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: E
1. Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
0. Cancel
Your choice: 1
Hero H1(Undefeated_Yoj) equipped Sword

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M2(BigBad-Wolf)
Level       HP          Damage      Defense     Dodge
1           16          10          10          15%
Select a monster to attack: 1

Hero H2(Eunoia_Cyn)  vs  Monster M2(BigBad-Wolf)
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
1           141         777         770         784         600         8/10        2500
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M2(BigBad-Wolf)
Level       HP          Damage      Defense     Dodge
1           16          10          10          15%
Hero H2(Eunoia_Cyn)'s attack damage is 38
Monster M2(BigBad-Wolf)'s defense is 10
Hero H2(Eunoia_Cyn) attacked Monster M2(BigBad-Wolf) for 28 damage!
Monster M2(BigBad-Wolf) was defeated.
Hero H1(Undefeated_Yoj) got 500 gold.
Hero H1(Undefeated_Yoj) got 2 experiences.
Hero H1(Undefeated_Yoj) level up.
Hero H1(Undefeated_Yoj) increased 77 MP.
Hero H1(Undefeated_Yoj) increased 80 strength.
Hero H1(Undefeated_Yoj) increased 77 agility.
Hero H1(Undefeated_Yoj) increased 19 dexterity.
Hero H2(Eunoia_Cyn) got 500 gold.
Hero H2(Eunoia_Cyn) got 2 experiences.
Hero H2(Eunoia_Cyn) level up.
Hero H2(Eunoia_Cyn) increased 77 MP.
Hero H2(Eunoia_Cyn) increased 77 strength.
Hero H2(Eunoia_Cyn) increased 60 agility.
Hero H2(Eunoia_Cyn) increased 39 dexterity.
Hero H3(Eunoia_Cyn) got 500 gold.
Hero H3(Eunoia_Cyn) got 2 experiences.
Hero H3(Eunoia_Cyn) level up.
Hero H3(Eunoia_Cyn) increased 77 MP.
Hero H3(Eunoia_Cyn) increased 70 strength.
Hero H3(Eunoia_Cyn) increased 59 agility.
Hero H3(Eunoia_Cyn) increased 39 dexterity.

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H3(Eunoia_Cyn) left plain space.

Hero H3(Eunoia_Cyn) enter cave space.
Hero H3(Eunoia_Cyn) increased 65 agility.

Monster M1(Natsunomeryu)  vs  Hero H1(Undefeated_Yoj)
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           20          10          0           10%
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           200         854         880         415         847         1/20        3000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M1(Natsunomeryu)'s attack damage is 10
Hero H1(Undefeated_Yoj)'s defense is 0
Monster M1(Natsunomeryu) attacked Hero H1(Undefeated_Yoj) for 10 damage!
Monster M4 move down.
Monster M5 move down.
Monster M6 move down.

Hero H1(Undefeated_Yoj) regain 19 HP and 85 MP
Hero H2(Eunoia_Cyn) regain 20 HP and 85 MP
Hero H3(Eunoia_Cyn) regain 20 HP and 85 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H1(Undefeated_Yoj) left cave space.
Hero H1(Undefeated_Yoj) decreased 84 agility.

Hero H1(Undefeated_Yoj) enter koulou space.
Hero H1(Undefeated_Yoj) increased 88 strength.

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H2(Eunoia_Cyn) left koulou space.
Hero H2(Eunoia_Cyn) decreased 84 strength.

Hero H2(Eunoia_Cyn) enter plain space.

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H3(Eunoia_Cyn) left cave space.
Hero H3(Eunoia_Cyn) decreased 71 agility.

Hero H3(Eunoia_Cyn) enter plain space.

Monster M1(Natsunomeryu)  vs  Hero H1(Undefeated_Yoj)
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           20          10          0           10%
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           209         939         968         415         763         1/20        3000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M1(Natsunomeryu)'s attack damage is 10
Hero H1(Undefeated_Yoj)'s defense is 0
Monster M1(Natsunomeryu) attacked Hero H1(Undefeated_Yoj) for 10 damage!

Monster M4(Casper)  vs  Hero H1(Undefeated_Yoj)
Monster M4(Casper)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           199         939         968         415         763         1/20        3000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M4(Casper)'s attack damage is 10
Hero H1(Undefeated_Yoj)'s defense is 0
Monster M4(Casper) attacked Hero H1(Undefeated_Yoj) for 10 damage!

Monster M5(Blinky)  vs  Hero H2(Eunoia_Cyn)
Monster M5(Blinky)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           220         939         763         823         660         0/20        3000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M5(Blinky)'s attack damage is 10
Hero H2(Eunoia_Cyn)'s defense is 0
Monster M5(Blinky) attacked Hero H2(Eunoia_Cyn) for 10 damage!

Monster M6(Natsunomeryu)  vs  Hero H3(Eunoia_Cyn)
Monster M6(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           100         10          0           10%
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           220         939         770         831         647         0/20        3500
No items in Inventory.
Monster M6(Natsunomeryu)'s attack damage is 10
Hero H3(Eunoia_Cyn)'s defense is 0
Monster M6(Natsunomeryu) attacked Hero H3(Eunoia_Cyn) for 10 damage!

Hero H1(Undefeated_Yoj) regain 18 HP and 93 MP
Hero H2(Eunoia_Cyn) regain 21 HP and 93 MP
Hero H3(Eunoia_Cyn) regain 21 HP and 93 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Cannot move behind a monster without killing it!

H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Cannot move behind a monster without killing it!

H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Cannot move behind a monster without killing it!

H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M4(Casper)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
2. Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           20          10          0           10%
Select a monster to attack: 1

Hero H1(Undefeated_Yoj)  vs  Monster M4(Casper)
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           207         1032        968         415         763         1/20        3000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M4(Casper)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Hero H1(Undefeated_Yoj)'s attack damage is 88
Monster M4(Casper)'s defense is 0
Hero H1(Undefeated_Yoj) attacked Monster M4(Casper) for 88 damage!

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M5(Blinky)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Select a monster to attack: 1

Hero H2(Eunoia_Cyn)  vs  Monster M5(Blinky)
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           231         1032        763         823         660         0/20        3000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M5(Blinky)
Level       HP          Damage      Defense     Dodge
1           100         10          0           5%
Hero H2(Eunoia_Cyn)'s attack damage is 38
Monster M5(Blinky)'s defense is 0
Hero H2(Eunoia_Cyn) attacked Monster M5(Blinky) for 38 damage!

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M6(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           100         10          0           10%
Select a monster to attack: 1

Hero H3(Eunoia_Cyn)  vs  Monster M6(Natsunomeryu)
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           231         1032        770         831         647         0/20        3500
No items in Inventory.
Monster M6(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           100         10          0           10%
Hero H3(Eunoia_Cyn)'s attack damage is 38
Monster M6(Natsunomeryu)'s defense is 0
Hero H3(Eunoia_Cyn) attacked Monster M6(Natsunomeryu) for 38 damage!

Monster M1(Natsunomeryu)  vs  Hero H1(Undefeated_Yoj)
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           20          10          0           10%
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           207         1032        968         415         763         1/20        3000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M1(Natsunomeryu)'s attack damage is 10
Hero H1(Undefeated_Yoj)'s defense is 0
Monster M1(Natsunomeryu) attacked Hero H1(Undefeated_Yoj) for 10 damage!

Monster M4(Casper)  vs  Hero H1(Undefeated_Yoj)
Monster M4(Casper)
Level       HP          Damage      Defense     Dodge
1           12          10          0           5%
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           197         1032        968         415         763         1/20        3000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M4(Casper)'s attack damage is 10
Hero H1(Undefeated_Yoj)'s defense is 0
Monster M4(Casper) attacked Hero H1(Undefeated_Yoj) for 10 damage!

Monster M5(Blinky)  vs  Hero H2(Eunoia_Cyn)
Monster M5(Blinky)
Level       HP          Damage      Defense     Dodge
1           62          10          0           5%
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           231         1032        763         823         660         0/20        3000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M5(Blinky)'s attack damage is 10
Hero H2(Eunoia_Cyn)'s defense is 0
Monster M5(Blinky) attacked Hero H2(Eunoia_Cyn) for 10 damage!

Monster M6(Natsunomeryu)  vs  Hero H3(Eunoia_Cyn)
Monster M6(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           62          10          0           10%
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           231         1032        770         831         647         0/20        3500
No items in Inventory.
Monster M6(Natsunomeryu)'s attack damage is 10
Hero H3(Eunoia_Cyn)'s defense is 0
Monster M6(Natsunomeryu) attacked Hero H3(Eunoia_Cyn) for 10 damage!

Hero H1(Undefeated_Yoj) regain 18 HP and 103 MP
Hero H2(Eunoia_Cyn) regain 22 HP and 103 MP
Hero H3(Eunoia_Cyn) regain 22 HP and 103 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Cannot move behind a monster without killing it!

H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M4(Casper)
Level       HP          Damage      Defense     Dodge
1           12          10          0           5%
2. Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           20          10          0           10%
Select a monster to attack: 1

Hero H1(Undefeated_Yoj)  vs  Monster M4(Casper)
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           205         1135        968         415         763         1/20        3000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M4(Casper)
Level       HP          Damage      Defense     Dodge
1           12          10          0           5%
Hero H1(Undefeated_Yoj)'s attack damage is 88
Monster M4(Casper)'s defense is 0
Hero H1(Undefeated_Yoj) attacked Monster M4(Casper) for 88 damage!
Monster M4(Casper) was defeated.
Hero H1(Undefeated_Yoj) got 500 gold.
Hero H1(Undefeated_Yoj) got 2 experiences.
Hero H2(Eunoia_Cyn) got 500 gold.
Hero H2(Eunoia_Cyn) got 2 experiences.
Hero H3(Eunoia_Cyn) got 500 gold.
Hero H3(Eunoia_Cyn) got 2 experiences.

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: I
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

O - O - O   B - B - B   I - I - I   P - P - P   B - B - B   I - I - I   C - C - C   K - K - K
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
O - O - O   B - B - B   I - I - I   P - P - P   B - B - B   I - I - I   C - C - C   K - K - K

K - K - K   K - K - K   I - I - I   K - K - K   C - C - C   I - I - I   B - B - B   P - P - P
|       |   |       |   | X X X |   |       |   |    M5 |   | X X X |   |       |   | H3 M6 |
K - K - K   K - K - K   I - I - I   K - K - K   C - C - C   I - I - I   B - B - B   P - P - P

P - P - P   K - K - K   I - I - I   K - K - K   P - P - P   I - I - I   P - P - P   C - C - C
|       |   | H1 M1|   | X X X |   |       |   | H2    |   | X X X |   |       |   |       |
P - P - P   K - K - K   I - I - I   K - K - K   P - P - P   I - I - I   P - P - P   C - C - C

B - B - B   C - C - C   I - I - I   P - P - P   K - K - K   I - I - I   C - C - C   P - P - P
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
B - B - B   C - C - C   I - I - I   P - P - P   K - K - K   I - I - I   C - C - C   P - P - P

P - P - P   P - P - P   I - I - I   B - B - B   C - C - C   I - I - I   B - B - B   C - C - C
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   P - P - P   I - I - I   B - B - B   C - C - C   I - I - I   B - B - B   C - C - C

P - P - P   P - P - P   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   O - O - O
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   P - P - P   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   O - O - O

N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

Heros:
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           205         1135        968         415         763         3/20        3500
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           243         1135        763         823         660         2/20        3500
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           243         1135        770         831         647         2/20        4000
No items in Inventory.
Monsters:
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           20          10          0           10%
Monster M5(Blinky)
Level       HP          Damage      Defense     Dodge
1           62          10          0           5%
Monster M6(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           62          10          0           10%

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M5(Blinky)
Level       HP          Damage      Defense     Dodge
1           62          10          0           5%
Select a monster to attack: 1

Hero H2(Eunoia_Cyn)  vs  Monster M5(Blinky)
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           243         1135        763         823         660         2/20        3500
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M5(Blinky)
Level       HP          Damage      Defense     Dodge
1           62          10          0           5%
Hero H2(Eunoia_Cyn)'s attack damage is 38
Monster M5(Blinky)'s defense is 0
Hero H2(Eunoia_Cyn) attacked Monster M5(Blinky) for 38 damage!

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M6(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           62          10          0           10%
Select a monster to attack: 1

Hero H3(Eunoia_Cyn)  vs  Monster M6(Natsunomeryu)
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           243         1135        770         831         647         2/20        4000
No items in Inventory.
Monster M6(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           62          10          0           10%
Monster M6(Natsunomeryu) dodged Hero H3(Eunoia_Cyn)'s attack.

Monster M1(Natsunomeryu)  vs  Hero H1(Undefeated_Yoj)
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           20          10          0           10%
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           205         1135        968         415         763         3/20        3500
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M1(Natsunomeryu)'s attack damage is 10
Hero H1(Undefeated_Yoj)'s defense is 0
Monster M1(Natsunomeryu) attacked Hero H1(Undefeated_Yoj) for 10 damage!

Monster M5(Blinky)  vs  Hero H2(Eunoia_Cyn)
Monster M5(Blinky)
Level       HP          Damage      Defense     Dodge
1           24          10          0           5%
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           243         1135        763         823         660         2/20        3500
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M5(Blinky)'s attack damage is 10
Hero H2(Eunoia_Cyn)'s defense is 0
Monster M5(Blinky) attacked Hero H2(Eunoia_Cyn) for 10 damage!

Monster M6(Natsunomeryu)  vs  Hero H3(Eunoia_Cyn)
Monster M6(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           62          10          0           10%
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           243         1135        770         831         647         2/20        4000
No items in Inventory.
Monster M6(Natsunomeryu)'s attack damage is 10
Hero H3(Eunoia_Cyn)'s defense is 0
Monster M6(Natsunomeryu) attacked Hero H3(Eunoia_Cyn) for 10 damage!

Hero H1(Undefeated_Yoj) regain 19 HP and 113 MP
Hero H2(Eunoia_Cyn) regain 23 HP and 113 MP
Hero H3(Eunoia_Cyn) regain 23 HP and 113 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           20          10          0           10%
Select a monster to attack: 1

Hero H1(Undefeated_Yoj)  vs  Monster M1(Natsunomeryu)
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           214         1248        968         415         763         3/20        3500
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M1(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           20          10          0           10%
Hero H1(Undefeated_Yoj)'s attack damage is 88
Monster M1(Natsunomeryu)'s defense is 0
Hero H1(Undefeated_Yoj) attacked Monster M1(Natsunomeryu) for 88 damage!
Monster M1(Natsunomeryu) was defeated.
Hero H1(Undefeated_Yoj) got 500 gold.
Hero H1(Undefeated_Yoj) got 2 experiences.
Hero H2(Eunoia_Cyn) got 500 gold.
Hero H2(Eunoia_Cyn) got 2 experiences.
Hero H3(Eunoia_Cyn) got 500 gold.
Hero H3(Eunoia_Cyn) got 2 experiences.

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M5(Blinky)
Level       HP          Damage      Defense     Dodge
1           24          10          0           5%
Select a monster to attack: 1

Hero H2(Eunoia_Cyn)  vs  Monster M5(Blinky)
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           256         1248        763         823         660         4/20        4000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M5(Blinky)
Level       HP          Damage      Defense     Dodge
1           24          10          0           5%
Hero H2(Eunoia_Cyn)'s attack damage is 38
Monster M5(Blinky)'s defense is 0
Hero H2(Eunoia_Cyn) attacked Monster M5(Blinky) for 38 damage!
Monster M5(Blinky) was defeated.
Hero H1(Undefeated_Yoj) got 500 gold.
Hero H1(Undefeated_Yoj) got 2 experiences.
Hero H2(Eunoia_Cyn) got 500 gold.
Hero H2(Eunoia_Cyn) got 2 experiences.
Hero H3(Eunoia_Cyn) got 500 gold.
Hero H3(Eunoia_Cyn) got 2 experiences.

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M6(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           62          10          0           10%
Select a monster to attack: 1

Hero H3(Eunoia_Cyn)  vs  Monster M6(Natsunomeryu)
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           256         1248        770         831         647         6/20        5000
No items in Inventory.
Monster M6(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           62          10          0           10%
Hero H3(Eunoia_Cyn)'s attack damage is 38
Monster M6(Natsunomeryu)'s defense is 0
Hero H3(Eunoia_Cyn) attacked Monster M6(Natsunomeryu) for 38 damage!

Monster M6(Natsunomeryu)  vs  Hero H3(Eunoia_Cyn)
Monster M6(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           24          10          0           10%
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           256         1248        770         831         647         6/20        5000
No items in Inventory.
Monster M6(Natsunomeryu)'s attack damage is 10
Hero H3(Eunoia_Cyn)'s defense is 0
Monster M6(Natsunomeryu) attacked Hero H3(Eunoia_Cyn) for 10 damage!

Hero H1(Undefeated_Yoj) regain 21 HP and 124 MP
Hero H2(Eunoia_Cyn) regain 25 HP and 124 MP
Hero H3(Eunoia_Cyn) regain 24 HP and 124 MP
Monster M7 is spawned
Monster M8 is spawned
Monster M9 is spawned


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: I
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |    M7 |   | X X X |   |       |   |    M8 |   | X X X |   |       |   |    M9 |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

O - O - O   B - B - B   I - I - I   P - P - P   B - B - B   I - I - I   C - C - C   K - K - K
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
O - O - O   B - B - B   I - I - I   P - P - P   B - B - B   I - I - I   C - C - C   K - K - K

K - K - K   K - K - K   I - I - I   K - K - K   C - C - C   I - I - I   B - B - B   P - P - P
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   | H3 M6 |
K - K - K   K - K - K   I - I - I   K - K - K   C - C - C   I - I - I   B - B - B   P - P - P

P - P - P   K - K - K   I - I - I   K - K - K   P - P - P   I - I - I   P - P - P   C - C - C
|       |   | H1    |   | X X X |   |       |   | H2    |   | X X X |   |       |   |       |
P - P - P   K - K - K   I - I - I   K - K - K   P - P - P   I - I - I   P - P - P   C - C - C

B - B - B   C - C - C   I - I - I   P - P - P   K - K - K   I - I - I   C - C - C   P - P - P
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
B - B - B   C - C - C   I - I - I   P - P - P   K - K - K   I - I - I   C - C - C   P - P - P

P - P - P   P - P - P   I - I - I   B - B - B   C - C - C   I - I - I   B - B - B   C - C - C
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   P - P - P   I - I - I   B - B - B   C - C - C   I - I - I   B - B - B   C - C - C

P - P - P   P - P - P   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   O - O - O
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   P - P - P   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   O - O - O

N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

Heros:
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           235         1372        968         415         763         7/20        4500
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           281         1372        763         823         660         6/20        4500
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           270         1372        770         831         647         6/20        5000
No items in Inventory.
Monsters:
Monster M6(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           24          10          0           10%
Monster M7(Chrysophylax)
Level       HP          Damage      Defense     Dodge
2           200         30          20          20%
Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           200         15          10          40%
Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%

H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H1(Undefeated_Yoj) left koulou space.
Hero H1(Undefeated_Yoj) decreased 96 strength.

Hero H1(Undefeated_Yoj) enter koulou space.
Hero H1(Undefeated_Yoj) increased 87 strength.

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H2(Eunoia_Cyn) left plain space.

Hero H2(Eunoia_Cyn) enter cave space.
Hero H2(Eunoia_Cyn) increased 66 agility.

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M6(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           24          10          0           10%
Select a monster to attack: 1

Hero H3(Eunoia_Cyn)  vs  Monster M6(Natsunomeryu)
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           270         1372        770         831         647         6/20        5000
No items in Inventory.
Monster M6(Natsunomeryu)
Level       HP          Damage      Defense     Dodge
1           24          10          0           10%
Hero H3(Eunoia_Cyn)'s attack damage is 38
Monster M6(Natsunomeryu)'s defense is 0
Hero H3(Eunoia_Cyn) attacked Monster M6(Natsunomeryu) for 38 damage!
Monster M6(Natsunomeryu) was defeated.
Hero H1(Undefeated_Yoj) got 500 gold.
Hero H1(Undefeated_Yoj) got 2 experiences.
Hero H2(Eunoia_Cyn) got 500 gold.
Hero H2(Eunoia_Cyn) got 2 experiences.
Hero H3(Eunoia_Cyn) got 500 gold.
Hero H3(Eunoia_Cyn) got 2 experiences.
Monster M7 move down.
Monster M8 move down.
Monster M9 move down.

Hero H1(Undefeated_Yoj) regain 23 HP and 137 MP
Hero H2(Eunoia_Cyn) regain 28 HP and 137 MP
Hero H3(Eunoia_Cyn) regain 27 HP and 137 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H1(Undefeated_Yoj) left koulou space.
Hero H1(Undefeated_Yoj) decreased 95 strength.

Hero H1(Undefeated_Yoj) enter bush space.
Hero H1(Undefeated_Yoj) increased 41 dexterity.

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H2(Eunoia_Cyn) left cave space.
Hero H2(Eunoia_Cyn) decreased 72 agility.

Hero H2(Eunoia_Cyn) enter bush space.
Hero H2(Eunoia_Cyn) increased 82 dexterity.

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Hero H3(Eunoia_Cyn) left plain space.

Hero H3(Eunoia_Cyn) enter koulou space.
Hero H3(Eunoia_Cyn) increased 77 strength.

Monster M7(Chrysophylax)  vs  Hero H1(Undefeated_Yoj)
Monster M7(Chrysophylax)
Level       HP          Damage      Defense     Dodge
2           200         30          20          20%
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           258         1509        864         456         763         9/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M7(Chrysophylax)'s attack damage is 30
Hero H1(Undefeated_Yoj)'s defense is 0
Monster M7(Chrysophylax) attacked Hero H1(Undefeated_Yoj) for 30 damage!

Monster M8(Andrealphus)  vs  Hero H2(Eunoia_Cyn)
Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           200         15          10          40%
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           309         1509        763         905         654         8/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M8(Andrealphus)'s attack damage is 15
Hero H2(Eunoia_Cyn)'s defense is 0
Monster M8(Andrealphus) attacked Hero H2(Eunoia_Cyn) for 15 damage!

Monster M9(WickedWitch)  vs  Hero H3(Eunoia_Cyn)
Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           297         1509        847         831         647         8/20        5500
No items in Inventory.
Monster M9(WickedWitch)'s attack damage is 20
Hero H3(Eunoia_Cyn)'s defense is 0
Monster M9(WickedWitch) attacked Hero H3(Eunoia_Cyn) for 20 damage!

Hero H1(Undefeated_Yoj) regain 22 HP and 150 MP
Hero H2(Eunoia_Cyn) regain 29 HP and 150 MP
Hero H3(Eunoia_Cyn) regain 27 HP and 150 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Cannot move behind a monster without killing it!

H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M7(Chrysophylax)
Level       HP          Damage      Defense     Dodge
2           200         30          20          20%
Select a monster to attack: 1

Hero H1(Undefeated_Yoj)  vs  Monster M7(Chrysophylax)
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           250         1659        864         456         763         9/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M7(Chrysophylax)
Level       HP          Damage      Defense     Dodge
2           200         30          20          20%
Hero H1(Undefeated_Yoj)'s attack damage is 83
Monster M7(Chrysophylax)'s defense is 20
Hero H1(Undefeated_Yoj) attacked Monster M7(Chrysophylax) for 63 damage!

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           200         15          10          40%
Select a monster to attack: 1

Hero H2(Eunoia_Cyn)  vs  Monster M8(Andrealphus)
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           323         1659        763         905         654         8/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           200         15          10          40%
Monster M8(Andrealphus) dodged Hero H2(Eunoia_Cyn)'s attack.

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
Select a monster to attack: 1

Hero H3(Eunoia_Cyn)  vs  Monster M9(WickedWitch)
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           304         1659        847         831         647         8/20        5500
No items in Inventory.
Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
Monster M9(WickedWitch) dodged Hero H3(Eunoia_Cyn)'s attack.

Monster M7(Chrysophylax)  vs  Hero H1(Undefeated_Yoj)
Monster M7(Chrysophylax)
Level       HP          Damage      Defense     Dodge
2           137         30          20          20%
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           250         1659        864         456         763         9/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M7(Chrysophylax)'s attack damage is 30
Hero H1(Undefeated_Yoj)'s defense is 0
Monster M7(Chrysophylax) attacked Hero H1(Undefeated_Yoj) for 30 damage!

Monster M8(Andrealphus)  vs  Hero H2(Eunoia_Cyn)
Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           200         15          10          40%
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           323         1659        763         905         654         8/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M8(Andrealphus)'s attack damage is 15
Hero H2(Eunoia_Cyn)'s defense is 0
Monster M8(Andrealphus) attacked Hero H2(Eunoia_Cyn) for 15 damage!

Monster M9(WickedWitch)  vs  Hero H3(Eunoia_Cyn)
Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           304         1659        847         831         647         8/20        5500
No items in Inventory.
Monster M9(WickedWitch)'s attack damage is 20
Hero H3(Eunoia_Cyn)'s defense is 0
Monster M9(WickedWitch) attacked Hero H3(Eunoia_Cyn) for 20 damage!

Hero H1(Undefeated_Yoj) regain 22 HP and 165 MP
Hero H2(Eunoia_Cyn) regain 30 HP and 165 MP
Hero H3(Eunoia_Cyn) regain 28 HP and 165 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M7(Chrysophylax)
Level       HP          Damage      Defense     Dodge
2           137         30          20          20%
Select a monster to attack: 1

Hero H1(Undefeated_Yoj)  vs  Monster M7(Chrysophylax)
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           242         1824        864         456         763         9/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M7(Chrysophylax)
Level       HP          Damage      Defense     Dodge
2           137         30          20          20%
Hero H1(Undefeated_Yoj)'s attack damage is 83
Monster M7(Chrysophylax)'s defense is 20
Hero H1(Undefeated_Yoj) attacked Monster M7(Chrysophylax) for 63 damage!

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           200         15          10          40%
Select a monster to attack: 1

Hero H2(Eunoia_Cyn)  vs  Monster M8(Andrealphus)
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           338         1824        763         905         654         8/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           200         15          10          40%
Hero H2(Eunoia_Cyn)'s attack damage is 38
Monster M8(Andrealphus)'s defense is 10
Hero H2(Eunoia_Cyn) attacked Monster M8(Andrealphus) for 28 damage!

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K 
1. Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
Select a monster to attack: 1

Hero H3(Eunoia_Cyn)  vs  Monster M9(WickedWitch)
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           312         1824        847         831         647         8/20        5500
No items in Inventory.
Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
Hero H3(Eunoia_Cyn)'s attack damage is 42
Monster M9(WickedWitch)'s defense is 20
Hero H3(Eunoia_Cyn) attacked Monster M9(WickedWitch) for 22 damage!

Monster M7(Chrysophylax)  vs  Hero H1(Undefeated_Yoj)
Monster M7(Chrysophylax)
Level       HP          Damage      Defense     Dodge
2           74          30          20          20%
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           242         1824        864         456         763         9/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M7(Chrysophylax)'s attack damage is 30
Hero H1(Undefeated_Yoj)'s defense is 0
Monster M7(Chrysophylax) attacked Hero H1(Undefeated_Yoj) for 30 damage!

Monster M8(Andrealphus)  vs  Hero H2(Eunoia_Cyn)
Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           172         15          10          40%
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           338         1824        763         905         654         8/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M8(Andrealphus)'s attack damage is 15
Hero H2(Eunoia_Cyn)'s defense is 0
Monster M8(Andrealphus) attacked Hero H2(Eunoia_Cyn) for 15 damage!

Monster M9(WickedWitch)  vs  Hero H3(Eunoia_Cyn)
Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           178         20          20          25%
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           312         1824        847         831         647         8/20        5500
No items in Inventory.
Monster M9(WickedWitch)'s attack damage is 20
Hero H3(Eunoia_Cyn)'s defense is 0
Monster M9(WickedWitch) attacked Hero H3(Eunoia_Cyn) for 20 damage!

Hero H1(Undefeated_Yoj) regain 21 HP and 182 MP
Hero H2(Eunoia_Cyn) regain 32 HP and 182 MP
Hero H3(Eunoia_Cyn) regain 29 HP and 182 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M7(Chrysophylax)
Level       HP          Damage      Defense     Dodge
2           74          30          20          20%
Select a monster to attack: 1

Hero H1(Undefeated_Yoj)  vs  Monster M7(Chrysophylax)
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           233         2006        864         456         763         9/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M7(Chrysophylax)
Level       HP          Damage      Defense     Dodge
2           74          30          20          20%
Hero H1(Undefeated_Yoj)'s attack damage is 83
Monster M7(Chrysophylax)'s defense is 20
Hero H1(Undefeated_Yoj) attacked Monster M7(Chrysophylax) for 63 damage!

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K 
1. Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           172         15          10          40%
Select a monster to attack: 1

Hero H2(Eunoia_Cyn)  vs  Monster M8(Andrealphus)
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           355         2006        763         905         654         8/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           172         15          10          40%
Monster M8(Andrealphus) dodged Hero H2(Eunoia_Cyn)'s attack.

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K 
1. Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           178         20          20          25%
Select a monster to attack: 1

Hero H3(Eunoia_Cyn)  vs  Monster M9(WickedWitch)
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           321         2006        847         831         647         8/20        5500
No items in Inventory.
Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           178         20          20          25%
Hero H3(Eunoia_Cyn)'s attack damage is 42
Monster M9(WickedWitch)'s defense is 20
Hero H3(Eunoia_Cyn) attacked Monster M9(WickedWitch) for 22 damage!

Monster M7(Chrysophylax)  vs  Hero H1(Undefeated_Yoj)
Monster M7(Chrysophylax)
Level       HP          Damage      Defense     Dodge
2           11          30          20          20%
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           233         2006        864         456         763         9/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M7(Chrysophylax)'s attack damage is 30
Hero H1(Undefeated_Yoj)'s defense is 0
Monster M7(Chrysophylax) attacked Hero H1(Undefeated_Yoj) for 30 damage!

Monster M8(Andrealphus)  vs  Hero H2(Eunoia_Cyn)
Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           172         15          10          40%
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           355         2006        763         905         654         8/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M8(Andrealphus)'s attack damage is 15
Hero H2(Eunoia_Cyn)'s defense is 0
Monster M8(Andrealphus) attacked Hero H2(Eunoia_Cyn) for 15 damage!

Monster M9(WickedWitch)  vs  Hero H3(Eunoia_Cyn)
Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           156         20          20          25%
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           321         2006        847         831         647         8/20        5500
No items in Inventory.
Monster M9(WickedWitch)'s attack damage is 20
Hero H3(Eunoia_Cyn)'s defense is 0
Monster M9(WickedWitch) attacked Hero H3(Eunoia_Cyn) for 20 damage!

Hero H1(Undefeated_Yoj) regain 20 HP and 200 MP
Hero H2(Eunoia_Cyn) regain 34 HP and 200 MP
Hero H3(Eunoia_Cyn) regain 30 HP and 200 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: W

Cannot move behind a monster without killing it!

H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H:
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: I
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

O - O - O   B - B - B   I - I - I   P - P - P   B - B - B   I - I - I   C - C - C   K - K - K
|       |   | H1 M7 |   | X X X |   |       |   | H2 M8 |   | X X X |   |       |   | H3 M9 |
O - O - O   B - B - B   I - I - I   P - P - P   B - B - B   I - I - I   C - C - C   K - K - K

K - K - K   K - K - K   I - I - I   K - K - K   C - C - C   I - I - I   B - B - B   P - P - P
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
K - K - K   K - K - K   I - I - I   K - K - K   C - C - C   I - I - I   B - B - B   P - P - P

P - P - P   K - K - K   I - I - I   K - K - K   P - P - P   I - I - I   P - P - P   C - C - C
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   K - K - K   I - I - I   K - K - K   P - P - P   I - I - I   P - P - P   C - C - C

B - B - B   C - C - C   I - I - I   P - P - P   K - K - K   I - I - I   C - C - C   P - P - P
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
B - B - B   C - C - C   I - I - I   P - P - P   K - K - K   I - I - I   C - C - C   P - P - P

P - P - P   P - P - P   I - I - I   B - B - B   C - C - C   I - I - I   B - B - B   C - C - C
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   P - P - P   I - I - I   B - B - B   C - C - C   I - I - I   B - B - B   C - C - C

P - P - P   P - P - P   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   O - O - O
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   P - P - P   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   O - O - O

N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

Heros:
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           223         2206        864         456         763         9/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           374         2206        763         905         654         8/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           331         2206        847         831         647         8/20        5500
No items in Inventory.
Monsters:
Monster M7(Chrysophylax)
Level       HP          Damage      Defense     Dodge
2           11          30          20          20%
Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           172         15          10          40%
Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           156         20          20          25%

H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M7(Chrysophylax)
Level       HP          Damage      Defense     Dodge
2           11          30          20          20%
Select a monster to attack: 1

Hero H1(Undefeated_Yoj)  vs  Monster M7(Chrysophylax)
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           223         2206        864         456         763         9/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M7(Chrysophylax)
Level       HP          Damage      Defense     Dodge
2           11          30          20          20%
Monster M7(Chrysophylax) dodged Hero H1(Undefeated_Yoj)'s attack.

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           172         15          10          40%
Select a monster to attack: 1

Hero H2(Eunoia_Cyn)  vs  Monster M8(Andrealphus)
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           374         2206        763         905         654         8/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           172         15          10          40%
Hero H2(Eunoia_Cyn)'s attack damage is 38
Monster M8(Andrealphus)'s defense is 10
Hero H2(Eunoia_Cyn) attacked Monster M8(Andrealphus) for 28 damage!

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           156         20          20          25%
Select a monster to attack: 1

Hero H3(Eunoia_Cyn)  vs  Monster M9(WickedWitch)
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           331         2206        847         831         647         8/20        5500
No items in Inventory.
Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           156         20          20          25%
Hero H3(Eunoia_Cyn)'s attack damage is 42
Monster M9(WickedWitch)'s defense is 20
Hero H3(Eunoia_Cyn) attacked Monster M9(WickedWitch) for 22 damage!

Monster M7(Chrysophylax)  vs  Hero H1(Undefeated_Yoj)
Monster M7(Chrysophylax)
Level       HP          Damage      Defense     Dodge
2           11          30          20          20%
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           223         2206        864         456         763         9/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M7(Chrysophylax)'s attack damage is 30
Hero H1(Undefeated_Yoj)'s defense is 0
Monster M7(Chrysophylax) attacked Hero H1(Undefeated_Yoj) for 30 damage!

Monster M8(Andrealphus)  vs  Hero H2(Eunoia_Cyn)
Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           144         15          10          40%
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           374         2206        763         905         654         8/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M8(Andrealphus)'s attack damage is 15
Hero H2(Eunoia_Cyn)'s defense is 0
Monster M8(Andrealphus) attacked Hero H2(Eunoia_Cyn) for 15 damage!

Monster M9(WickedWitch)  vs  Hero H3(Eunoia_Cyn)
Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           134         20          20          25%
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           331         2206        847         831         647         8/20        5500
No items in Inventory.
Monster M9(WickedWitch)'s attack damage is 20
Hero H3(Eunoia_Cyn)'s defense is 0
Monster M9(WickedWitch) attacked Hero H3(Eunoia_Cyn) for 20 damage!

Hero H1(Undefeated_Yoj) regain 19 HP and 220 MP
Hero H2(Eunoia_Cyn) regain 35 HP and 220 MP
Hero H3(Eunoia_Cyn) regain 31 HP and 220 MP
Monster M10 is spawned
Monster M11 is spawned
Monster M12 is spawned


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M10(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
2. Monster M7(Chrysophylax)
Level       HP          Damage      Defense     Dodge
2           11          30          20          20%
Select a monster to attack: 2

Hero H1(Undefeated_Yoj)  vs  Monster M7(Chrysophylax)
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           212         2426        864         456         763         9/20        5000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M7(Chrysophylax)
Level       HP          Damage      Defense     Dodge
2           11          30          20          20%
Hero H1(Undefeated_Yoj)'s attack damage is 83
Monster M7(Chrysophylax)'s defense is 20
Hero H1(Undefeated_Yoj) attacked Monster M7(Chrysophylax) for 63 damage!
Monster M7(Chrysophylax) was defeated.
Hero H1(Undefeated_Yoj) got 1000 gold.
Hero H1(Undefeated_Yoj) got 4 experiences.
Hero H2(Eunoia_Cyn) got 1000 gold.
Hero H2(Eunoia_Cyn) got 4 experiences.
Hero H3(Eunoia_Cyn) got 1000 gold.
Hero H3(Eunoia_Cyn) got 4 experiences.

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M11(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
2. Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           144         15          10          40%
Select a monster to attack: 2

Hero H2(Eunoia_Cyn)  vs  Monster M8(Andrealphus)
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           394         2426        763         905         654         12/20       6000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           144         15          10          40%
Monster M8(Andrealphus) dodged Hero H2(Eunoia_Cyn)'s attack.

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M12(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
2. Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           134         20          20          25%
Select a monster to attack: 2

Hero H3(Eunoia_Cyn)  vs  Monster M9(WickedWitch)
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           342         2426        847         831         647         12/20       6500
No items in Inventory.
Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           134         20          20          25%
Hero H3(Eunoia_Cyn)'s attack damage is 42
Monster M9(WickedWitch)'s defense is 20
Hero H3(Eunoia_Cyn) attacked Monster M9(WickedWitch) for 22 damage!

Monster M8(Andrealphus)  vs  Hero H2(Eunoia_Cyn)
Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           144         15          10          40%
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           394         2426        763         905         654         12/20       6000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M8(Andrealphus)'s attack damage is 15
Hero H2(Eunoia_Cyn)'s defense is 0
Monster M8(Andrealphus) attacked Hero H2(Eunoia_Cyn) for 15 damage!

Monster M9(WickedWitch)  vs  Hero H3(Eunoia_Cyn)
Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           112         20          20          25%
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           342         2426        847         831         647         12/20       6500
No items in Inventory.
Monster M9(WickedWitch)'s attack damage is 20
Hero H3(Eunoia_Cyn)'s defense is 0
Monster M9(WickedWitch) attacked Hero H3(Eunoia_Cyn) for 20 damage!

Monster M10(WickedWitch)  vs  Hero H1(Undefeated_Yoj)
Monster M10(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           212         2426        864         456         763         13/20       6000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M10(WickedWitch)'s attack damage is 20
Hero H1(Undefeated_Yoj)'s defense is 0
Monster M10(WickedWitch) attacked Hero H1(Undefeated_Yoj) for 20 damage!

Monster M11(WickedWitch)  vs  Hero H2(Eunoia_Cyn)
Monster M11(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           379         2426        763         905         654         12/20       6000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M11(WickedWitch)'s attack damage is 20
Hero H2(Eunoia_Cyn)'s defense is 0
Monster M11(WickedWitch) attacked Hero H2(Eunoia_Cyn) for 20 damage!

Monster M12(WickedWitch)  vs  Hero H3(Eunoia_Cyn)
Monster M12(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           322         2426        847         831         647         12/20       6500
No items in Inventory.
Monster M12(WickedWitch)'s attack damage is 20
Hero H3(Eunoia_Cyn)'s defense is 0
Monster M12(WickedWitch) attacked Hero H3(Eunoia_Cyn) for 20 damage!

Hero H1(Undefeated_Yoj) regain 19 HP and 242 MP
Hero H2(Eunoia_Cyn) regain 35 HP and 242 MP
Hero H3(Eunoia_Cyn) regain 30 HP and 242 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M10(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
Select a monster to attack: 1

Hero H1(Undefeated_Yoj)  vs  Monster M10(WickedWitch)
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           211         2668        864         456         763         13/20       6000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M10(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
Hero H1(Undefeated_Yoj)'s attack damage is 83
Monster M10(WickedWitch)'s defense is 20
Hero H1(Undefeated_Yoj) attacked Monster M10(WickedWitch) for 63 damage!

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M11(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
2. Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           144         15          10          40%
Select a monster to attack: 2

Hero H2(Eunoia_Cyn)  vs  Monster M8(Andrealphus)
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           394         2668        763         905         654         12/20       6000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           144         15          10          40%
Monster M8(Andrealphus) dodged Hero H2(Eunoia_Cyn)'s attack.

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M12(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
2. Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           112         20          20          25%
Select a monster to attack: 2

Hero H3(Eunoia_Cyn)  vs  Monster M9(WickedWitch)
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           332         2668        847         831         647         12/20       6500
No items in Inventory.
Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           112         20          20          25%
Hero H3(Eunoia_Cyn)'s attack damage is 42
Monster M9(WickedWitch)'s defense is 20
Hero H3(Eunoia_Cyn) attacked Monster M9(WickedWitch) for 22 damage!

Monster M8(Andrealphus)  vs  Hero H2(Eunoia_Cyn)
Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           144         15          10          40%
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           394         2668        763         905         654         12/20       6000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M8(Andrealphus)'s attack damage is 15
Hero H2(Eunoia_Cyn)'s defense is 0
Monster M8(Andrealphus) attacked Hero H2(Eunoia_Cyn) for 15 damage!

Monster M9(WickedWitch)  vs  Hero H3(Eunoia_Cyn)
Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           90          20          20          25%
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           332         2668        847         831         647         12/20       6500
No items in Inventory.
Monster M9(WickedWitch)'s attack damage is 20
Hero H3(Eunoia_Cyn)'s defense is 0
Monster M9(WickedWitch) attacked Hero H3(Eunoia_Cyn) for 20 damage!

Monster M10(WickedWitch)  vs  Hero H1(Undefeated_Yoj)
Monster M10(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           137         20          20          25%
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           211         2668        864         456         763         13/20       6000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M10(WickedWitch)'s attack damage is 20
Hero H1(Undefeated_Yoj)'s defense is 0
Monster M10(WickedWitch) attacked Hero H1(Undefeated_Yoj) for 20 damage!

Monster M11(WickedWitch)  vs  Hero H2(Eunoia_Cyn)
Monster M11(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           379         2668        763         905         654         12/20       6000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M11(WickedWitch)'s attack damage is 20
Hero H2(Eunoia_Cyn)'s defense is 0
Monster M11(WickedWitch) attacked Hero H2(Eunoia_Cyn) for 20 damage!

Monster M12(WickedWitch)  vs  Hero H3(Eunoia_Cyn)
Monster M12(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           312         2668        847         831         647         12/20       6500
No items in Inventory.
Monster M12(WickedWitch)'s attack damage is 20
Hero H3(Eunoia_Cyn)'s defense is 0
Monster M12(WickedWitch) attacked Hero H3(Eunoia_Cyn) for 20 damage!

Hero H1(Undefeated_Yoj) regain 19 HP and 266 MP
Hero H2(Eunoia_Cyn) regain 35 HP and 266 MP
Hero H3(Eunoia_Cyn) regain 29 HP and 266 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M10(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           137         20          20          25%
Select a monster to attack: 2
Please enter an integer between 1 and 1.
Select a monster to attack: 1

Hero H1(Undefeated_Yoj)  vs  Monster M10(WickedWitch)
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           210         2934        864         456         763         13/20       6000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M10(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           137         20          20          25%
Monster M10(WickedWitch) dodged Hero H1(Undefeated_Yoj)'s attack.

H2's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M11(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
2. Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           144         15          10          40%
Select a monster to attack: 1

Hero H2(Eunoia_Cyn)  vs  Monster M11(WickedWitch)
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           394         2934        763         905         654         12/20       6000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M11(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
Hero H2(Eunoia_Cyn)'s attack damage is 38
Monster M11(WickedWitch)'s defense is 20
Hero H2(Eunoia_Cyn) attacked Monster M11(WickedWitch) for 18 damage!

H3's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: K
1. Monster M12(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
2. Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           90          20          20          25%
Select a monster to attack: Q
Please enter an integer between 1 and 2.
Select a monster to attack: 1

Hero H3(Eunoia_Cyn)  vs  Monster M12(WickedWitch)
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           321         2934        847         831         647         12/20       6500
No items in Inventory.
Monster M12(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           200         20          20          25%
Hero H3(Eunoia_Cyn)'s attack damage is 42
Monster M12(WickedWitch)'s defense is 20
Hero H3(Eunoia_Cyn) attacked Monster M12(WickedWitch) for 22 damage!

Monster M8(Andrealphus)  vs  Hero H2(Eunoia_Cyn)
Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           144         15          10          40%
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           394         2934        763         905         654         12/20       6000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M8(Andrealphus)'s attack damage is 15
Hero H2(Eunoia_Cyn)'s defense is 0
Monster M8(Andrealphus) attacked Hero H2(Eunoia_Cyn) for 15 damage!

Monster M9(WickedWitch)  vs  Hero H3(Eunoia_Cyn)
Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           90          20          20          25%
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           321         2934        847         831         647         12/20       6500
No items in Inventory.
Monster M9(WickedWitch)'s attack damage is 20
Hero H3(Eunoia_Cyn)'s defense is 0
Monster M9(WickedWitch) attacked Hero H3(Eunoia_Cyn) for 20 damage!

Monster M10(WickedWitch)  vs  Hero H1(Undefeated_Yoj)
Monster M10(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           137         20          20          25%
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           210         2934        864         456         763         13/20       6000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M10(WickedWitch)'s attack damage is 20
Hero H1(Undefeated_Yoj)'s defense is 0
Monster M10(WickedWitch) attacked Hero H1(Undefeated_Yoj) for 20 damage!

Monster M11(WickedWitch)  vs  Hero H2(Eunoia_Cyn)
Monster M11(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           182         20          20          25%
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           379         2934        763         905         654         12/20       6000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Monster M11(WickedWitch)'s attack damage is 20
Hero H2(Eunoia_Cyn)'s defense is 0
Monster M11(WickedWitch) attacked Hero H2(Eunoia_Cyn) for 20 damage!

Monster M12(WickedWitch)  vs  Hero H3(Eunoia_Cyn)
Monster M12(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           178         20          20          25%
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           301         2934        847         831         647         12/20       6500
No items in Inventory.
Monster M12(WickedWitch)'s attack damage is 20
Hero H3(Eunoia_Cyn)'s defense is 0
Monster M12(WickedWitch) attacked Hero H3(Eunoia_Cyn) for 20 damage!

Hero H1(Undefeated_Yoj) regain 19 HP and 293 MP
Hero H2(Eunoia_Cyn) regain 35 HP and 293 MP
Hero H3(Eunoia_Cyn) regain 28 HP and 293 MP


H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: I
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |    M10|   | X X X |   |       |   |    M11|   | X X X |   |       |   |    M12|
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

O - O - O   B - B - B   I - I - I   P - P - P   B - B - B   I - I - I   C - C - C   K - K - K
|       |   | H1    |   | X X X |   |       |   | H2 M8 |   | X X X |   |       |   | H3 M9 |
O - O - O   B - B - B   I - I - I   P - P - P   B - B - B   I - I - I   C - C - C   K - K - K

K - K - K   K - K - K   I - I - I   K - K - K   C - C - C   I - I - I   B - B - B   P - P - P
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
K - K - K   K - K - K   I - I - I   K - K - K   C - C - C   I - I - I   B - B - B   P - P - P

P - P - P   K - K - K   I - I - I   K - K - K   P - P - P   I - I - I   P - P - P   C - C - C
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   K - K - K   I - I - I   K - K - K   P - P - P   I - I - I   P - P - P   C - C - C

B - B - B   C - C - C   I - I - I   P - P - P   K - K - K   I - I - I   C - C - C   P - P - P
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
B - B - B   C - C - C   I - I - I   P - P - P   K - K - K   I - I - I   C - C - C   P - P - P

P - P - P   P - P - P   I - I - I   B - B - B   C - C - C   I - I - I   B - B - B   C - C - C
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   P - P - P   I - I - I   B - B - B   C - C - C   I - I - I   B - B - B   C - C - C

P - P - P   P - P - P   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   O - O - O
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
P - P - P   P - P - P   I - I - I   B - B - B   P - P - P   I - I - I   P - P - P   O - O - O

N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N
|       |   |       |   | X X X |   |       |   |       |   | X X X |   |       |   |       |
N - N - N   N - N - N   I - I - I   N - N - N   N - N - N   I - I - I   N - N - N   N - N - N

Heros:
Hero H1(Undefeated_Yoj)(Warrior)
Weapon: Sword
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           209         3227        864         456         763         13/20       6000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Hero H2(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           394         3227        763         905         654         12/20       6000
Inventory:
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
Hero H3(Eunoia_Cyn)(Warrior)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold
2           309         3227        847         831         647         12/20       6500
No items in Inventory.
Monsters:
Monster M8(Andrealphus)
Level       HP          Damage      Defense     Dodge
2           144         15          10          40%
Monster M9(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           90          20          20          25%
Monster M10(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           137         20          20          25%
Monster M11(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           182         20          20          25%
Monster M12(WickedWitch)
Level       HP          Damage      Defense     Dodge
2           178         20          20          25%

H1's turn.
enter W/A/S/D/K/C/U/E/O/T/R/Q/I/M/H: q

Bye!

```
