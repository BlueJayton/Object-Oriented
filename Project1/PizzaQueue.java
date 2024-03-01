
public class PizzaQueue {

    public static Pizza head = null;
    public static Pizza tail = null;

    public  void enqueue (Pizza thispizza){
        if (head == null) {
            head = thispizza;
        } else {
            tail.next = thispizza;
        }
        tail = thispizza;
        return;
    }

    public static Pizza dequeue () {
        Pizza ptod = null;
        if (head != null) {
            ptod = head;
            head = head.next;
        }
        if (head == null) {
            tail = null;
        }
        return ptod;
    }

    public void deliver() {
        Pizza currpizza = PizzaQueue.dequeue();
        if (currpizza == null) {
            System.out.println( "No deliveries pending");
            return;
        }
        System.out.println( "Deliver a pizza with " + currpizza.ingredients + " to " + currpizza.address);
    }
}
