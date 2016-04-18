
public class TestThread 
{
 
    public static void main(String[] args) throws InterruptedException 
    {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();
 
        Thread thread1 = new Thread(new UserThread(obj1, obj2), "thread1");
        Thread thread2 = new Thread(new UserThread(obj1, obj2), "thread2");
        Thread thread3 = new Thread(new UserThread(obj1, obj2), "thread3");
 
        thread1.start();
        Thread.sleep(3000);
        thread2.start();
        Thread.sleep(3000);
        thread3.start();
    }
}
