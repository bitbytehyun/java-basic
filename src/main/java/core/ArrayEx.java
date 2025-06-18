package core;

public class ArrayEx {
    public void executeDefaultArray() {
        int[] numbers = new int[4];

        numbers[0] = 1;
        numbers[1] = 2;

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }
    }

    public void declareArray() {
        String[] fruits = {"Apple", "Cherry"};

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }

    public void findMax() {
        int[] numbers = {3, 7, 1, 3, 2};
        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println("Max value = " + max);
    }

    public void make2DArray() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
