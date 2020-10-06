package week1;

public class GenCount {
    public static boolean isInteger(Object object) {
        if(object instanceof Integer) {
            return true;
        } else {
            String string = object.toString();

            try {
                Integer.parseInt(string);
            } catch(Exception e) {
                return false;
            }
        }
        return true;
    }

    public static <E> void collectionCount(E[] arr ) {
        int palCount = 0;
        int oddNumCount = 0;
        int primeCount = 0;
        for (E elem: arr ) {

            //check if integer
             if (isInteger(elem)){
                 int a = Integer.parseInt(elem.toString());
                 //odd number
                 if (a % 2 != 0){
                     oddNumCount++;
                 }

                 // prime number
                 if (a>1){
                     int i,m=0,flag=0;
                     m=a/2;
                     for(i=2;i<=m;i++){
                         if(a%i==0){
                             flag=1;
                             break;
                         }
                     }
                     if(flag==0)  { primeCount++;}
                 }
             }
             else {

                 String original, reverse = ""; // Objects of String class

                 original = elem.toString();
                 int length = original.length();

                 for (int i = length - 1; i >= 0; i--){
                     reverse = reverse + original.charAt(i);
                }
                 if (original.equals(reverse)) {
                     palCount++;
                 }
             }
        }

        System.out.println("Amount of palindromes are: " + palCount);
        System.out.println("Amount of odd numbers are: " + oddNumCount);
        System.out.println("Amount of prime numbers are: " + primeCount);

    }

    public static void main(String[] args) {

        Integer[] numbers = {1,2,4,7,11};
        String[] text = {"racecar","toast","pain","solos"};

        System.out.println("\nnumbers array");
        collectionCount(numbers);
        System.out.println("\ntext array");
        collectionCount(text);
    }

}
