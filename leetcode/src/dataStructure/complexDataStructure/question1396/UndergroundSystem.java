package dataStructure.complexDataStructure.question1396;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-17 12:48
 **/
public class UndergroundSystem {
    class Start {
        String startStation;
        int startTime;

        public Start(String startStation, int startTime) {
            this.startStation = startStation;
            this.startTime = startTime;
        }
    }

    class Route {
        String startStation;
        String endStation;

        public Route(String startStation, String endStation) {
            this.startStation = startStation;
            this.endStation = endStation;
        }

        public int hashCode() {
            return (startStation + endStation).hashCode();
        }

        public boolean equals(Object obj2) {
            if (obj2 instanceof Route) {
                Route route2 = (Route) obj2;
                return this.startStation.equals(route2.startStation) && this.endStation.equals(route2.endStation);
            }
            return false;
        }
    }

    class SumAmount {
        int sum;
        int amount;

        public SumAmount(int sum, int amount) {
            this.sum = sum;
            this.amount = amount;
        }

        public double getAverage() {
            return (double) (sum) / amount;
        }
    }

    HashMap<Integer, Start> startInfo;
    HashMap<Route, SumAmount> table;

    public UndergroundSystem() {
        startInfo = new HashMap<>();
        table = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        Start s = new Start(stationName, t);
        startInfo.put(id, s);
    }

    public void checkOut(int id, String stationName, int t) {
        Start s = startInfo.get(id);
        Route r = new Route(s.startStation, stationName);
        SumAmount sumAmount = table.getOrDefault(r, new SumAmount(0, 0));
        sumAmount.amount += 1;
        sumAmount.sum += t - s.startTime;
        table.put(r, sumAmount);
    }

    public double getAverageTime(String startStation, String endStation) {
        Route route = new Route(startStation, endStation);
        return table.get(route).getAverage();
    }

}
/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */