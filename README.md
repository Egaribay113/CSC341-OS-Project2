# CPU Scheduling Project

This Java project simulates four CPU scheduling algorithms:

- First-Come, First-Served (FCFS)
- Shortest Job First (SJF)
- Priority Scheduling
- Round Robin

## Input format

Enter the name of a process file when the program starts. Each nonblank line should contain:

```text
processId burstTime priority
```

Example:

```text
1 5 4
2 3 1
3 1 2
```

## Assumptions

- All processes arrive at time zero.
- Lower priority numbers represent higher priority.
- Priority scheduling is non-preemptive.
- Round Robin uses a time quantum of 2.

The program reports the average waiting time and average turnaround time for the selected algorithm.

## Compile and run

From the project directory, compile both Java files:

```bash
javac CPUscheduling.java Process.java
```

Run the program:

```bash
java CPUscheduling
```

When prompted, enter the process file name, such as `process.txt`, followed by one of these algorithm choices:

```text
FCFS
SJF
Priority
RR
```
