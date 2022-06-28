# Question

There are `n` different online courses numbered from `1` to `n`. You are given an array `courses` where `courses[i] = [durationi, lastDayi]` indicate that the `ith` course should be taken **continuously** for `durationi` days and must be finished before or on `lastDayi`.

You will start on the `1st` day and you cannot take two or more courses simultaneously.

Return *the maximum number of courses that you can take*.

# Idea

Take courses that has the least duration and the earliest deadline to take the maximum number of courses.

For `(t1, d1)`, `(t2, d2)`, if `d1 <= d2`, take course1 at first because:

- take course1 at first: `x+t1 <= d1 && x+t1+t2 <= d2`
- take course2 at first: `x+t2 <= d2 && x+t1+t2 <= d1`

If `x+t2+t1 <= d1` is true, cause `d1 <= d2`, `x+t1+t2 <= d2` is true. Otherwise, it is not always true.

Therefore, we can sort all the courses in ascending order according to the closing time `d`, and then select the courses in turn and study in order.

If we can learn course `i`,  we can directly add this course to the scheme. Otherwise, we can replace the course with the current course, which has the longest duration and is longer than this course. This will leave more remaining time.

# Solution

Use priority queue.

Sort at first, traverse all the courses, maintain the priority queue. At last, count elements number.