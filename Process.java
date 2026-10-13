// No real processing is happening here; this class models a process used by
// the CPU scheduling algorithms.
public class Process {

    private int id;
    private int burstTime;
    private int priority;
    private boolean isCompleted;
    private int remainingTime;
    private int completionTime;
    private int waitingTime;
    private int turnaroundTime;

    public Process(int id, int burstTime, int priority) {
        this.id = id;
        this.priority = priority;
        this.burstTime = burstTime;
        this.isCompleted = false;
        this.remainingTime = burstTime;
        this.completionTime = 0;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
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
        return completionTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    /** Restore execution state before running a scheduling algorithm. */
    public void resetForScheduling() {
        remainingTime = burstTime;
        isCompleted = false;
        completionTime = 0;
        waitingTime = 0;
        turnaroundTime = 0;
    }

    /**
     * Record completion assuming all processes arrive at time zero.
     */
    public void recordCompletion(int finishTime) {
        completionTime = finishTime;
        turnaroundTime = finishTime;
        waitingTime = turnaroundTime - burstTime;
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
