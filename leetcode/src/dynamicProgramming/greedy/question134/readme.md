# Problem

There are `n` gas stations along a circular route, where the amount of gas at the `ith` station is `gas[i]`.

You have a car with an unlimited gas tank and it costs `cost[i]` of gas to travel from the `ith` station to its next `(i + 1)th` station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays `gas` and `cost`, return *the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return* `-1`. If there exists a solution, it is **guaranteed** to be **unique**

# Solution

## Brute Force

```java
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        if (length != cost.length) return -1;
        s: for (int i = 0; i < length; i++) { // Select every station as start point.
            int gasLeft = 0;
            if (gas[i] == 0) continue;
            gasLeft = gas[i];
            for (int j = 0; j < length; j++) { // Try to reach other stations.
                gasLeft -= cost[(i + j) % length];
                if (gasLeft < 0) continue s;
                gasLeft += gas[(i + j + 1) % length];
            }
            return i;
        }
        return -1;
    }
```

## Optimized

```java
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentStation = 0;
        int validStation = 0;
        int gasRemaining = 0;
        int gasRemainingPrevious = 0;
        while (currentStation < gas.length) {
            gasRemaining += gas[currentStation] - cost[currentStation];
            if (gasRemaining < 0) {
                validStation = currentStation + 1; // The reason why we assume currentStation + 1 as valid station is that we found that every station skipped can not be used as a start point.
                gasRemainingPrevious += gasRemaining;
                gasRemaining = 0;
            }
            currentStation++;
        }
        // GasRemainingPrevious is the consumption from the 0-index position in the array.
        if (gasRemainingPrevious + gasRemaining < 0)
            return -1;
        else // Can afford.
            return validStation;
    }
```

