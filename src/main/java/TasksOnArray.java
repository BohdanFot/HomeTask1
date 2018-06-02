import java.util.*;


public class TasksOnArray {


    public static String printArr(int[] arr){
        String arrayInStr = Integer.toString(arr[0]);
        for(int i = 1; i<arr.length; i++){
            arrayInStr += ", " + Integer.toString(arr[i]);
        }
        return arrayInStr;

    }

    public static int[] createRandArr(int len, int bound){

        Random ran = new Random();
        int[] arr = new int[len];
        for(int i =0; i<len;i++){
            arr[i] = ran.nextInt(bound)-1;
        }
        return arr;
    }

    public static void createArrOfOdd(int len){
        int[] numbers = new int[len];
        int i = 0, j = 0;
        while(j<len){
            i++;
            if((i%2)!=0){
                numbers[j] = i;
                j++;
            }
        }
        System.out.print("Array ---> " + printArr(numbers));

    }

    public static void swapMaxMin(int len){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, minAmount = 0, maxAmount = 0, temp;
        int[] arr = createRandArr(len,100);
        ArrayList<Integer> minInd = new ArrayList<Integer>();
        ArrayList<Integer> maxInd = new ArrayList<Integer>();

        System.out.println("\nInitial array ---> " + printArr(arr));

        for (int i = 0; i<arr.length;i++) {
            if(arr[i] <= min) {
                if (arr[i] == min) minInd.add(i);
                else {
                    minInd = new ArrayList();
                    minInd.add(i);
                    min = arr[i];
                }
            }
            if(arr[i]>=max){
                if(arr[i]==max)maxInd.add(i);
                else {
                    maxInd = new ArrayList();
                    maxInd.add(i);
                    max = arr[i];
                }
            }
        }

        if((minInd.size() == maxInd.size()) && (max!=min))
        {
            for (int i = 0; i < minInd.size(); i++) {
                arr[minInd.get(i)] = max;
            }

            for (int i = 0; i < maxInd.size(); i++) {
                arr[maxInd.get(i)] = min;
            }
            System.out.print("\nResult ---> " + printArr(arr));
        }
        else{
            System.out.println("The amount of the min and max elements isn't equal OR all elements in the array are equal. Creating a new array...");
            swapMaxMin(len);
        }

    }

    public static void findAverage(int len){
        int sum=0;
        int[] arr = createRandArr(len,28);
        System.out.println("\nInitial array ---> " + printArr(arr));
        for (int elem:arr) {
            sum+=elem;
        }

        System.out.print("\nResult ---> " + sum/arr.length);
    }


    public static void popularNum(int len){
        int minusCounter=0,zeroCounter = 0, plusCounter = 0, max = Integer.MIN_VALUE;
        int[] arr = createRandArr(len, 3);
        System.out.println("\nInitial array ---> " + printArr(arr) + "\n");

        for (int elem:arr) {
            switch (elem){
                case -1: minusCounter++;
                    break;
                case 0: zeroCounter++;
                    break;
                case 1: plusCounter++;
                    break;
            }
        }
        int[][] mostPopNum = {{-1,0,1},{minusCounter,zeroCounter,plusCounter}};

        for (int i = 0; i < mostPopNum[0].length; i++) {
            if(mostPopNum[1][i] > max) max = mostPopNum[1][i];
        }

        for (int i = 0; i < mostPopNum[0].length; i++) {
            if(mostPopNum[1][i] == max)System.out.println("Element = " + mostPopNum[0][i] + ". Count = " + mostPopNum[1][i] + ".");
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len;
        System.out.println("Task №1: Создайте массив, содержащий N первых нечетных чисел. Выведете элементы массива на консоль в одну строку, разделяя запятой\n");
        System.out.print("Enter the array length:");
        len = scan.nextInt();
        createArrOfOdd(len);

        System.out.println("\n\nTask №2: Поменять наибольший и наименьший элементы массива местами. Пример: дан массив {3, -7, 0, 6, 9}.  После замены будет выглядеть {3, 9, 0, 6, -7}.\n");
        System.out.print("Enter the array length:");
        len = scan.nextInt();
        while(len<=1){
            System.out.print("The length is too short.Enter the array length:");
            len = scan.nextInt();
        }
        swapMaxMin(len);

        System.out.println("\n\nTask №3: Найти среднее арифметическое всех элементов массива.\n");
        System.out.print("Enter the array length:");
        len = scan.nextInt();
        findAverage(len);

        System.out.println("\n\nTask №4: Создайте массив из 13 случайных целых чисел из отрезка [-1;1], выведите массив на экран в строку. Определите какой элемент встречается в массиве чаще всего и выведите об этом сообщение на экран (element + count).\n");
        System.out.print("Enter the array length:");
        len = scan.nextInt();
        popularNum(len);

    }
}
