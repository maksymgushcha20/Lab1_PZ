// Lab1
// ІО-23
//Гуща Максим

//ВАРІАНТ\\
// C5 = 2309 / 5 = (4) | C = A * B
// C7 = 2309 / 7 = (6) | float
// C11 = 2309 / 11 = (10) | Знайти середнє значення елементів матриці

import java.util.Random;

class MatrixOperations {
    private float[][] matrixA;
    private float[][] matrixB;
    private float[][] matrixC;

    public MatrixOperations(int size) {
        // Генерація матриць A і B з випадковими значеннями
        matrixA = generateRandomMatrix(size);
        matrixB = generateRandomMatrix(size);
        matrixC = new float[size][size];
    }

    private float[][] generateRandomMatrix(int size) {
        float[][] matrix = new float[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextFloat() * 100; // Заповнення матриці випадковими числами
            }
        }
        return matrix;
    }

    public void multiplyMatrices() {
        int size = matrixA.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixC[i][j] = 0;
                for (int k = 0; k < size; k++) {
                    matrixC[i][j] += matrixA[i][k] * matrixB[k][j]; // Обчислення елементів матриці C
                }
            }
        }
    }

    public float calculateAverage() {
        int size = matrixC.length;
        float sum = 0;
        for (float[] row : matrixC) {
            for (float element : row) {
                sum += element; // Сумування усіх елементів матриці C
            }
        }
        return sum / (size * size); // Обрахунок середнього значення
    }

    public void displayMatrix(float[][] matrix) {
        for (float[] row : matrix) {
            for (float element : row) {
                System.out.printf("%.2f ", element);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void execute() {
        try {
            System.out.println("Матриця A:");
            displayMatrix(matrixA);
            System.out.println("Матриця B:");
            displayMatrix(matrixB);

            multiplyMatrices();
            System.out.println("Матриця C (A * B):");
            displayMatrix(matrixC);

            float average = calculateAverage();
            System.out.println("Середнє значення елементів матриці C: " + average);
        } catch (Exception e) {
            System.out.println("Виникла помилка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

public class Lab1 {
    public static void main(String[] args) {
        MatrixOperations matrixOps = new MatrixOperations(3); // розмір матриці можна змінювати, для зручності залишаю розмір 3
        matrixOps.execute();
    }
}

//Як невеличкий висновок: було створено програму, яка генерує матриці, значення яких є типами float, виводить результат множення цих матриць + середнє значення елементів матриці, отриманої після множення.
//Тип float трішки ускладнював перевірку результатів множення на якомусь електронному калькуляторі) Але загалом результати сходяться.
//Середнє значення також сходиться у межах похибки.
//Не знаю, що мається на увазі від "інструкціями", додано кілька головних коментарів.