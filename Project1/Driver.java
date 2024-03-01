
public class Driver {
    public static void main(String[] args) {

        // Create queue
        PizzaQueue Queue = new PizzaQueue();


        //Test commands
        Queue.enqueue(new Pizza("pepperoni", "1234 Bobcat Trail"));
        Queue.enqueue(new Pizza("sausage", "2345 University Drive"));
        Queue.deliver();
        Queue.enqueue(new Pizza("extra cheese", "3456 Rickster Road"));
        Queue.enqueue(new Pizza("everything", "4567 King Court"));
        Queue.enqueue(new Pizza("coffee beans", "5678 Java Circle"));
        Queue.deliver();
        Queue.deliver();
        Queue.deliver();
        Queue.deliver();
        Queue.deliver();

        return;
    }
}

