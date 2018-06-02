import java.util.*;

public class TasksOnArrayList {

    public static ArrayList<String> createArrayList(int len){
        ArrayList<String> arr = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < len ; i++) {
            System.out.print("\nEnter the line:");
            String line = scan.nextLine();
            arr.add(line);
        }

        return arr;
    }

    public static ArrayList<String> findShortestElem (ArrayList<String> arr){

        ArrayList<String> arr2 = new ArrayList<String>();
        int min = Integer.MAX_VALUE;
        for (String elem: arr) {
            if(elem.length()<= min){
                if(elem.length()==min)arr2.add(elem);
                else{
                    arr2 = new ArrayList();
                    arr2.add(elem);
                    min = elem.length();
                }

            }
        }

        return arr2;
    }

    public static void printArrayList(ArrayList<String> arr){
        System.out.print("\nResult:");
        for (String elem:arr) {
            System.out.println(elem);
        }
    }

    public static void deleteDublicates (String line) {

        Set<Character> set = new LinkedHashSet<>();


        char[] elements = line.toCharArray();
        for (int i = 0; i < elements.length; i++) {
            if (isDigit(Character.toString(elements[i])))set.add(elements[i]);
        }


        Character [] arr = new Character[set.size()];
        set.toArray(arr);
        System.out.print("Result: ");
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]);
            if(i!=arr.length-1)
                System.out.print(", ");
        }
    }

    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Task#5 Создаем список(ArrayList) строк, считываем 5 строк с клавиатуры и добавляем их в список, затем находим самую короткую строку и выводим её на экран. Если таких строк несколько — выводим их все, каждую с новой строки.");
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter the array length:");
        int len = scan.nextInt();
        System.out.print("\n");
        printArrayList(findShortestElem(createArrayList(len)));

        System.out.println("\nTask#6 Пользователь вводит(через консоль) набор чисел в виде одной строки например (“1, 2, 3, 4, 4, 5”). Избавиться от повторяющихся элементов в строке и вывести результат на экран. Сделать проверку - если пользователь ввел 3 или меньше чисел, предложить ввести числа еще раз пока не будет больше 3х чисел.");
        scan = new Scanner(System.in);
        System.out.print("\nEnter the numbers array in one line:");
        String line;
        int counter;

        do{
            counter = 0;
            line = scan.nextLine();
            char[] elements = line.toCharArray();

            for (int i = 0; i < elements.length; i++) {
                if (isDigit(Character.toString(elements[i]))) counter++;
            }
            if(counter<=3) System.out.print("\nThe array is too short. Please enter array with more numbers:");
        }while (counter<=3);

        System.out.print("\n");
        deleteDublicates(line);

    }
}
