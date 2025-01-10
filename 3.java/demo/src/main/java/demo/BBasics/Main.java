package demo.BBasics;

public class Main {
    public static void main(String[] args) {
        /*int a = 10; //primitive data type. Stack memory.
        int b = a; // copies the data.
        b = 15; // does not change the value of a.
        System.out.println(a);
        System.out.println(b);

        String name = "John"; //reference data type. Heap memory.
        int[] arr = {1, 2, 3};
        int[] ref = arr;
        ref[0] = 100;
        System.out.println(arr[0]);
        System.out.println(ref[0]);*/

        // ++ --
        /*int i = 10;
        int result = ++i; // pre-increment
        int result2 = i++; // post-increment
        System.out.println(i);
        System.out.println(result);
        System.out.println(result2);*/

        /*for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }*/

        /*int num = 100;
        long l = num;
        System.out.println(l);*/

        /*double d = 100.05;
        int num = (int)d;
        System.out.println(num);*/ //truncated

        /*String intstring = "123";
        int num = Integer.parseInt(intstring);
        System.out.println(num);

        String doublestring = "123.45";
        double d = Double.parseDouble(doublestring);
        System.out.println(d);

        String booleanstring = "true";
        boolean b = Boolean.parseBoolean(booleanstring);
        System.out.println(b);*/

        //Basics Lab
        int age = 30;
        String name = "David";
        int house_number = 123;
        String street_name = "Bentley Road";
        String post_code = "DN5 9TA";
        String phone_number = "07443590365";
        String company = "SMID";
        double salary = 30000.00;
        boolean driving_license = true;

        int number = 5;
        System.out.println("Initial Value: " + number);
        number *= 2;
        System.out.println("\n1. After doubling it twice: " + number);
        number += 3;
        number += 3;
        System.out.println("\n2. After adding 3 twice: " + number);
        number -= 12;
        System.out.println("\n3. After subtracting 12: " + number);
        number /= 3;
        System.out.println("\n4. After dividing by 3: " + number);
        number += 1;
        number += 1;
        number += 1;
        number += 1;
        System.out.println("\n5. After adding 1 four times: " + number);
        number--;
        System.out.println("\n6. After decrementing once: " + number);
        int remainder = 0;
        remainder = number % 3;
        System.out.println("\n7. Remainder when dividing by 3 is :" + remainder);

        int a = 2, b = 3, c = 5;
        double d1, d2, d3, d4;
        d1 = a + b * c / 2;
        d2 = (a + b * c) / 2;
        d3 = (a + b) * c / 2;
        d4 = (a + b) * (c / 2);
        System.out.println("\n8. Values: " + d1 + " : " + d2 + " : " + d3 + " : " + d4);

        int p, q;
        p = 10;
        q = 10;
        p += q++;
        System.out.println("\n9. Result is: " + (p + q));

        System.out.println("\n11.");
        System.out.println("fred" + 3 + 4);
        System.out.println(3 + 4 + "fred");
        System.out.println("" + 3 + 4);
        System.out.println(3 + ' ' + 4);
    }
}


// variables
// reference type - allows for multiple references to the same object.

// Stack memory:
// stores primitive data types, JVC manages memory, faster, thread-safe, limited size.
// heap:
// refernce objects, manual memory management (garbage collection does this for us though),
// slower, not thread-safe, unlimited size.

// Casting:
// implicit casting also known as widening.
// small to big.

// Explicit casting also known as narrowing. Leads to data and precision loss.

