package contest.weekly.contest303.problem3;

import java.util.*;


/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-24 10:38
 **/
public class FoodRatings {
    class Food {
        String name;
        String cuisine;
        int rating;

        Food(String n, String c, int r) {
            this.name = n;
            this.cuisine = c;
            this.rating = r;
        }
    }

    HashMap<String, PriorityQueue<Food>> cuisineFoods;
    HashMap<String, Food> foodsMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineFoods = new HashMap<>();
        foodsMap = new HashMap<>();
        int n = foods.length;
        for (int i = 0; i < n; i++) {
            Food f = new Food(foods[i], cuisines[i], ratings[i]);
            PriorityQueue<Food> pq = cuisineFoods.getOrDefault(cuisines[i], new PriorityQueue<>(new Comparator<Food>() {
                @Override
                public int compare(Food o1, Food o2) {
                    if (o1.rating != o2.rating) {
                        return o2.rating - o1.rating;
                    } else {
                        return o1.name.compareTo(o2.name);
                    }
                }
            }));
            pq.offer(f);
            cuisineFoods.put(cuisines[i], pq);
            foodsMap.put(foods[i], f);
        }
    }

    public void changeRating(String food, int newRating) {

        Food curr = foodsMap.get(food);
        PriorityQueue<Food> pq = cuisineFoods.get(curr.cuisine);
        pq.remove(curr);
        curr.rating = newRating;

        pq.offer(curr);

    }

    public String highestRated(String cuisine) {
        return cuisineFoods.get(cuisine).peek().name;
    }

}

