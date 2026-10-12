
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class CPUscheduling {

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

    public class Process {

        private int id;
        private int arrivalTime;
        private int burstTime;

        public Process(int id, int arrivalTime, int burstTime) {
            this.id = id;
            this.arrivalTime = arrivalTime;
            this.burstTime = burstTime;
        }

        public int getId() {
            return id;
        }

        public int getArrivalTime() {
            return arrivalTime;
        }

        public int getBurstTime() {
            return burstTime;
        }

        public void decreaseBurstTime(int amount) {
            this.burstTime -= amount;
        }

        @Override
        public String toString() {
            return "Process{"
                    + "id=" + id
                    + ", arrivalTime=" + arrivalTime
                    + ", burstTime=" + burstTime
                    + '}';
        }
    }

    public void readProcesses() {
//Not really necessary, this could be easily done in main()? Stored in either a List or an array

    }

    public void fcfs() {
//no sorting necessary

    }

    public void sjf(List<Process> processes) {
//sort the fed in list based on burst time
        processes.sort(Comparator.comparingInt(p -> p.burstTime));
    }

    public void priorityScheduling() {

    }

    public void roundRobin() {// needs a way to interrupt or view the burst times
        final int timeQuantum = 2;

    }

    public void calculateTimes() {

    }

    public void printResults() {

        System.out.println("Average waiting time: ");
    }
}
