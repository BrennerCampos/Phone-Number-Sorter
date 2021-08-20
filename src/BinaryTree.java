import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class BinaryTree
{

    public static FileReader fileReader;

    static {
        try
        {
            fileReader = new FileReader("phoneNumberRecords.txt");
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }


    RecordsNode root;


        public BinaryTree()
        {

            root = new RecordsNode("","");
           // root = root.PhoneNumber;

            root.bigger = new RecordsNode("000-000-0001","001");
            root.smaller = new RecordsNode("000-000-0002","002");


        }

    private class RecordsNode
    {

        String PhoneNumber;
        String ID;

        RecordsNode bigger;
        RecordsNode smaller;


        public RecordsNode(String phoneNumber, String id)
        {

            PhoneNumber = phoneNumber;
            ID = id;
            bigger = null;
            smaller = null;

        }



    }


    public void walk()
    {

        Scanner sc = new Scanner(fileReader);       // a reader for the file...
        Scanner scanIn = new Scanner(System.in);     // as well as for user input

        RecordsNode current = root;
       // RecordsNode parent = null;

        while(current!=null)
        {


            System.out.println("You're currently at " + current.PhoneNumber);
            System.out.println("smaller or greater?");
            String dir = scanIn.next();
            scanIn.nextLine();

            if (dir.equals("smaller"))    //move current leftwards
            {
                current = current.smaller;
            } else
                current = current.bigger;
        }


    }



    public void add(String phoneNumber, String id)  //takes value, puts it in a valid place in the tree (somewhere where it's left of everybody bigger and right of everybody smaller
    {

        RecordsNode current = root;    // starts looking at the root

        if (current == null)     //empty tree is a special case. Make it the root and return;
        {
            root = new RecordsNode(phoneNumber, id);
            return;
        }


        while (true) {
            if (phoneNumber.compareTo(current.PhoneNumber)<0) // if the number is smaller than the current phonenumber
            {

                if (current.smaller == null) //if it's null, don't go left (will lose track of the tree)
                {
                    current.smaller = new RecordsNode(phoneNumber, id);
                    break; //done with loop
                }
                current = current.smaller;
            }
            else    //otherwise it's bigger or equal, so go right
            {
                if (current.bigger == null) //if it's null, don't go left (will lose track of the tree)
                {
                    current.bigger = new RecordsNode(phoneNumber, id);
                    break; // done with loop
                }
                current = current.bigger;
            }

        }
    }


    public void print()
    {

        print_rec(root.bigger.bigger); // start printing 2 nodes in (first two have dummy values when we initialized it)

    }

    public void print_rec(RecordsNode current)
    {
        //base case
        if (current == null)
            return;     // don't print, just stop going down that path

        // call this on current's left,
        print_rec(current.smaller);
        System.out.println("Phone: "+ current.PhoneNumber +"   ID: "+ current.ID);
        // call this on current's right
        print_rec(current.bigger);
        //System.out.println(current.PhoneNumber+ current.ID);

    }



}
