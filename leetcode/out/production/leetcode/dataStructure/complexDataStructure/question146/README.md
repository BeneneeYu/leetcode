1. 双链表中实现的方法：
   - 链表初始化
   - 添加元素到双链表尾部（同时意味着该元素最近使用过）
   - 删除某个结点（非头结点）
   - 删除并返回头结点（意味着移除最久未使用过的元素）
   - 返回链表当前长度
2. LRU 缓存中的方法
   - 初始化，get，put方法
   - 设置某元素最近已使用makeRecently（原map中已有该元素）
   - 添加最近使用过的元素addRecently（原map中不存在该键值对，新元素）
   - 删除某个key对应的元素
   - 删除最久未使用过的元素 2.中的方法也可以直接在get和put方法中实现，可以减少部分冗余

Map<Integer, DLinkedNode> cache is designed to save the key-value mapping from Integer key to node in double linked list, so that when 'put' and 'get', we can complete the operations in O(N) time.

DLinkedNode head, tail are dummy nodes, they record the head and tail and enable the program to operate all the nodes in the linked list. It enables the replacement because we can not memorize the access sequence in map.



