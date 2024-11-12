public class MergeSort {

    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;

            // Dividir el arreglo en dos mitades
            int[] left = new int[mid];
            int[] right = new int[array.length - mid];

            System.arraycopy(array, 0, left, 0, mid);
            System.arraycopy(array, mid, right, 0, array.length - mid);

            // Llamadas recursivas a mergeSort en cada mitad
            mergeSort(left);
            mergeSort(right);

            // Mezclar las dos mitades ordenadas
            merge(array, left, right);
        }
    }

    private static void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        // Copiar elementos restantes de left
        while (i < left.length) {
            result[k] = left[i];
            i++;
            k++;
        }

        // Copiar elementos restantes de right
        while (j < right.length) {
            result[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Arreglo original: ");
        printArray(array);

        mergeSort(array);

        System.out.println("Arreglo ordenado: ");
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

