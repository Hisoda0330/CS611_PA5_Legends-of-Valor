Guide Readme

Required sections: Header, Files, Program Advantage/Notes, How to compile and run, I/O Example

# CS611-Assignment 4
## Legends Monsters and Heroes
---------------------------------------------------------------------------

Member:
- Name: Jinpeng Huang
- Email: jinpeng@bu.edu
- Student ID: U19568777

## Files
---------------------------------------------------------------------------

1. Legends_Monsters_and_Heroes folder: Use of the stats files that was provided in blackboard. But with a slightly twist of the attack and defense of the monsters for easier start and debug.

**src/:**
1. Game.java: Starts the game

**src/controller:**

1. Controller.java: Implement main game controller, manages game world, hero creation, movement controls, and game commands. Also plays music and observe message for display.

2. Input.java: Handles user input, prompts user to enter correct type of input, such as integer or character. 

3. MessageObserver.java: Defines an interface for observing messages, respond to messages for display notifications or logs.

4. MusicPlayer.java: PLays background music using audio file music.wav.

**src/model:**

1. Constants.java: Stores constant stats for the game, such as exp increase percent.

2. Dice.java: Provide methods for handling random events, simulate probability.

3. FileLoader.java: Contains a method to load data from a file to read game data. Loading entities, heros, items, spells, etc..

4. World.java: Represents the game world, modeled as an 8x8 grid with different types of space(inaccessible, market, and common). It initialize the world layout. 

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

1. Hero.java: Extends User to represent a hero with additional attributes(exp,mp,gold,strength,dex.,agility). Also controlls the inventory and equipped items. Also handles leveling up, using potion, equipping items, handling battle prep and outcomes. Hero regain 
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

1. Dragon.java: It represent Dragon type monsters. It inherits from Monster class and passes its stats(name,level,damage,defense,dodge) to the superclass.

2. Exoskeleton.java: It represent Exoskeleton type monsters. It inherits from Monster class and passes its stats(name,level,damage,defense,dodge) to the superclass.

3. Monster.java: Represents a generic monster with stats for damage, defense, and dodge. It has methods to decrease each attribute by a certain percentage, used when monsters are affected by different types of spells.

4. MonsterFactory.java: Implements UserFactory to create Monster instances. It reads monster data from files such(Dragons.txt, Exoskeletons.txt, Spirits.txt) and filters them based on a specified level.  Also returns monster for appropriate level accroding to heros.

5. MonsterGroup.java: Extends UserGroup to manage a group of monsters, specifically formatting the monster group’s details for display.

6. Spirit.java: It represent Spirit type monsters. It inherits from Monster class and passes its stats(name,level,damage,defense,dodge) to the superclass.

## Program Advantages/Notes
---------------------------------------------------------------------------
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
2. Adds background story of the game and summuarize the goal of the game.
3. Provides simple guideline of how to play the game.
4. Provides easy and simple controlls for the game, allowing user to get start with the game easier.
5. Validates each user input, preventing the game to crash when player enter wrong input, and prevent it to crash when don't play by the rule. such as going out of the board, or inside the restricted area. 


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

## How to compile and run
---------------------------------------------------------------------------

1. Navigate to the directory "src" OR (cd src)
2. Run in src dir:
   1. javac *.java
   2. java game.java

