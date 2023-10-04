import java.util.Scanner;
/**This code was made to create an address book with consistant checks. I am also printing the full 
  * address book at the end of code.
  */

public class CollazoN002PA1
{
  public static void main(String[]args) //receiving and checking user inputs for address book.
  {
    Scanner input = new Scanner(System.in);
    StringBuilder phoneFormatted;
    char another = ' ';
    char anotherAddress = ' ';
    char correct = ' ';
    String ownerAddrBK = "";
    String addressee = "";
    String street = "";
    String cityStateZip = "";
    String phone = "";
    String work = "";
    String addressBook = "";
    String family = String.format("%nFAMILY%n");
    String friends = String.format("%nFRIENDS%n");
    int relationship= 0;
    int bookType= 0;
    //Declaring all variables 
    
    System.out.printf("%nBegin entering address? \'Y\' or \'N\': ");
    another = input.nextLine().charAt(0);
    
    if(Character.toUpperCase(another) != 'Y') //first if statement checking if user wants to enter or not 
    {
      System.out.printf("%nExit program%n");
    } //this if statment is to check if user put Y
    
    while(Character.toUpperCase(another) == 'Y')
    {
      do
      {
        System.out.printf("%nAddress Book Type:"
                            +"%n%n1. Personal"
                            +"%n%n2. Business"
                            +"%n%nChoose from above the address book type: ");
        
        bookType = input.nextInt();
        input.nextLine();
        switch (bookType) //1st switch checking type of address book
        {
          case 1: 
            System.out.printf("%nYou entered %d for %s. Is this correct?\'Y\' or \'N\': ", bookType, "Personal");
            correct= input.nextLine().charAt(0);
            break;
          case 2: 
            System.out.printf("%nYou entered %d for %s , Is this correct?\'Y\' or \'N\':", bookType, "Business");
            correct= input.nextLine().charAt(0);
            break;  
          default:
            System.out.printf("%nYou entered %d, Which is the wrong address book type? Try again.", bookType);
            correct = 'n';
            break; 
        }//end of switch for the type of book being inputted
      }while(Character.toUpperCase(correct) != 'Y');
      addressBook = String.format("%n%n%S ADDRESS BOOK FOR ", bookType ==1 ?"personal" : "business");
      
      do //this do asks for name of owner and checks 
      {
        System.out.printf("%nEnter your name:");
        ownerAddrBK= input.nextLine();
        System.out.printf("%nYou entered %s, Is this correct? 'Y' or 'N': ", ownerAddrBK);
        correct= input.nextLine().charAt(0);
      } while(Character.toUpperCase(correct) != 'Y');//end of do for owner of address book
      addressBook += String.format("%S%n", ownerAddrBK);
      
      do
      {
        do  //asking for name of addressee and checking with user 
        {
          System.out.printf("Enter name of the adressee: ");
          addressee= input.nextLine();
          System.out.printf("%nYou entered %s, Is this correct? 'Y' or 'N': ", addressee);
          correct= input.nextLine().charAt(0);
        }while(Character.toUpperCase(correct) != 'Y');//end of do for addressee 
        
        do //asking for street and ckecing with the user 
        {
          System.out.printf("Enter the street for %s", addressee);
          street= input.nextLine();
          System.out.printf("%nYou entered %s, Is this correct? 'Y' or 'N': ", street);
          correct= input.nextLine().charAt(0);
        } while(Character.toUpperCase(correct) != 'Y');//end of do for name and street and check
        
        do // asking for city state zip 
        {
          System.out.printf("Enter the city, state, and zip code for %s using the correct format:", addressee); 
          cityStateZip= input.nextLine();
          System.out.printf("%nYou entered %s, Is this correct? 'Y' or 'N': ", cityStateZip);
          correct= input.nextLine().charAt(0);    
        }while(Character.toUpperCase(correct) != 'Y'); //end of do for cityStateZip inputs and check
        
        do
        {
          System.out.printf("Enter the 10 digit phone number for %s without dashes or parentheses:", addressee);
          phone= input.nextLine();
          phoneFormatted = new StringBuilder(phone);
          phoneFormatted.insert(3, '-');
          phoneFormatted.insert(7, '-');
          System.out.printf("%nYou entered %s, Is this correct? 'Y' or 'N': ", phoneFormatted);
          correct= input.nextLine().charAt(0); 
        }while(Character.toUpperCase(correct) != 'Y'); 
        
        do
        {
          System.out.printf("What is your relationship?%n1.Family%n2.Friends%n3.Work%nChoose from above: ");
          relationship= input.nextInt();
          input.nextLine();
          
          switch(relationship)
          {
            case 1:
              System.out.printf("%nYou entered %d for %s. Is this " 
                                  +"correct?\'Y\' or \'N\': ", relationship, relationship == 2 ? "Family" : "Friends");
            correct= input.nextLine().charAt(0);
            break;
            case 2:
              System.out.printf("%nYou entered %d for %s. Is this " 
                                  +"correct?\'Y\' or \'N\': ", relationship, relationship == 1 ? "Family" : "Friends");
            correct= input.nextLine().charAt(0);
            break;
            case 3:
              System.out.printf("%nYou entered %d for %s. Is this "
                                  +"correct?\'Y\' or \'N\': ", relationship, relationship == 3 ? "Work" : "Work" );
            correct= input.nextLine().charAt(0);
            break;
            default: 
              System.out.printf("You entered %s which is incorrect.%nTry Again.%n", relationship);
              correct= 'N';
              break;
          }//end of switch for checking relationship input
        } while(Character.toUpperCase(correct) != 'Y'); //end of do for inputting relationship
        
        switch(relationship)
        {
          case 1:
            family += String.format("%nAddressee: %s"
                                      +"%nStreet: %s"
                                      +"%nCity, State, Zip: %s"
                                      +"%nPhone: %s%n", addressee, street, cityStateZip, phoneFormatted);
            break;
          case 2:
            friends += String.format("%nAddressee: %s"
                                       +"%nStreet: %s"
                                       +"%nCity, State, Zip: %s"
                                       +"%nPhone: %s%n", addressee, street, cityStateZip, phoneFormatted);     
            break;
          case 3:
            work += String.format("%nAddressee: %s"
                                    +"%nStreet: %s"
                                    +"%nCity, State, Zip: %s"
                                    +"%nPhone: %s%n", addressee, street, cityStateZip, phoneFormatted);
            break;
        }//end of switch for printing address book 
        System.out.printf("Do you want to enter another address? 'Y' 'N': ");
        anotherAddress= input.nextLine().charAt(0);
      }while(Character.toUpperCase(anotherAddress) == 'Y'); //end of large do for inputs
      
      switch(bookType)
      {
        case 1: 
          System.out.printf("%s"
                              +"%s"
                              +"%s", addressBook, family, friends);
          break;
        case 2:
          System.out.printf("%s"
                              +"%s", addressBook, work);
          break;
      }//end of switch statment for printing edited address book
      System.out.print("Do you want to create another address book? 'Y' 'N': ");
      another= input.nextLine().charAt(0);
      
    }//end of first while loop
    System.exit(0);
  }//end of large block
}//End application class CollazoN002PA1

