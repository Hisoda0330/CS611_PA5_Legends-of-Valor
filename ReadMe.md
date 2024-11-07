Guide,
Required sections: Header, Files, Notes, How to compile and run, I/O Example

# CS611-Assignment 4
## Legends Monsters and Heroes
---------------------------------------------------------------------------

Member:
- Name: Jinpeng Huang
- Email: jinpeng@bu.edu
- Student ID: U19568777

## Files
---------------------------------------------------------------------------
**src:**
1. Game.java: Starts the game

**controller:**

1. Controller.java: Implement main game controller, manages game world, hero creation, movement controls, and game commands. Also plays music and observe message for display.

2. Input.java: Handles user input, prompts user to enter correct type of input, such as integer or character. 

3. MessageObserver.java: Defines an interface for observing messages, respond to messages for display notifications or logs.

4. MusicPlayer.java: PLays background music using audio file music.wav.

**model:**

1. Constants.java: Stores constant stats for the game, such as exp increase percent.

2. Dice.java: Provide methods for handling random events, simulate probability.

3. FileLoader.java: Contains a method to load data from a file to read game data. Loading entities, heros, items, spells, etc..

4. World.java: Represents the game world, modeled as an 8x8 grid with different types of space(inaccessible, market, and common). It initialize the world layout. 

**model/hero/item:**

1. Item.java: Defines an abstract base class for items in game. Each item has a name, price, and level. 

2. ItemFactory.java: Declares an ItemFactory interface for creating specific item instances, providing a way to instantiate different item types consistently.

**model/hero/item/armor:**

1. Armor.java: Defines the armor class, extends Item and implements DefenseAble. Represents how much damage armor reduce.

2. ArmorFactory.java: Implements the ItemFactory interface and provides a factory for creating Armor items. Reads Armory.txt using FileLoader, storing in list of Armor objects.

3. DefenseAble.java: Interface represent item that provide defensive capabilities, like armor.
   
**model/hero/item/potion:**

1. EnhanceAble.java: Interface intended for potions that defines how a potion enhances a hero's attribute.

2. Potion.java: Defines the Potion class, exstends Item and implements EnhanceAble. Potions affect specific hero attributes like health, strength, dexterity, and agility.

3. PotionFactory.java: Implements ItemFactory to create Potion objects. Reads potion data from Potion.txt using FileLoader, storing detail on potions and their attribute effects.
   
**model/hero/item/spell:**

1. FireSpell.java: Extends Spell and represents a fire-based spell, magicAttack method reduces monster's defense.

2. IceSpell.java:Extends Spell and represents a ice-based spell, magicAttack method reduces monster's attack damage.

3. LightningSpell.java:Extends Spell and represents a lightning-based spell, magicAttack method reduces monster's dodge ability.

4. MagicAttackAble.java: An interface with methods that defines behavior for items or abilities that perform magic attacks.

5. Spell.java: An abstract class representing a generic spell, provides attributes for damage and cost, methods for applying magic damage to monster and calculate dmage from hero based on dexterity. 

6. SpellFactory.java: Implements ItemFactory to create Spell objects. It loads spells from IceSpell.txt, FireSpells.txt, LightningSpells.txt, alternates loading spell from each list.
   
**model/hero/item/weapon:**

1. AttackAble.java: An interface that returns the damage value of an attack-capable item, such as weapon.

2. Weapon.java: Represents a weapon item, extends Item and implements Attackable, with attributes for damage and hands. Includes toString() to display weapon details and implement damage.

3. WeaponFactory.java: Implements ItemFactory to create Weapon instances. Loads weapon from Weaponry.txt using FileLoader and store in a list.

**model/market:**

1. Market.java: Represents a market that holds a list of item, provide methods to add, retrieve, and remove items, and display.

2. MarketFactory.java: Defines an interface with a createMarket() method. Generate markets with specific inventories.

3. RandomMarketFactory.java: Implements MarketFacotry to create markets with random items. Generates a market fills with 10 items randomly from WeaponFactory, ArmorFacotry, PotionFactory, and SpellFactory.

**model/space:**

1. CommonSpaceActivity.java: Defines the behavior in a common space where hero may encounter monsters and engage in battles. If battle occurs, it creates a monster group and manages rounds of combat, and rewards in exp and gold if win.
                             The class include methods for battle actions, such as hero attacks, spell casting, using potions, and equipping items.

2. InaccessibleSpaceActivity: Represents an inaccessible space where heroes cannot enter. When attempted, system prompts a message indicating entry not allowed.

3. MarketSpaceActivity: Represents a market space where heroes can buy or sell items.  The marketMenu allows each hero to choose actions and verifies inventory levels, hero levels, and gold availability before transactions.

4. Space.java: Represents a generic space on the game board with attributes for its row, col, type, and an associated SpaceActivity.

5. SpaceActivity.java: An interface for space activities that takes a hero group and triggers actions when they enter a specific space.

**model/user:**

1. User.java: A base class representing users, such as heroes or monsters, with attributes like name, level, and hp. Includes methods for taking damage, healing, leveling up, and managing message notifications for actions, such as receiving damage or leveling up.

2. UserFactory.java: An interface defining a factory for creating User instances. The createUser() method returns a new user, supporting the factory method pattern.

3. UserGroup.java: A generic container for managing a group of User instances (ex. heroes or monsters). It iterates to create hero group and check if user are defeated, and retrieve non-defeated heros for battle.

**model/user/hero:**

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

**model/user/monster:**

1. Dragon.java: It represent Dragon type monsters. It inherits from Monster class and passes its stats(name,level,damage,defense,dodge) to the superclass.

2. Exoskeleton.java: It represent Exoskeleton type monsters. It inherits from Monster class and passes its stats(name,level,damage,defense,dodge) to the superclass.

3. Monster.java: Represents a generic monster with stats for damage, defense, and dodge. It has methods to decrease each attribute by a certain percentage, used when monsters are affected by different types of spells.

4. MonsterFactory.java: Implements UserFactory to create Monster instances. It reads monster data from files such(Dragons.txt, Exoskeletons.txt, Spirits.txt) and filters them based on a specified level.  Also returns monster for appropriate level accroding to heros.

5. MonsterGroup.java: Extends UserGroup to manage a group of monsters, specifically formatting the monster group’s details for display.

6. Spirit.java: It represent Spirit type monsters. It inherits from Monster class and passes its stats(name,level,damage,defense,dodge) to the superclass.

## Notes
---------------------------------------------------------------------------
**Game INFO**



## Program Advantages
---------------------------------------------------------------------------



## How to compile and run
---------------------------------------------------------------------------


1. Navigate to the directory "src" OR (cd src)
2. Run in src dir:
   1. javac *.java
   2. java game.java

## Input/Output Example
---------------------------------------------------------------------------
```

```
