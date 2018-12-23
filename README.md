# Forgetful Villagers

**This mod is for 18w50a ONLY with Fabric mod loader**

This mod does a few very, *very* small zombie villager related things. Most players will not notice or care, but they make all the difference for players who do.

* Zombifying a villager causes them to forget everything besides their profession (reverting a 18w50a change)
  * This happens 100% of the time on Hard, 50% of the time on Normal, and never on Easy
* Zombie villagers have a 100% chance of appearing when a villager is killed by a zombie, regardless of game difficulty.
* Zombified villagers will not despawn naturally (as if nametagged)

Very obviously based on this video by gnembon: https://www.youtube.com/watch?v=UiDRA1tAwWc

### But... why?

Ok. Let's talk about zombie villagers and villager professions.

When zombie villagers were introduced in 1.4.2, there was only one type. All villagers zombified into the same type of zombie villager, and curing this zombie villager essentially spawned a random villager, just like a brand new one from villager breeding. Curing zombie villagers was not really a practical way of getting more villagers, since you might as well just build a villager breeder, it's a lot easier.

1.9, however, added profession variants for zombie villagers. These were largely cosmetic, but had gameplay effects as well - zombifying a villager turned it into the same profession of zombie villager, and curing a zombie villager turned it into the same profession of human villager. Importantly, no other trade-related information about the villager was kept - zombifying and then curing a villager resulted in a brand new set of trades but for the same profession type.

This odd mechanic actually allowed for a neat alternative/supplement to villager breeders. Using this feature, it was possible to "reroll" unwanted villagers into different villagers *of the same profession*. A cured zombie villager might have different trade costs. A cured librarian's enchanted book might be different, or maybe would have flip-flopped between Cartographer and Librarian.

However, a 1.14 snapshot 18w50a (unintentionally) removed this game mechanic. The snapshot made villagers retain *all* of their trade information when zombifying; zombifying and curing a villager simply results in the exact same villager with the exact same trade set. It is not possible to reroll a villager of the same profession; players must resort to villager breeding once again.

### Why different behavior on different difficulties?

Each behavior is desirable under different circumstances by different people.

A player playing on Easy is more likely to be inexperienced. They might not have created a villager breeder or even know how village population mechanics work, and if they have a favorite villager they like to trade with, they might not have protected them properly.

To them, losing an important villager and not being able to get them back is a big setback. Having villagers remember their trades means that this player can cure their villager and have the same trades available to them. (Of course, in real life without this mod, the villager would probably just despawn)

A player playing on Hard is more likely to be experienced and interested in things like villager breeders. The "rerolling" effect caused by zombifying and curing a villager provides an interesting gameplay alternative to a villager breeder. The advantage of being able to choose the villager profession is balanced out by a higher cost to run (one golden apple per villager!), and a logistical challenge of repeatedly zombifying and curing villagers without killing all of the villagers. Having villagers forget their trades when zombified is the only thing allowing this mechanic to happen.

This player is also more likely to properly secure their villagers and have the know-how to produce more if needed, so losing a favorite villager will not be as much of a setback.

### TL;DR

18w50a (1.14) made villagers remember their trades when converted into a zombie villager, which has its benefits especially for inexperienced players, but breaks an advanced villager breeder design caused by a side effect of 1.9's cosmetic zombie villager profession variants, that, balanced by a higher cost to run, allows for choosing the profession of villager to be created; this mod adds the feature back for players on Hard difficulty, who are more likely to appreciate it.

### License

Mozilla Public License 2.0 or any later version