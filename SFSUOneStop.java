package assignment03PartE;

/**
 *
 * Part E
 *
 */
import java.util.PriorityQueue;

public class SFSUOneStop {

    static void display(PriorityQueue<Student> PQ, String priority) {
        System.out.println("Priority: " + priority);
        while (!PQ.isEmpty()) {
            System.out.println(String.format("%-10s", "")
                    + String.format("%-10s", PQ.peek().getFirstName())
                    + String.format("%-8s", PQ.peek().getLastName())
                    + String.format("%-8s", PQ.peek().getStudentId())
                    + String.format("%-8s", PQ.peek().getGpa())
                    + String.format("%-8s", PQ.peek().getSmallQ())
                    + PQ.remove().getBigQ());
        }
        System.out.println("");
    }
}
