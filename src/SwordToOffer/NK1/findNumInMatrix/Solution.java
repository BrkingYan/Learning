package SwordToOffer.NK1.findNumInMatrix;

    public class Solution {
        public boolean Find(int target, int[][] array) {
            int vectorLength;
            if (array == null) {
                return false;
            } else {
                if (array.length == 0) {
                    return false;
                }
                vectorLength = array[0].length;
                for (int i = 0; i < array.length; i++) {
                    if (vectorLength != 0) {
                        if (target >= array[i][0] && target <= array[i][vectorLength - 1]) {
                            for (int j = 0; j < vectorLength; j++) {
                                if (array[i][j] == target) {
                                    return true;
                                }
                            }

                        }
                    }
                }
                return false;
            }
        }
    }
