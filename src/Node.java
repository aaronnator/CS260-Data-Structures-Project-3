// Aaron Boyle - Project 3 - Petruska \ Khalifa - CS260
public class Node 
{
    // typical fields; counter is for the toString method
    int data;
    Node link;
    private int counter;
    
    public Node (int initData, Node initLink)
    {
         this.data = initData;
         this.link = initLink;
    }
    
   // this method needs to be recursive and build a string of up to 20 elements i guess? still haven't needed it for some reason?
    public String toString()
    {
        
        if (counter <= 20)
        {
            counter++;
            return Integer.toString(data);
        }
        if(counter > 20)
        {
            counter = 0;
            return Integer.toString(data);
        }
        return Integer.toString(data);
    }
    
    // this adds a node after the current node
   public void addNodeAfter(int element)   
   {
      link = new Node(element, link);
   }

}
