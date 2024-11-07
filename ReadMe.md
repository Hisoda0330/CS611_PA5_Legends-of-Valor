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
   
1. Battle.java:

2. Constants.java: Stores constant stats for the game, such as exp increase percent.

3. Dice.java: Provide methods for handling random events, simulate probability.

4. FileLoader.java: Contains a method to load data from a file to read game data. Loading entities, heros, items, spells, etc..

5. World.java: Represents the game world, modeled as an 8x8 grid with different types of space(inaccessible, market, and common). It initialize the world layout. 

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
1. AttackAble.java:

2. Weapon.java:

3. WeaponFactory.java: 

**model/market:**
1. Market.java:

2. MarketFactory.java:

3. RandomMarketFactory.java:

**model/space:**
1. CommonSpaceActivity.java:

2. InaccessibleSpaceActivity:

3. MarketSpaceActivity:

4. Space.java:

5. SpaceActivity.java:

**model/user:**
1. User.java:

2. UserFactory.java:

3. UserGroup.java:

**model/user/hero:**
1. Hero.java:

2. HeroFactory.java:

3. HeroGroup.java:

4. HeroIncreaseStrategy.java:

5. Inventory.java:

6. Paladin.java:

7. PaladinSkillIncreaseStrategy.java:

8. Sorcerer.java:

9. SorcercerSkillIncreaseStrategy.java:

10. Warrior.java:

11. WarriorSkillIncreaseStrategy.java:

**model/user/monster:**
1. Dragon.java:

2. Exoskeleton.java:

3. Monster.java:

4. MonsterGroup.java:

5. Spirit.java:

## Notes
---------------------------------------------------------------------------



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
