# Question

Give a list of takeoff and landing times of the aircraft, expressed by sequence interval Please calculate the maximum number of planes in the sky at the same time.

# Solution

## Prefix

Plus one airplance at the takeoff time and substract one airplane at landing time, calculate the prefix, which represents the number of plane at corresponding time.

## Scanline

Sort the plane by takeoff time, the airplane which lands at earlier time is sorted at front.

Scan the list, result is the maximum airplance number.