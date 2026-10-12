
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

    public float[] calcTimes(ArrayList<Process> P) {
        //since no arrival times were given in the project description, assumes all processes arrived at t=0
        float turnaroundT = 0;
        float waitingT = 0;

        for (Process p : P) {
            turnaroundT += p.getTurnaroundTime();
            waitingT += p.getWaitingTime();
        }
        //take the averages
        if (P.size() > 0) {
            return new float[]{turnaroundT / P.size(), waitingT / P.size()};
        } else {
            return new float[]{0, 0};
        }
    }

    public void fcfs(List<Process> processes) {
        //no sorting necessary, run in list order since all processes arrive at t=0
        for (Process p : processes) {
            p.resetForScheduling();
        }

        int clock = 0;
        for (int i = 0; i < processes.size(); i++) {
            System.out.println("Round " + (i + 1) + ": ");
            System.out.println(processes.get(i));
            clock += processes.get(i).getRemainingTime();
            processes.get(i).recordCompletion(clock);
        }
    }

    public void sjf(List<Process> processes) {
        for (Process p : processes) {
            p.resetForScheduling();
        }
        //Temp list used to avoid modding the original list
        List<Process> temporary = new ArrayList<>(processes);
        temporary.sort(Comparator.comparingInt(Process::getBurstTime));
        for (int i = 0; i < temporary.size(); i++) {
            System.out.println("Round " + (i + 1) + ": ");
            System.out.println(temporary.get(i));
        }
        int clock = 0;
        for (Process p : temporary) {
            clock += p.getRemainingTime();
            p.recordCompletion(clock);
        }
    }

    public void priorityScheduling() {

    }

    public void roundRobin(List<Process> processes) {
        final int timeQuantum = 2;

        for (Process p : processes) {
            p.resetForScheduling();
        }

        int clock = 0;
        int incomplete = processes.size();
        int round = 0;

        while (incomplete > 0) {
            for (Process p : processes) {
                if (p.isCompleted()) {
                    continue;
                }
                round++;
                System.out.println("Round " + round + ": ");
                System.out.println(p);
                int slice = Math.min(timeQuantum, p.getRemainingTime());
                clock += slice;
                p.decreaseBurstTime(slice);
                if (p.getRemainingTime() == 0) {
                    p.recordCompletion(clock);
                    incomplete--;
                }
            }
        }
    }

    public void printResults() {

        System.out.println("Average waiting time: ");
    }
}
