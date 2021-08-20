public class PhoneRecord
{
        String phonenumber;
        String ID;
        PhoneRecord bigger;
        PhoneRecord smaller;


      public PhoneRecord(String phoneNumber, String ID)
       {
               this.phonenumber = phoneNumber;
               this.ID = ID;
               bigger = null;
               smaller = null;
       }

}
