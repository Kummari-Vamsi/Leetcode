class Solution {
    public int differenceOfSums(int n, int m) {
        int totalSum = (n * (n + 1)) / 2;
        int k = n / m;
        int sumMultiplesOfM = m * k * (k + 1) / 2;
        int num1 = totalSum - sumMultiplesOfM;
        int num2 = sumMultiplesOfM;
        return num1 - num2;
    }
}