/**
 * n
 * 
 *Exit program
 * 
 Begin entering address? 'Y' or 'N': y
 
 Address Book Type:
 
 1. Personal
 
 2. Business
 
 Choose from above the address book type: 3
 
 You entered 3, Which is the wrong address book type? Try again.
 Address Book Type:
 
 1. Personal
 
 2. Business
 
 Choose from above the address book type: 2
 
 You entered 2 for Business , Is this correct?'Y' or 'N':n
 
 Address Book Type:
 
 1. Personal
 
 2. Business
 
 Choose from above the address book type: 1
 
 You entered 1 for Personal. Is this correct?'Y' or 'N': y
 
 Enter your name:James Kork
 
 You entered James Kork, Is this correct? 'Y' or 'N': n
 
 Enter your name:James Kirk
 
 You entered James Kirk, Is this correct? 'Y' or 'N': y
 Enter name of the adressee: Jorge Kirk
 
 You entered Jorge Kirk, Is this correct? 'Y' or 'N': n
 Enter name of the adressee: George Kirk
 
 You entered George Kirk, Is this correct? 'Y' or 'N': y
 Enter the street for George Kirk123 Main
 
 You entered 123 Main, Is this correct? 'Y' or 'N': n
 Enter the street for George Kirk718 Enterprise Cir
 
 You entered 718 Enterprise Cir, Is this correct? 'Y' or 'N': y
 Enter the city, state, and zip code for George Kirk using the correct format:Riverdale, CA
 
 You entered Riverdale, CA, Is this correct? 'Y' or 'N': n
 Enter the city, state, and zip code for George Kirk using the correct format:Riverside, IA 52327
 
 You entered Riverside, IA 52327, Is this correct? 'Y' or 'N': y
 Enter the 10 digit phone number for George Kirk without dashes or parentheses:7197890123
 
 You entered 719-789-0123, Is this correct? 'Y' or 'N': n
 Enter the 10 digit phone number for George Kirk without dashes or parentheses:3197890123
 
 You entered 319-789-0123, Is this correct? 'Y' or 'N': y
 What is your relationship?
 1.Family
 2.Friends
 3.Work
 Choose from above: 4
 You entered 4 which is incorrect.
 Try Again.
 What is your relationship?
 1.Family
 2.Friends
 3.Work
 Choose from above: 2
 
 You entered 2 for Friends. Is this correct?'Y' or 'N': n
 What is your relationship?
 1.Family
 2.Friends
 3.Work
 Choose from above: 1
 
 You entered 1 for Friends. Is this correct?'Y' or 'N': y
 Do you want to enter another address? 'Y' 'N': y
 Enter name of the adressee: Spock
 
 You entered Spock, Is this correct? 'Y' or 'N': y
 Enter the street for Spock15 Triple Moon
 
 You entered 15 Triple Moon, Is this correct? 'Y' or 'N': y
 Enter the city, state, and zip code for Spock using the correct format:Surak, Vulcan
 
 You entered Surak, Vulcan, Is this correct? 'Y' or 'N': y
 Enter the 10 digit phone number for Spock without dashes or parentheses:4151234567
 
 You entered 415-123-4567, Is this correct? 'Y' or 'N': y
 What is your relationship?
 1.Family
 2.Friends
 3.Work
 Choose from above: 2
 
 You entered 2 for Friends. Is this correct?'Y' or 'N': y
 Do you want to enter another address? 'Y' 'N': n
 
 
 PERSONAL ADDRESS BOOK FOR JAMES KIRK
 
 FAMILY
 
 Addressee: George Kirk
 Street: 718 Enterprise Cir
 City, State, Zip: Riverside, IA 52327
 Phone: 319-789-0123
 
 FRIENDS
 
 Addressee: Spock
 Street: 15 Triple Moon
 City, State, Zip: Surak, Vulcan
 Phone: 415-123-4567
 Do you want to create another address book? 'Y' 'N': y
 
 Address Book Type:
 
 1. Personal
 
 2. Business
 
 Choose from above the address book type: 2
 
 You entered 2 for Business , Is this correct?'Y' or 'N':y
 
 Enter your name:James Kirk
 
 You entered James Kirk, Is this correct? 'Y' or 'N': y
 Enter name of the adressee: Star Fleet Command
 
 You entered Star Fleet Command, Is this correct? 'Y' or 'N': y
 Enter the street for Star Fleet Command1 Star Fleet
 
 You entered 1 Star Fleet, Is this correct? 'Y' or 'N': y
 Enter the city, state, and zip code for Star Fleet Command using the correct format:Fort Baker, CA 98210
 
 You entered Fort Baker, CA 98210, Is this correct? 'Y' or 'N': y
 Enter the 10 digit phone number for Star Fleet Command without dashes or parentheses:4158921519
 
 You entered 415-892-1519, Is this correct? 'Y' or 'N': y
 What is your relationship?
 1.Family
 2.Friends
 3.Work
 Choose from above: 3
 
 You entered 3 for Work. Is this correct?'Y' or 'N': y
 Do you want to enter another address? 'Y' 'N': y
 Enter name of the adressee: Lt. Commander Montgomery Scott
 
 You entered Lt. Commander Montgomery Scott, Is this correct? 'Y' or 'N': y
 Enter the street for Lt. Commander Montgomery Scott5 Star Fleet #62
 
 You entered 5 Star Fleet #62, Is this correct? 'Y' or 'N': y
 Enter the city, state, and zip code for Lt. Commander Montgomery Scott using the correct format:Fort Baker, CA 98210
 
 You entered Fort Baker, CA 98210, Is this correct? 'Y' or 'N': y
 Enter the 10 digit phone number for Lt. Commander Montgomery Scott without dashes or parentheses:4152345678
 
 You entered 415-234-5678, Is this correct? 'Y' or 'N': y
 What is your relationship?
 1.Family
 2.Friends
 3.Work
 Choose from above: 3
 
 You entered 3 for Work. Is this correct?'Y' or 'N': y
 Do you want to enter another address? 'Y' 'N': n
 
 
 BUSINESS ADDRESS BOOK FOR JAMES KIRK
 
 Addressee: Star Fleet Command
 Street: 1 Star Fleet
 City, State, Zip: Fort Baker, CA 98210
 Phone: 415-892-1519
 
 Addressee: Lt. Commander Montgomery Scott
 Street: 5 Star Fleet #62
 City, State, Zip: Fort Baker, CA 98210
 Phone: 415-234-5678
 Do you want to create another address book? 'Y' 'N': n
 * 
 */