package geeksforgeeks.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergerOverlapInterval {
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(0,new Interval(6, 8));
        intervals.add(0,new Interval(1, 9));
        intervals.add(0,new Interval(2, 4));
        intervals.add(0,new Interval(4, 7));

        new MergerOverlapInterval().merge(intervals);
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        // sort the list
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start-i2.start;
            }
        });
        int index = 0;  // Stores index of last element

        for(int i=0;i<intervals.size();i++)
        {

            // If this is not first Interval and overlaps with the previous one
            if (intervals.get(index).end >=  intervals.get(i).start)
            {
                // Merge previous and current Intervals
                intervals.get(index).end = Math.max(intervals.get(index).end, intervals.get(i).end);
                intervals.get(index).start = Math.min(intervals.get(index).start, intervals.get(i).start);
            }
            else {
                index++;
                intervals.add(index,intervals.get(i));
            }
        }
        ArrayList<Interval> output = new ArrayList<>();
        for (int i = 0; i <= index; i++)
        {
            System.out.print("[" + intervals.get(i).start + ","
                    + intervals.get(i).end + "]");

            // or optionally adding in o/p list
            output.add(i, new Interval(intervals.get(i).start,intervals.get(i).end));
        }

        return  output;
    }
}

