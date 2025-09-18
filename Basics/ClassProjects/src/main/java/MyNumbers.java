
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hemnarayanchaudhary
 */
public class MyNumbers {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter numbers into the list (type 'done' to finish):");

        // Input loop
        while (true) {
            String input = sc.nextLine();
            if (input.equals("done")) {
                break;
            }
            int num = Integer.parseInt(input);
            numbers.add(num);
        }
        
        int largest = numbers.get(0);
        int smallest = numbers.get(0);
        int largestIndex = 0;
        int smallestIndex = 0;
        
        for(int i = 1; i < numbers.size(); i++){
            int current = numbers.get(i);
            if(current > largest){
                largest = current;
                largestIndex = i;
            }
            
            if(current < smallest){
                smallest = current;
                smallestIndex = i;
            }
        }
        
        System.out.println("Original list: " + numbers);
        System.out.println("Largest number: " + largest);
        System.out.println("Smallest number: " + smallest);
        
           for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == largest) {
                numbers.set(i, smallest);
            } else if (numbers.get(i) == smallest) {
                numbers.set(i, largest);
            }
        }

        System.out.println("List after swapping values: " + numbers);
    }
}
