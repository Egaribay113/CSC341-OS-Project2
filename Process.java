// No real processing is happening here; this class models a process used by
// the CPU scheduling algorithms.
public class Process {

    private int id;
    private int burstTime;
    private int priority;
    private boolean isCompleted;
    private int remainingTime;
    private int completion_time;
    private int waiting_time;
    private int turnaround_time;

    public Process(int id, int burstTime, int priority) {
        this.id = id;
        this.priority = priority;
        this.burstTime = burstTime;
        this.isCompleted = false;
        this.remainingTime = burstTime;
        this.completion_time = 0;
        this.waiting_time = 0;
        this.turnaround_time = 0;
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public int getCompletionTime() {
        return completion_time;
    }

    public int getWaitingTime() {
        return waiting_time;
    }

    public int getTurnaroundTime() {
        return turnaround_time;
    }

    /** Restore execution state before running a scheduling algorithm. */
    public void resetForScheduling() {
        remainingTime = burstTime;
        isCompleted = false;
        completion_time = 0;
        waiting_time = 0;
        turnaround_time = 0;
    }

    /**
     * Record completion assuming all processes arrive at time zero.
     */
    public void recordCompletion(int finishTime) {
        completion_time = finishTime;
        turnaround_time = finishTime;
        waiting_time = turnaround_time - burstTime;
        remainingTime = 0;
        isCompleted = true;
    }

    public void decreaseBurstTime(int amount) {
        remainingTime -= amount;
    }

    @Override
    public String toString() {
        return "PID:" + id
                + ", Burst: " + burstTime
                + ", priority=" + priority;
    }
}