## Input/Output Example
---------------------------------------------------------------------------
```
jinpeng@Jinpengs-MacBook-Air src % javac *.java                          
jinpeng@Jinpengs-MacBook-Air src % java game.java                        

Welcome to game "Monsters and Heroes":
In a mystery dungeon where is full of darkness reigns, and monstrous creatures—dragons, armored exoskeletons, and elusive spirits—terrorize.
A legendary team of heroes sets forth from all around the league to break the ancient curse, each armed with powers: the Warrior, Sorcerer, and 
the Paladin comes together with incredible powers.

The heroes brave treacherous zones, battling monsters at every turn. Along the way, they find hidden markets to buy potions, weapons, spells, and armor essential for survival. 
Each different monster in the evil dungeon tests their skills uniquely—dragons breathe fire, exoskeletons have near-unbreakable armor, and spirits dodge
and disappear, requiring both strategy and courage.

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

Enter the size of hero party: 1
---------------------------------
| .*| $ | . | . | . | $ | . | . |
---------------------------------
| . | # | . | . | . | $ | . | $ |
---------------------------------
| . | . | # | . | . | $ | $ | # |
---------------------------------
| # | # | $ | $ | . | . | $ | # |
---------------------------------
| $ | $ | . | . | . | . | $ | $ |
---------------------------------
| . | # | . | . | . | $ | $ | # |
---------------------------------
| # | . | # | . | # | $ | . | . |
---------------------------------
| . | $ | . | . | $ | . | $ | # |
---------------------------------

enter W/A/S/D/Q/I: i

Hero party at Common Space

Hero Sehanine_Moonbow(Paladin)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold        
1           100         300         750         700         700         7/10        2500        
No items in Inventory.

---------------------------------
| .*| $ | . | . | . | $ | . | . |
---------------------------------
| . | # | . | . | . | $ | . | $ |
---------------------------------
| . | . | # | . | . | $ | $ | # |
---------------------------------
| # | # | $ | $ | . | . | $ | # |
---------------------------------
| $ | $ | . | . | . | . | $ | $ |
---------------------------------
| . | # | . | . | . | $ | $ | # |
---------------------------------
| # | . | # | . | # | $ | . | . |
---------------------------------
| . | $ | . | . | $ | . | $ | # |
---------------------------------

enter W/A/S/D/Q/I: s

Your enter a common space.
Fortunately, no battle took place.

---------------------------------
| . | $ | . | . | . | $ | . | . |
---------------------------------
| .*| # | . | . | . | $ | . | $ |
---------------------------------
| . | . | # | . | . | $ | $ | # |
---------------------------------
| # | # | $ | $ | . | . | $ | # |
---------------------------------
| $ | $ | . | . | . | . | $ | $ |
---------------------------------
| . | # | . | . | . | $ | $ | # |
---------------------------------
| # | . | # | . | # | $ | . | . |
---------------------------------
| . | $ | . | . | $ | . | $ | # |
---------------------------------

enter W/A/S/D/Q/I: s

Your enter a common space.
Fortunately, no battle took place.

---------------------------------
| . | $ | . | . | . | $ | . | . |
---------------------------------
| . | # | . | . | . | $ | . | $ |
---------------------------------
| .*| . | # | . | . | $ | $ | # |
---------------------------------
| # | # | $ | $ | . | . | $ | # |
---------------------------------
| $ | $ | . | . | . | . | $ | $ |
---------------------------------
| . | # | . | . | . | $ | $ | # |
---------------------------------
| # | . | # | . | # | $ | . | . |
---------------------------------
| . | $ | . | . | $ | . | $ | # |
---------------------------------

enter W/A/S/D/Q/I: d

Your enter a common space.
Fortunately, no battle took place.

---------------------------------
| . | $ | . | . | . | $ | . | . |
---------------------------------
| . | # | . | . | . | $ | . | $ |
---------------------------------
| . | .*| # | . | . | $ | $ | # |
---------------------------------
| # | # | $ | $ | . | . | $ | # |
---------------------------------
| $ | $ | . | . | . | . | $ | $ |
---------------------------------
| . | # | . | . | . | $ | $ | # |
---------------------------------
| # | . | # | . | # | $ | . | . |
---------------------------------
| . | $ | . | . | $ | . | $ | # |
---------------------------------

enter W/A/S/D/Q/I: a

Your enter a common space.
Fortunately, no battle took place.

---------------------------------
| . | $ | . | . | . | $ | . | . |
---------------------------------
| . | # | . | . | . | $ | . | $ |
---------------------------------
| .*| . | # | . | . | $ | $ | # |
---------------------------------
| # | # | $ | $ | . | . | $ | # |
---------------------------------
| $ | $ | . | . | . | . | $ | $ |
---------------------------------
| . | # | . | . | . | $ | $ | # |
---------------------------------
| # | . | # | . | # | $ | . | . |
---------------------------------
| . | $ | . | . | $ | . | $ | # |
---------------------------------

enter W/A/S/D/Q/I: w

Your enter a common space.
Fortunately, no battle took place.

---------------------------------
| . | $ | . | . | . | $ | . | . |
---------------------------------
| .*| # | . | . | . | $ | . | $ |
---------------------------------
| . | . | # | . | . | $ | $ | # |
---------------------------------
| # | # | $ | $ | . | . | $ | # |
---------------------------------
| $ | $ | . | . | . | . | $ | $ |
---------------------------------
| . | # | . | . | . | $ | $ | # |
---------------------------------
| # | . | # | . | # | $ | . | . |
---------------------------------
| . | $ | . | . | $ | . | $ | # |
---------------------------------

enter W/A/S/D/Q/I: w

Your enter a common space.
Fortunately, no battle took place.

---------------------------------
| .*| $ | . | . | . | $ | . | . |
---------------------------------
| . | # | . | . | . | $ | . | $ |
---------------------------------
| . | . | # | . | . | $ | $ | # |
---------------------------------
| # | # | $ | $ | . | . | $ | # |
---------------------------------
| $ | $ | . | . | . | . | $ | $ |
---------------------------------
| . | # | . | . | . | $ | $ | # |
---------------------------------
| # | . | # | . | # | $ | . | . |
---------------------------------
| . | $ | . | . | $ | . | $ | # |
---------------------------------

enter W/A/S/D/Q/I: d

Heros enter a market place.

---------------------------------
| . | $*| . | . | . | $ | . | . |
---------------------------------
| . | # | . | . | . | $ | . | $ |
---------------------------------
| . | . | # | . | . | $ | $ | # |
---------------------------------
| # | # | $ | $ | . | . | $ | # |
---------------------------------
| $ | $ | . | . | . | . | $ | $ |
---------------------------------
| . | # | . | . | . | $ | $ | # |
---------------------------------
| # | . | # | . | # | $ | . | . |
---------------------------------
| . | $ | . | . | $ | . | $ | # |
---------------------------------

enter W/A/S/D/Q/I/M: d

Your enter a common space.
Fortunately, no battle took place.

---------------------------------
| . | $ | .*| . | . | $ | . | . |
---------------------------------
| . | # | . | . | . | $ | . | $ |
---------------------------------
| . | . | # | . | . | $ | $ | # |
---------------------------------
| # | # | $ | $ | . | . | $ | # |
---------------------------------
| $ | $ | . | . | . | . | $ | $ |
---------------------------------
| . | # | . | . | . | $ | $ | # |
---------------------------------
| # | . | # | . | # | $ | . | . |
---------------------------------
| . | $ | . | . | $ | . | $ | # |
---------------------------------

enter W/A/S/D/Q/I: s

Your enter a common space.
Fortunately, no battle took place.

---------------------------------
| . | $ | . | . | . | $ | . | . |
---------------------------------
| . | # | .*| . | . | $ | . | $ |
---------------------------------
| . | . | # | . | . | $ | $ | # |
---------------------------------
| # | # | $ | $ | . | . | $ | # |
---------------------------------
| $ | $ | . | . | . | . | $ | $ |
---------------------------------
| . | # | . | . | . | $ | $ | # |
---------------------------------
| # | . | # | . | # | $ | . | . |
---------------------------------
| . | $ | . | . | $ | . | $ | # |
---------------------------------

enter W/A/S/D/Q/I: d

Your enter a common space.
Unfortunately, you encountered a group of monsters.

------------------Round 1:
Hero party at Common Space

Hero Sehanine_Moonbow(Paladin)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold        
1           100         300         750         700         700         7/10        2500        
No items in Inventory.

Monsters

Monster Natsunomeryu
Level       HP          Damage      Defense     Dodge       
1           100         10          0           10%

Hero Sehanine_Moonbow  vs  Monster Natsunomeryu
b-battle, i-info
enter B/I: b
a-attack, c-spell, p-potion, w-equip weapon, r-equip armor
enter A/C/P/W/R: a
Hero Sehanine_Moonbow's attack damage is 37
Monster Natsunomeryu's defense is 0
Hero Sehanine_Moonbow attacked Monster Natsunomeryu for 37 damage!
Monster Natsunomeryu's attack damage is 10
Hero Sehanine_Moonbow's defense is 0
Monster Natsunomeryu attacked Hero Sehanine_Moonbow for 10 damage!

Hero Sehanine_Moonbow  vs  Monster Natsunomeryu
b-battle, i-info
enter B/I: b
a-attack, c-spell, p-potion, w-equip weapon, r-equip armor
enter A/C/P/W/R: a
Hero Sehanine_Moonbow's attack damage is 37
Monster Natsunomeryu's defense is 0
Hero Sehanine_Moonbow attacked Monster Natsunomeryu for 37 damage!
Monster Natsunomeryu's attack damage is 10
Hero Sehanine_Moonbow's defense is 0
Monster Natsunomeryu attacked Hero Sehanine_Moonbow for 10 damage!

Hero Sehanine_Moonbow  vs  Monster Natsunomeryu
b-battle, i-info
enter B/I: b
a-attack, c-spell, p-potion, w-equip weapon, r-equip armor
enter A/C/P/W/R: a
Monster Natsunomeryu dodged Hero Sehanine_Moonbow's attack.
Monster Natsunomeryu's attack damage is 10
Hero Sehanine_Moonbow's defense is 0
Monster Natsunomeryu attacked Hero Sehanine_Moonbow for 10 damage!

Hero Sehanine_Moonbow  vs  Monster Natsunomeryu
b-battle, i-info
enter B/I: b
a-attack, c-spell, p-potion, w-equip weapon, r-equip armor
enter A/C/P/W/R: a
Hero Sehanine_Moonbow's attack damage is 37
Monster Natsunomeryu's defense is 0
Hero Sehanine_Moonbow attacked Monster Natsunomeryu for 37 damage!
Monster Natsunomeryu was defeated.
Monster Natsunomeryu's attack damage is 10
Hero Sehanine_Moonbow's defense is 0
Monster Natsunomeryu attacked Hero Sehanine_Moonbow for 10 damage!
Hero Sehanine_Moonbow regain 6 HP and 30 MP
Hero Sehanine_Moonbow got 100 gold.
Hero Sehanine_Moonbow got 2 experiences.

---------------------------------
| . | $ | . | . | . | $ | . | . |
---------------------------------
| . | # | . | .*| . | $ | . | $ |
---------------------------------
| . | . | # | . | . | $ | $ | # |
---------------------------------
| # | # | $ | $ | . | . | $ | # |
---------------------------------
| $ | $ | . | . | . | . | $ | $ |
---------------------------------
| . | # | . | . | . | $ | $ | # |
---------------------------------
| # | . | # | . | # | $ | . | . |
---------------------------------
| . | $ | . | . | $ | . | $ | # |
---------------------------------

enter W/A/S/D/Q/I: a

Your enter a common space.
Fortunately, no battle took place.

---------------------------------
| . | $ | . | . | . | $ | . | . |
---------------------------------
| . | # | .*| . | . | $ | . | $ |
---------------------------------
| . | . | # | . | . | $ | $ | # |
---------------------------------
| # | # | $ | $ | . | . | $ | # |
---------------------------------
| $ | $ | . | . | . | . | $ | $ |
---------------------------------
| . | # | . | . | . | $ | $ | # |
---------------------------------
| # | . | # | . | # | $ | . | . |
---------------------------------
| . | $ | . | . | $ | . | $ | # |
---------------------------------

enter W/A/S/D/Q/I: w

Your enter a common space.
Fortunately, no battle took place.

---------------------------------
| . | $ | .*| . | . | $ | . | . |
---------------------------------
| . | # | . | . | . | $ | . | $ |
---------------------------------
| . | . | # | . | . | $ | $ | # |
---------------------------------
| # | # | $ | $ | . | . | $ | # |
---------------------------------
| $ | $ | . | . | . | . | $ | $ |
---------------------------------
| . | # | . | . | . | $ | $ | # |
---------------------------------
| # | . | # | . | # | $ | . | . |
---------------------------------
| . | $ | . | . | $ | . | $ | # |
---------------------------------

enter W/A/S/D/Q/I: a

Heros enter a market place.

---------------------------------
| . | $*| . | . | . | $ | . | . |
---------------------------------
| . | # | . | . | . | $ | . | $ |
---------------------------------
| . | . | # | . | . | $ | $ | # |
---------------------------------
| # | # | $ | $ | . | . | $ | # |
---------------------------------
| $ | $ | . | . | . | . | $ | $ |
---------------------------------
| . | # | . | . | . | $ | $ | # |
---------------------------------
| # | . | # | . | # | $ | . | . |
---------------------------------
| . | $ | . | . | $ | . | $ | # |
---------------------------------

enter W/A/S/D/Q/I/M: m

Hero Sehanine_Moonbow's turn(b-buy, s-sell, q-cancel).
enter B/S/Q: b

Welcome to Market.
1. Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1
2. Armor, Name: Platinum_Shield, Price: 150, Level: 1, Damage Reduction: 200
3. Armor, Name: Breastplate, Price: 350, Level: 2, Damage Reduction: 600
4. Potion, Name: Healing_Potion, Price: 250, Level: 1, Effective Amount: 100, Attribute Affected: Health
5. Weapon, Name: Bow, Price: 300, Level: 2, Damage: 500, Hands: 2
6. Armor, Name: Full_Body_Armor, Price: 1000, Level: 2, Damage Reduction: 1100
7. Potion, Name: Strength_Potion, Price: 200, Level: 1, Effective Amount: 75, Attribute Affected: Strength
8. Armor, Name: Wizard_Shield, Price: 1200, Level: 10, Damage Reduction: 1500
9. Weapon, Name: Scythe, Price: 1000, Level: 6, Damage: 1100, Hands: 2
10. Weapon, Name: Axe, Price: 550, Level: 5, Damage: 850, Hands: 1
0. Quit
Your choice: 1
Hero Sehanine_Moonbow bought a Sword

---------------------------------
| . | $*| . | . | . | $ | . | . |
---------------------------------
| . | # | . | . | . | $ | . | $ |
---------------------------------
| . | . | # | . | . | $ | $ | # |
---------------------------------
| # | # | $ | $ | . | . | $ | # |
---------------------------------
| $ | $ | . | . | . | . | $ | $ |
---------------------------------
| . | # | . | . | . | $ | $ | # |
---------------------------------
| # | . | # | . | # | $ | . | . |
---------------------------------
| . | $ | . | . | $ | . | $ | # |
---------------------------------

enter W/A/S/D/Q/I/M: i

Hero party at Market Space

Hero Sehanine_Moonbow(Paladin)
Level       HP          MP          Strength    Dexterity   Agility     EXP         Gold        
1           66          330         750         700         700         9/10        2100        
Inventory: 
Weapon, Name: Sword, Price: 500, Level: 1, Damage: 800, Hands: 1

---------------------------------
| . | $*| . | . | . | $ | . | . |
---------------------------------
| . | # | . | . | . | $ | . | $ |
---------------------------------
| . | . | # | . | . | $ | $ | # |
---------------------------------
| # | # | $ | $ | . | . | $ | # |
---------------------------------
| $ | $ | . | . | . | . | $ | $ |
---------------------------------
| . | # | . | . | . | $ | $ | # |
---------------------------------
| # | . | # | . | # | $ | . | . |
---------------------------------
| . | $ | . | . | $ | . | $ | # |
---------------------------------

enter W/A/S/D/Q/I/M: 
```
