# PerfectHash
This is an attempt to create the perfect hash function

The basic Idea is that you create a hash table, but on a collision, instead of merely creating a list
(which can cause seek time to degenerate to O(n) instead you create a new hash table!

By creating a new hash table, your seek time is guarenteed to be O(1) since if there is a collision
in the second table, you re-hash it using a different hash method until you run out of hash methods 
(in which case you expand your table and start over) or you find a hash that distributes your items 
evenly! a perfect hash every time!
