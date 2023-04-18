public class HitCounter {

    Queue<Integer> hits;
    /** Initialize your data structure here. */
    public HitCounter() {
        hits = new LinkedList<Integer>();
    }

    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        hits.add(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (hits.size() > 0 && hits.peek() <= timestamp - 300) {
            hits.poll();
        }
        return hits.size();

    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
