# Union-Find

## Dynamic Connectivity

### Define the problem

Given a set of N objects:

- Union command: connect two objects
- Find/connected query: is there a paht connecting the two objects?

### Modelling the connections

We assume "is connected to" is an equivalence relation:

- Reflexive: _p_ is connected to _p_.
- Symmetric: if _p_ is connected to _q_, then _q_ is connected to _p_.
- Transitive: if _p_ is connected to _q_ and _q_ is connected to _r_, then _p_ is connected to _r_.

**Connected components**: Maximal set of objecst that are mutually connected.

### Implementing the operations

1. _Find query_: Check if two objects are in the same component.
2. _Union command_: Replace components containing two objects with their union.

### Union-find data type (API)

**Goal**: Design an efficient data structure for union-find.

- Number of objects _N_ can be huge.
- Number of operations _M_ can be huge.
- Find queries and union commands may be intermixed.

## Quick-find

1. Data structure:

   - Integer array `id[]` of size _N_.
   - Interpretation: _p_ and _q_ are connected iff they have the same `id`.

2. Find: Check if _p_ and _q_ have the same `id`.

3. Union: To merge components containing _p_ and _q_, change all entries whose `id` equals `id[p]` to `id[q]`.

### Quick-find is too slow

1. Cost model: Number of array accesses (for read or write).

   | algorithm  | initialize | union | find |
   | ---------- | ---------- | ----- | ---- |
   | quick-find | N          | N     | 1    |

2. Quick-find defect: Union is too expensive.

3. Rough standard:

   - 10 ^ 9 operations per second.
   - 10 ^ 9 words of main memory.
   - Touch all words in approximately 1 second.

4. Huge problem for quick-find:

   - 10 ^ 9 union commands on 10 ^ 9 objects.
   - Quick-find takes more than 10 ^ 18 operations, which is 30+ years of computer time!

## Quick-union

1. Data structure:

   - Integer array `id[]` of size _N_.
   - Interpretation: `id[i]` is a parent of `i`.
   - Root of `i` is `id[id[...id[i]...]]`.

2. Find: Check if _p_ and _q_ have the same root.

3. Union: To merge components containing _p_ and _q_, set the `id` of _p_'s root to the `id` of _q_'s root.

### Quick-union is also too slow

1. Cost model: Number of array accesses (for read or write).

   | algorithm   | initialize | union | find |
   | ----------- | ---------- | ----- | ---- |
   | quick-find  | N          | N     | 1    |
   | quick-union | N          | N     | N    |

2. Quick-find defects:

   - Union too expensive (_N_ array accesses).
   - Trees are flat, but too expensive to keep them flat.

3. Quick-union defects:

   - Trees can get tall.
   - Find is too expensive (could be _N_ array accesses).
