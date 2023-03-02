public class HotelAdmin
{
    //Scanner class object
    private static Scanner console=new Scanner(System.in);
    //array of boolean to store status of rooms
    private static boolean rooms[];
    //array to store guest names
    private static String guests[];
    private static int numrooms;
    private static int numGuestes=0;

    public static void main(String[] args)
    {

        System.out.println("Welcome to Hotel Hotel");
        System.out.println("========================");
        System.out.print("Enter the number of rooms available: ");
        numrooms=Integer.parseInt(console.nextLine());
        rooms=new boolean[numrooms];
        guests=new String[numrooms];
        boolean run=true;
//Loop
        while(run)
        {
            int menuchoice=menu();
            switch(menuchoice)
            {
                case 1:checkin();break;
                case 2:checkOut();break;
                case 3:viewGuest();break;
                case 4:
                    System.out.println("Exit");
                    System.out.println("====");
                    System.out.println("Are you sure you want to exit?");
                    String input= console.nextLine();
                    if(input.equalsIgnoreCase("y"))
                    {
                        run=false;
                    }
                    break;
            }
        }//end of while loop
        System.out.println("Have a good day!");
    }
    /*Method to check in */
    public static void checkin()
    {
        System.out.println("Guest Check In");
        System.out.println("==============");
        System.out.print("Guest Name:");
        String guestName= console.nextLine();
        System.out.print("Capsule #[1-"+numrooms+"]: ");
        int roomNumber= Integer.parseInt(console.nextLine());
        /*Loop repeats until user enters the room which is unoccupied*/
        while(rooms[roomNumber-1])
        {
            System.out.println("Error :(");
            System.out.println("room #"+roomNumber+" is occupied.");
            System.out.print("Capsule #[1-"+numrooms+"]: ");
            roomNumber= Integer.parseInt(console.nextLine());
        }
        rooms[roomNumber-1]=true;
        guests[roomNumber-1]=guestName;
        System.out.println("Success :)");
        System.out.println(guests[roomNumber-1]+" is booked in capsule #"+roomNumber);

    }
    /*Method to check out */
    public static void checkOut()
    {
        System.out.println("Guest Check Out");
        System.out.println("==============");
        System.out.print("Capsule #[1-"+numrooms+"]: ");
        int roomNumber= Integer.parseInt(console.nextLine());

        if(!rooms[roomNumber-1])
        {
            System.out.println("Error :(");
            System.out.println("room #"+roomNumber+" is unoccupied.");
        }
        else if(rooms[roomNumber-1])
        {
            rooms[roomNumber-1]=false;
            System.out.println("room #"+roomNumber+" is checked-out.");
        }
    }

    /*Method to display the guest room numbers
     * and guest names*/
    public static void viewGuest()
    {
        System.out.println("rooms: Guest");
        for (int i = 0; i < guests.length; i++)
        {
            if(rooms[i])
                System.out.println((i+1)+" : "+guests[i]);
            else
                System.out.println((i+1)+" : [unoccupied]");
            if((i+1)%10==0)
                System.out.println();
        }
    }

    /*Method that display a menu of choices to choose between 1 -4*/
    public static int menu()
    {
        System.out.println("Guest menu");
        System.out.println("===================");
        System.out.println("1. Check in");
        System.out.println("2. Check out");
        System.out.println("3. View Guests");
        System.out.println("4. Exist");
        System.out.println("Choose an option [1-4]:");
        int userchoice=Integer.parseInt(console.nextLine());
        return userchoice;
    }
}