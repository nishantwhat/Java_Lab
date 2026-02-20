import java.util.Scanner;

public class MainVector {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter dimension (2 or 3): ");
            int dim = sc.nextInt();

            if (dim != 2 && dim != 3) {
                throw new VectorException("Only 2D or 3D vectors allowed.");
            }

            double[] arr1 = new double[dim];
            double[] arr2 = new double[dim];

            System.out.println("Enter components of Vector 1:");
            for (int i = 0; i < dim; i++) {
                arr1[i] = sc.nextDouble();
            }

            System.out.println("Enter components of Vector 2:");
            for (int i = 0; i < dim; i++) {
                arr2[i] = sc.nextDouble();
            }

            Vector v1 = new Vector(arr1);
            Vector v2 = new Vector(arr2);

            System.out.println("\nVector 1: " + v1);
            System.out.println("Vector 2: " + v2);

            int choice;

            do {

                System.out.println("\nChoose Operation:");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Dot Product");
                System.out.println("4. Exit");

                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        Vector addResult = v1.add(v2);
                        System.out.println("Result Vector: " + addResult);
                        System.out.print("New Array Created: ");
                        addResult.displayArray();
                        break;

                    case 2:
                        Vector subResult = v1.subtract(v2);
                        System.out.println("Result Vector: " + subResult);
                        System.out.print("New Array Created: ");
                        subResult.displayArray();
                        break;

                    case 3:
                        double dotResult = v1.dot(v2);
                        System.out.println("Dot Product: " + dotResult);
                        break;

                    case 4:
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } while (choice != 4);

        } catch (VectorException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
