# Question

An underground railway system is keeping track of customer travel times between different stations. They are using this data to calculate the average time it takes to travel from one station to another.

Implement the `UndergroundSystem` class:

- ```
  void checkIn(int id, string stationName, int t)
  ```

  - A customer with a card ID equal to `id`, checks in at the station `stationName` at time `t`.
  - A customer can only be checked into one place at a time.

- ```
  void checkOut(int id, string stationName, int t)
  ```

  - A customer with a card ID equal to `id`, checks out from the station `stationName` at time `t`.

- ```
  double getAverageTime(string startStation, string endStation)
  ```

  - Returns the average time it takes to travel from `startStation` to `endStation`.
  - The average time is computed from all the previous traveling times from `startStation` to `endStation` that happened **directly**, meaning a check in at `startStation` followed by a check out from `endStation`.
  - The time it takes to travel from `startStation` to `endStation` **may be different** from the time it takes to travel from `endStation` to `startStation`.
  - There will be at least one customer that has traveled from `startStation` to `endStation` before `getAverageTime` is called.

You may assume all calls to the `checkIn` and `checkOut` methods are consistent. If a customer checks in at time `t1` then checks out at time `t2`, then `t1 < t2`. All events happen in chronological order.

# Design

Two hashmaps.

The first Hashmap saves the `id` of passenger as key, and the `stationName` and `checkInTime` as value.

The second Hashmap saves a route pair from `startStation` to `endStation` as key, and `numOfPassenger` and `totalTravelTime` as value.

# Operations

- checkIn: save data in the first Hashmap.
- checkOut: Retrieve from the first Hashmap and update the second HashMap.

Pair class is more elegant than string appending.