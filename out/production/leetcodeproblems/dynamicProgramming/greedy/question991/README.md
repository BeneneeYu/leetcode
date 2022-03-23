# Question

There is a broken calculator that has the integer `startValue` on its display initially. In one operation, you can:

- multiply the number on display by `2`, or
- subtract `1` from the number on display.

Given two integers `startValue` and `target`, return *the minimum number of operations needed to display* `target` *on the calculator*.

# Ideas

If with subtraction and multiplication, the effect of earlier subtraction will be amplified by later multiplications, hence, greedily doing multiplication might not reach optimal solution as an additional early subtraction can have a huge effect.
Whereas with addition and division, earlier addition will be diminished by later divisions. It is thus always better to do division wherever possible.

Instead of multiplying by 2 or subtracting 1 from `startValue`, we could divide by 2 (when `target` is even) or add 1 to `target`.

The motivation for this is that it turns out we always greedily divide by 2:

- If say `target` is even, then if we perform 2 additions and one division, we could instead perform one division and one addition for less operations [`(target + 2) / 2` vs `target / 2 + 1`].
- If say `target` is odd, then if we perform 3 additions and one division, we could instead perform 1 addition, 1 division, and 1 addition for less operations [`(target + 3) / 2` vs `(target + 1) / 2 + 1`].