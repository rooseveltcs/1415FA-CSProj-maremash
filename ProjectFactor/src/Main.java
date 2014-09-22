import java.util.ArrayList;
import java.util.Scanner;

public class Main {

     public static void main(String[] args) {
    	 System.out.println("Input a number inbetween 1 and 100 to get their factors, if you are finished you may type 'QUIT' to exit the program.");
    	 Scanner c = new Scanner(System.in);
         boolean quit = false;
         while(quit == false){
        	  System.out.print("Input: ");
        	  String in = c.nextLine();
        	  if(in.equalsIgnoreCase("QUIT")){
        		  quit = true;
        		  System.out.println("Thank you.");
        	  } else {
        		  try {
        			  ArrayList<Integer> inputList = setUpInputList(in);
        			  if(inputList.size() == 1){
        				  if(inbetweenOneAndOneHundred(inputList) == true){
        					  factors(inputList.get(0));
            			  } else {
            				  System.out.println("The number you input is not inbetween 1 and 100.");
            			  }  
        			  } else {
        				  if(inbetweenOneAndOneHundred(inputList) == true){
        					  getGCD(inputList);
        				  } else {
        					  System.out.println("The numbers you input are not inbetween 1 and 100.");
        				  }
        			  }
        		  } catch(NumberFormatException e) {
        			  System.out.println("Only input integers please.");
        		  }
        	  }
          }
          c.close();
     }
     
     public static ArrayList<Integer> setUpInputList(String line){
		  Scanner readLine = new Scanner(line);
		  int first = Integer.parseInt(readLine.next());
		  ArrayList<Integer> listInput = new ArrayList<Integer>();
		  listInput.add(first);
		  while(readLine.hasNext()){
			  listInput.add(Integer.parseInt(readLine.next()));
		  }
		  readLine.close();
		  return listInput;
     }
     
     public static ArrayList<Integer> factors(int num){
    	 ArrayList<Integer> factors = new ArrayList<Integer>();
    	 System.out.print("Factors: ");
    	 for(int i = 1; i <= num; i++){
    		 for(int k = 1; k <= num; k++){
    			 if(i * k == num){
    				 System.out.print(i + " ");
    				 factors.add(i);
    			 }
    		 }
    	 }
    	 System.out.println();
    	 return factors;
     }
     
     public static int getGCD(ArrayList<Integer> nums){
    	 int count = getSmallest(nums);
    	 boolean[] numsTest = new boolean[nums.size()];
    	 System.out.print("GCD: ");
    	 while(count != 0){
    		 for(int j = 0; j < numsTest.length; j++){
    			 if(nums.get(j)%count == 0){
    				 numsTest[j] = true;
    			 } else {
    				 numsTest[j] = false;
    			 }
    		 }
    		 for(int k = 0; k < numsTest.length; k++){
    			 if( k == numsTest.length - 1 && numsTest[k] == true){
    				 System.out.println(count);
    				 return count; 
    			 } else if (numsTest[k] == false){
    				 count --;
    				 break;
    			 }
    		 }
    	 }
    	 return 1;
     }
     
     public static int getSmallest(ArrayList<Integer> numbers){
    	 int smallest = numbers.get(0);
    	 for(int i = 1; i < numbers.size(); i++){
        	 if(numbers.get(i) < smallest){
        		 smallest = numbers.get(i);
        	 }
    	 }
    	 return smallest;
     }
     
     public static boolean inbetweenOneAndOneHundred(ArrayList<Integer> listInput){
    	 for(int k = 0; k < listInput.size(); k++){
    		 if(listInput.get(k) > 100 || listInput.get(k) < 1){
    			 return false;
    		 }
    	 }
    	 return true;
     }

}