class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]}); // Start event (negative height for max heap)
            events.add(new int[]{b[1], b[2]});  // End event
        }

        // Sort events: 
        // 1. By x-coordinate (ascending)
        // 2. If same x, process start before end (higher height first)
        events.sort((a, b) -> (a[0] == b[0]) ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        // Max Heap to store active building heights
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0); // Initial ground level

        List<List<Integer>> result = new ArrayList<>();
        int prevHeight = 0;

        // Sweep through the events
        for (int[] e : events) {
            if (e[1] < 0) { 
                maxHeap.add(-e[1]); // Add building height to heap
            } else {
                maxHeap.remove(e[1]); // Remove height from heap
            }

            int currHeight = maxHeap.peek(); // Get max height

            // If height changes, add a new key point
            if (currHeight != prevHeight) {
                result.add(Arrays.asList(e[0], currHeight));
                prevHeight = currHeight;
            }
        }

        return result;
    }
}
     
