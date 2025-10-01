class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drinkedBtl=0;
        int emptyBtl=0;  //empty bottles

        while(numBottles>0){
            drinkedBtl +=numBottles; //drink all current bottles
            emptyBtl +=numBottles; //get empty bottles

            numBottles = emptyBtl/numExchange; //exchange empties for new bottles
            emptyBtl %= numExchange;  //remaining empties
        }
        return drinkedBtl;
    }
}
