package dataStructure.complexDataStructure.question981;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-16 21:20
 **/
public class TimeMap {
    private class TimestampValuePair {
        int stamp;
        String val;

        public TimestampValuePair(int stamp, String val) {
            this.stamp = stamp;
            this.val = val;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }

        public int compareTo(TimestampValuePair pair2) {
            if (this.stamp != pair2.stamp) {
                return this.stamp - pair2.stamp;
            } else {
                return this.val.compareTo(pair2.val); // 127 trick
            }
        }
    }

    Map<String, List<TimestampValuePair>> map;

    public TimeMap() {
        map = new HashMap<String, List<TimestampValuePair>>();
    }

    public void set(String key, String value, int timestamp) {
        List<TimestampValuePair> pairs = map.getOrDefault(key, new ArrayList<TimestampValuePair>());
        pairs.add(new TimestampValuePair(timestamp, value));
        map.put(key, pairs);
    }

    public String get(String key, int timestamp) {
        List<TimestampValuePair> pairs = map.getOrDefault(key, new ArrayList<TimestampValuePair>());
        TimestampValuePair pair = new TimestampValuePair(timestamp, String.valueOf((char) 127)); // according to dictionary order, even if timestamp exists, will return position behind
        int i = binarySearch(pairs, pair); // the index of the first element that has later stamp than target
        if (i > 0) {
            return pairs.get(i - 1).getVal();
        }
        return "";
    }

    // search the index of the first element that has later stamp than target
    private int binarySearch(List<TimestampValuePair> pairs, TimestampValuePair target) {
        int low = 0, high = pairs.size() - 1;
        if (high < 0 || pairs.get(high).compareTo(target) <= 0) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            TimestampValuePair pair = pairs.get(mid);
            if (pair.compareTo(target) <= 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
