class Solution {
    public long pickGifts(int[] gifts, int k) {
        int n = gifts.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        long sum = 0;
        
        // Adding all the elements in sum and heap.
        for(int i=0; i<n; i++){
            sum += gifts[i];
            pq.add(gifts[i]);
        }

        // This loop will run k times.
        for(int i=0; i<k; i++){
            int val=pq.poll();

            // Subtracting the values of the elements from sum whose 
            // square root we are going to consider in our results.
            sum -= val;

            // converting the value into an integer because square 
            // root can be float
            val=(int)Math.sqrt(val);

            // adding the values of square root, if we need to again
            // apply square roots on these then first these values
            // will be subtracted and their square root will be 
            // added to the sum
            sum += val;

            // add square root to priority queue (heap)
            pq.add(val);
        }

        // return the sum
        return sum;
    }
}