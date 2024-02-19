class RandomNumberGenerator {

    public static boolean checkIfPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int totalNumbers = 1000000;

        // Run the counting process 5 times using a while loop
        int loopCount = 0;
        while (loopCount < 5) {
            int primeCount = 0;
            int nonPrimeCount = 0;

            // Record the start time of the loop in nanoseconds
            long startTime = System.nanoTime();

            for (int i = 0; i < totalNumbers; i++) {
                // Generate a 7-digit number digit by digit using nanoseconds
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 7; j++) {
                    long nanos = System.nanoTime();
                    int digit = (int) (nanos % 10);
                    sb.append(digit);
                }
                String numberString = sb.toString();
                int number = Integer.parseInt(numberString);

                // Check if the generated number is prime
                if (checkIfPrime(number)) {
                    primeCount++;
                } else {
                    nonPrimeCount++;
                }
            }

            // Record the end time of the loop in nanoseconds
            long endTime = System.nanoTime();
            long duration = endTime - startTime; // Time taken in nanoseconds

           
	    System.out.println("loop " + (loopCount + 1) + ":");
            System.out.println("prime numbers" + primeCount);
            System.out.println("composite numbers: " + nonPrimeCount);
            System.out.println("time taken is  " + duration + " nanoseconds\n");

            loopCount++;
        }
    }
}

