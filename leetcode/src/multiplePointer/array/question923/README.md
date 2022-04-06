# Question

Given an integer array `arr`, and an integer `target`, return the number of tuples `i, j, k` such that `i < j < k` and `arr[i] + arr[j] + arr[k] == target`.

As the answer can be very large, return it **modulo** `109 + 7`.

# Ideas

Look back to `Two Sum`, we use two pointers, initialized as the head and tail pointer, solve the question in linear time.

In `Three Sum`, for each `i`, set `T = target - A[i]`, the remaining target. We can try using a two-pointer technique to find `A[j] + A[k] == T`. This approach is the natural continuation of trying to make the two-pointer technique we know from previous problems, work on this problem.

Because some elements are duplicated, we have to be careful. In a typical case, the target is say, `8`, and we have a remaining array (`A[i+1:]`) of `[2,2,2,2,3,3,4,4,4,5,5,5,6,6]`. We can analyze this situation with cases.

Whenever `A[j] + A[k] == T`, we should count the multiplicity of `A[j]` and `A[k]`. In this example, if `A[j] == 2` and `A[k] == 6`, the multiplicities are `4` and `2`, and the total number of pairs is `4 * 2 = 8`. We then move to the remaining window `A[j:k+1]` of `[3,3,4,4,4,5,5,5]`.

As a special case, if `A[j] == A[k]`, then our manner of counting would be incorrect. If for example the remaining window is `[4,4,4]`, there are only 3 such pairs. In general, when `A[j] == A[k]`, we have `M*(M-1)/2` pairs, M is the miltiplicity of `A[j]`.



