import java.util.Random;
import java.util.Scanner;
import java.lang.Exception;


class Myexception extends Exception{
    public Myexception(String Message){
        super(Message);
    }

}
interface Account{
    void CreateAcc();//astract method
    void Deposit(double temp);//abstract method
    void withdraw();//abstract method
}
class BankUtilties{
    int acctype;
    int year =1;
    int ssn=0;
    int aacnum;
    float intr ;
    String name="";
    String loc="";
    Scanner in = new Scanner(System.in);
    Random rnd = new Random();
    double temp=0.0;
    double bal=0.0;
}
class Bank extends BankUtilties implements  Account{
    void getInfo(){
        try{
            System.out.println("Enter the name of the customer ");
            name = in.next();
            System.out.println("Enter the SSN number ");
            ssn=in.nextInt();
            System.out.println("Enter the name of the location");
            loc = in.next();
            System.out.println("Enter the account type. \n 1.Savings(10% interest \t 2.current(7% interest)");
            acctype =in.nextInt();
            switch (acctype){
                case 1:
                    System.out.println("Enter the amount to be deposited ");
                    temp = in.nextFloat();
                    if(temp<0){
                        System.out.println("Invalid amount \n Try again ");
                        System.out.println("Enter the amount to be deposited");
                        temp=in.nextFloat();
                    }
                    System.out.println("Enter the number of years");
                    if(year==0){
                        System.out.println("Invalid year");
                        System.out.println("ENter the number of years");
                        year = in.nextInt();
                    }
                    break;
                case 2:
                    System.out.println("Enter the initial amount to be deposited");
                    temp=in.nextFloat();
                    if(temp<0){
                        System.out.println("Invalid amount \n Try again");
                        System.out.println("Enter the amount to be deposited");
                        temp =in.nextFloat();

                    }
                    Deposit(temp);
                    break;
                default:
                    System.out.println("Invalid option ");

            }

        }
        catch(Exception e) {
            System.out.println("User-defined Expection");
            System.out.println(e.getMessage());

        }
    }

    public void CreateAcc(){
        try{
            getInfo();
            System.out.println("Account created sucessfully");
            aacnum=rnd.nextInt(1000)+1;
            System.out.println("Hello"+name +"Your account number is "+aacnum);

        }
        catch(Exception f){
            System.out.println("Fatal Error");

        }
    }



    public void Deposit(double temp) //Abstract method 2
    {
        try{
            if(temp>=500){
                bal=bal+temp;
                System.out.println("Successfully credited");
            }
            else{
                throw new Myexception("Invalid Exception");
            }
        }
        catch (Myexception e){
            System.out.println(e.getMessage());
            System.out.println("Transcation failed");

        }
    }
    public void withdraw(){
        System.out.println("Enter the amount to be withdrawn");
        temp=in.nextFloat();
        if(temp<0){
            System.out.println("Invaild amount");
            System.exit(0);
        }
        try{
            if(temp<bal){
                bal=bal-temp;
                System.out.println("Susscesfully Debited");
            }
            else{
                throw new Myexception("Invaild Exception");
            }

        }
        catch(Myexception a){
            System.out.println("Transcation failure ");
            System.out.println(a.getMessage());

        }
    }
    public void interest(){
        try{
            if(ssn==0){
                throw new  Myexception("Account Number not found");

            }
            else{
                if(acctype==1){
                    bal = bal+(year*bal*0.10);
                    System.out.println("Interest Added");
                }
                else if(acctype==2){
                    bal=bal+(year*bal*0.07);
                    System.out.println("Interest Added");
                }
            }

        }
        catch(Myexception d){
            System.out.println("Transcation failure ");
            System.out.println(d.getMessage());
        }
    }
    void checkbalance(){
        System.out.println("The balance is "+bal);
    }
}
public class  BankingMangement{
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        Bank obj = new Bank();
        System.out.println("Bank Simulator");
        try{
            while(true){
                System.out.println("1.Create Account \t 2.Check balance \t 3.Deposit\t 4.Withdrwal\t 5.Interest\t6.Exit ");
                int ch =  in.nextInt();
                switch (ch){
                    case 1:
                        obj.CreateAcc();
                        break;
                    case 2:
                        obj.checkbalance();
                        break;
                    case 3:
                        obj.Deposit(500.00);
                        break;
                    case 4:
                        obj.withdraw();
                        break;
                    case 5:
                        obj.interest();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option ");
                }
            }
        }
        catch (Exception c ){
            System.out.println("Self throw "+c );
        }

    }
}




