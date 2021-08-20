import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem2_BrennerCampos
{

  public static FileReader fileReader;

    static {
        try {
            fileReader = new FileReader("phoneNumberRecords.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args)
    {
/*
        Scanner sc = new Scanner(fileReader);

        for (int i = 0; i < 1000; i++)
        {
            if (sc.hasNext())
            {
                System.out.println(sc.nextLine());
            }

        }

 */
    new Problem2_BrennerCampos();

    }

    public Problem2_BrennerCampos()
    {

        BinaryTree record = new BinaryTree();
        Scanner sc = new Scanner(fileReader);

        String[] phoneID;


    while (sc.hasNextLine())
    {
           phoneID = sc.nextLine().split("\\s"); // read in every line and preprocess it into a String array?


            // substring(indexOf)???
           PhoneRecord newPhoneID = new PhoneRecord(phoneID[0], phoneID[1]);
           // new PhoneRecord(phoneID[i], phoneID[i+1]);

        //System.out.println(phoneID[0]+" "+ phoneID[1]);

        record.add(newPhoneID.phonenumber, newPhoneID.ID);

        }

       // record.walk();

   // record.walk();

   // record.add("333-444-5555", "345");

    record.print();


    }



}
