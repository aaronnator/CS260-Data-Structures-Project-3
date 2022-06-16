// Aaron Boyle - Project 3 - Petruska \ Khalifa - CS260
import java.util.Random;
public class Test 
{
    static int[] data;
    static Node head;
    static final int TOP = 12000000;
    static Random rand = new Random();

    public static void main(String[] args) 
    {
        // for reference:
        //int[] testArray = {2,4,3,1,5,7,6,9,8};
        //Node testNode = new Node(4, new Node(5, new Node (3, null)));
        
        data = new int[]{2,4,3,1,5,7,6,9,8};
        head = new Node(4, new Node(5, new Node(3, new Node(8,null))));
        
        testSort();
        
    }
    
    // randomData --------------------------------------------------------------
    public static void randomData(int length)
    {
        data = new int[length];
        int randomInt = rand.nextInt(TOP);
        data[0] = randomInt;
        head = new Node(randomInt,null);
        
        
        for (int i = 1; i < data.length; i++)
        {
            randomInt = rand.nextInt(TOP);
            
            data[i] = randomInt;            
            head.addNodeAfter(randomInt);         
            
        }
    }
    
    // testSort ----------------------------------------------------------------
    public static void testSort()
    {
        System.out.println("------------------testSort--------------------------");
        long timeStart = System.currentTimeMillis();
        Sortings.insertionSort(data);
        long timeStop = System.currentTimeMillis();
        System.out.println("insertionSort array (in ms): " + (timeStop - timeStart));
        
        timeStart = System.currentTimeMillis();
        Sortings.insertionSort(head);
        timeStop = System.currentTimeMillis();
        System.out.println("insertionSort linkedlist (in ms): " + (timeStop - timeStart));
        
        timeStart = System.currentTimeMillis();
        Sortings.mergeSort(data, 0, data.length);
        timeStop = System.currentTimeMillis();
        System.out.println("mergeSort array (in ms): " + (timeStop - timeStart));
        
        timeStart = System.currentTimeMillis();
        Sortings.mergeSort(head);
        timeStop = System.currentTimeMillis();
        System.out.println("mergeSort linkedlist (in ms): " + (timeStop - timeStart));
        
        timeStart = System.currentTimeMillis();
        Sortings.heapSort(data);
        timeStop = System.currentTimeMillis();
        System.out.println("heapSort array (in ms): " + (timeStop - timeStart));
        System.out.println("---------------end testSort-----------------------");
        
        displayArray();
        displayList();
        
    }
    
    
    // display methods ---------------------------------------------------------
    public static void displayArray()
    {
        System.out.println("The resulting array is: ");
        if(data.length >= 200)
        {
            int increment = data.length / 50;
            
            for (int i = 0; i < data.length; i++)
            {
                if (i == 0 || i == increment || i == data.length)
                {
                    System.out.println("\tdata[" + i + "]\t" + data[i]);
                    increment += increment;
                }
            }
        }
        else if (data.length < 200)
        {
            for (int i = 0; i < data.length; i ++)
            {
                System.out.println("\tdata[" + i + "]\t" + data[i]);
            }
        }
        
    }
    
    public static void displayList()
    {
        //current used to iterate over list
        Node current = Test.head;
        System.out.println("Current DATA: " + current.data);
        //Node previous = null;
        //first while loop for determining list size
        int size = 0;
        while(current != null)
        {
               size++;
               //previous = current;
               current = current.link;
              
        }
        
        //preparing for more prints
        System.out.println("The resulting linked list is: ");
        //resetting current
        current = head;
        
        //
        int increment = size / 50;
        int counter = 0;
        if (size >=  200)
        {
            while (current != null)
            {
                if (counter == 0 || counter == increment || counter == size)
                {
                    System.out.println("\tNode: " + counter + " \t" + current.data);
                }
                
                counter++;
                current = current.link;
            }
        }
        
    }
    
    
    // Test printouts ----------------------------------------------------------
    // first i tested with nine ints in
    
}
