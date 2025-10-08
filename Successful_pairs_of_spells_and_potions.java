class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];
        for (int i=0; i<n; i++) {
            int spell = spells[i];
            if ((long)spell * potions[0] >= success) {  // check first element if greater then success means all are greater then success
                result[i] = m;
                continue;
            }
            if ((long)spell * potions[m - 1] < success) { // check last element if last element not greater then success means all not
                result[i] = 0;
                continue;
            }
            int start = 0;
            int end = m - 1;
            int index = -1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                int potion = potions[mid];
                if ((long)potion * (long)spell >= success) { // if greater then mid then check previous element
                    index = mid;
                    end = mid - 1;
                } else { //if less then mid then check next element
                    start = mid + 1;
                }
            }
            result[i] = m - index;
        }

        return result;
    }
}
