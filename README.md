This project is a prototype of N-way set associate Cache.

When get the value with the key from the cache
• The key is hashed by the size of the cache;
• Find the store that the key in;
• Get the value associate with the key;
• Update the state of the key and the store by the eviction strategy if needs.
o E.g. For LRU strategy, each time after hit the entry, the entry moves to the head of the store, indicate it’s the most recently used.
o E.g. For other strategy, could use the attributes of the entry to compare and update such like creation time or hit count.
When put a new entry (key, value) to the cache
• If the store has vacancy, which means the size of the store haven’t reached the max capacity, put the entry as the eviction strategy defined;
o E.g. For LRU strategy, put the new entry to the head of the store.
• If the store is full, which means there is no room for the new entry, replace one
entry in the store by the new entry as the eviction strategy defined.
o E.g. For LRU strategy, remove the last entry (least recently used) in the store,
then add the new entry to the head of the store.
Eviction Strategy
Consider the user could create customized eviction strategy, the eviction strategy interface provides three methods:
• Update the entry state after the entry got hit by calling {@code}xcache.get(key).
• Put the entry into the store when there is room.
• Evict an entry and put the new entry when the store is full.