import java.io.*;
import java.util.*;
import java.util.stream.*;


public class CPUscheduling{

 public static void main(String[] args) throws IOException {
        // Create a File object pointing to the current project directory
        File dir = new File(".");

        // List all .txt files in the current project directory, sort them
        // alphabetically, and collect into a List
        List<String> files = Arrays.stream(dir.list((d, n) -> n.endsWith(".txt"))).sorted()
                .collect(Collectors.toList());

        // Loop through each .txt file
        for (String inputFile : files) {
            System.out.println("====== " + inputFile + " ======");

            // Open the file for reading
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String tempString = null;


            // Read the file line by line
            while ((tempString = reader.readLine()) != null) {

                // Remove curly braces, trim spaces, and split the line by commas
                String[] data = tempString.replace("{", "").replace("}", "").trim().split(",");
                

                System.out.println(tempString);

            }
        System.out.println(tempString);
            // Close the file reader
            reader.close();
        
     }
    }
    

public void readProcesses(){




}

public void fcfs(){


}

public void sjf(){


}

public void priorityScheduling(){


}

public void roundRobin(){


}

public void calculateTimes(){


}

public void printResults(){
    
    System.out.println("Average waiting time: "); 
}

   }
