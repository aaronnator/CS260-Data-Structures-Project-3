// Aaron Boyle - Project 3 - Petruska \ Khalifa - CS260

// Sortings is our class containing all of the method by which we will sort our linkedList and array.
public class Sortings 
{   
  // insertionSort is a slower method for sorting data; this method sorts an array
  // insertionSort with array --------------------------------------------------
    public static void insertionSort(int[] data)
    {
                
        for(int i = 1; i < data.length;i++)
        {
            int key = data[i]; 
            int k = i - 1; 
 
            while (k >= 0 && data[k] > key) 
            { 
                data[k + 1] = data[k]; 
                k = k - 1; 
            }
            data[k+1] = key;
        }
    }
    
    // this variant of insertionSort operates on a linkedlist
    // it also uses a helper method to sort efficiently
    // insertionSort with linkedList -------------------------------------------
    public static Node insertionSort(Node head)
    {
        // create a sorted array to put ordered values into
        // the sorted array will be returned at the end.
        Node sorted = null;
        Node current = head;
        
        while (current != null)
        {
            Node next = current.link;
            
            sortedInsert(current, head);
            
            current = next;
        }
        
        return sorted;
    }
    
    // helper method for inserting sorted nodes into sorted array.
    public static void sortedInsert(Node newNode, Node head) 
    { 
         Node current; 
  
         /// handling special case
         if (head == null || head.data >= newNode.data) 
         { 
            newNode.link = head; 
            head = newNode; 
         } 
         else 
         {            
            current = head;
  
            while (current.link != null && current.link.data < newNode.data)
            {                
                current = current.link;   
                newNode.link = current.link; 
                current.link = newNode; 
            }
         } 
     } 
    // mergeSort with array ----------------------------------------------------
   
    //mergeSort is the dopest way to sort data
   public static void mergeSort(int[ ] data, int first, int n)
   {
      int h1; // first half
      int h2; // second half

      if (n > 1)
      {
         // Compute sizes of the two halves
         h1 = n / 2;
         h2 = n - h1;

         mergeSort(data, first, h1);      // Sort data[first] through half1
         mergeSort(data, first + h1, h2); // Sort data[first+n1] to half2

         // Merge the two sorted halves.
         merge(data, first, h1, h2);
      }
   } 
   
   // helper method
      private static void merge(int[ ] data, int first, int n1, int n2)
   {
      int[ ] temp = new int[n1+n2]; // Allocate the temporary array
      int copied  = 0; // Number of elements copied from data to temp
      int copied1 = 0; // Number copied from the first half of data
      int copied2 = 0; // Number copied from the second half of data
      int i;           // Array index to copy from temp back into data

      // Merge elements, copying from two halves of data to the temporary array.
      while ((copied1 < n1) && (copied2 < n2))
      {
         if (data[first + copied1] < data[first + n1 + copied2])
            temp[copied++] = data[first + (copied1++)];
         else
            temp[copied++] = data[first + n1 + (copied2++)];
      }

      // Copy any remaining entries in the left and right subarrays.
      while (copied1 < n1)
         temp[copied++] = data[first + (copied1++)];
      while (copied2 < n2)
         temp[copied++] = data[first + n1 + (copied2++)];

      // Copy from temp back to the data array.
      for (i = 0; i < n1+n2; i++)
         data[first + i] = temp[i];
   
    
      }
      
   // mergeSort with linkedList ------------------------------------------------  
   public static Node mergeSort(Node h) 
    { 
        // Base case : if head is null 
        if (h == null || h.link == null) { 
            return h; 
        } 
  
        // get the middle of the list 
        Node middle = getMiddle(h); 
        Node nextofmiddle = middle.link; 
  
        // set the next of middle node to null 
        middle.link = null; 
  
        // Apply mergeSort on left list 
        Node left = mergeSort(h); 
  
        // Apply mergeSort on right list 
        Node right = mergeSort(nextofmiddle); 
  
        // Merge the left and right lists 
        Node sortedlist = sortedMerge(left, right); 
        return sortedlist; 
    }
    
     private static Node sortedMerge(Node a, Node b) 
    { 
        Node result = null; 
        /* Base cases */
        if (a == null) 
            return b; 
        if (b == null) 
            return a; 
  
        /* Pick either a or b, and recur */
        if (a.data <= b.data) { 
            result = a; 
            result.link = sortedMerge(a.link, b); 
        } 
        else { 
            result = b; 
            result.link = sortedMerge(a, b.link); 
        } 
        return result; 
    } 
  
    // Utility function to get the middle of the linked list 
     private static Node getMiddle(Node h) 
    { 
        // Base case 
        if (h == null) 
            return h; 
        Node fastptr = h.link; 
        Node slowptr = h; 
  
        // Move fastptr by two and slow ptr by one 
        // Finally slowptr will point to middle node 
        while (fastptr != null) 
        { 
            fastptr = fastptr.link;
            
            if (fastptr != null) 
            {                
                slowptr = slowptr.link; 
                fastptr = fastptr.link; 
            } 
        } 
        return slowptr; 
    }
     
     // heapSort ---------------------------------------------------------------
     
    public static void heapSort(int arr[]) 
    { 
        int n = arr.length; 
  
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        } 
    } 
  
    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    public static void heapify(int arr[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
    }
   
     
}
