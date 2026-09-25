## 🍊 Rotten Oranges — BFS Approach

### Pattern

**Multi-Source BFS + Grid Traversal**

### Intuition

Each rotten orange can make its adjacent fresh oranges rotten in **1 minute**.

Since there can be **multiple rotten oranges initially**, we put **all rotten oranges into the queue at the beginning**. This is called **Multi-Source BFS**.

We process the queue **level by level**:

* One BFS level = **one minute**
* For every rotten orange, check its **4 adjacent cells**
* If an adjacent cell contains a fresh orange (`1`), make it rotten (`2`) and add it to the queue
* Increase the time only when at least one fresh orange becomes rotten

After BFS finishes:

* If any fresh orange (`1`) is still present → return `-1`
* Otherwise → return the elapsed time

### Steps

1. Traverse the matrix and add every rotten orange to the queue.
2. Define 4 directions: **up, down, left, right**.
3. While the queue is not empty:

   * Store `q.size()` to process the current BFS level.
   * Process all oranges in that level.
   * Rot all valid adjacent fresh oranges and add them to the queue.
   * If at least one orange became rotten, increment the time.
4. Traverse the matrix again.
5. If any fresh orange remains, return `-1`.
6. Otherwise, return the total elapsed time.

### Key Idea

```text
All initially rotten oranges
          ↓
      Queue them
          ↓
      BFS Level 1
          ↓
   Newly rotten oranges
          ↓
      BFS Level 2
          ↓
   Newly rotten oranges
          ↓
         ...
```

**Each BFS level represents exactly one minute.**

### Complexity

* **Time:** `O(n × m)`
* **Space:** `O(n × m)`

### Revision Trick

Whenever a problem says something like:

> "Multiple starting points spread/expand simultaneously"

Think:

**Multi-Source BFS → put all starting points in the queue initially.**
