package entities;

import java.util.Date;

/**
 * This is the abstracted class whose contains the sadoths of a friend's community.
 * it's used he interface DutiesRights and it's the father of 2 classes: Single and Married
 */

public abstract class CommunityFriend implements DutiesRights {
    /*sadot*/
    private int ID;
    private String Gender;
    private String Name;
    private String Address;
    private Date BirthDate;
    private int LearnedHours;
    private int WorkedHours;
    private int Salary;
    private int GmahNumber;
   private VolunteeringType VT;

    /*Constructor*/
    CommunityFriend(int MyID, String MyName,String MyAddress, Date MyBirthDate, String MyGender,
                    int MyLearnedHours, int MyWorkedHours, int MySalary,
                    int MyGmahNumber ,  VolunteeringType MyVType) throws Exception {

        if(MyLearnedHours+MyWorkedHours != (2.0/3)*168) {
            throw new Exception("You can't be a part of the community");
        }
        setID(MyID);
        setAddress(MyAddress);
        setBirthDate(MyBirthDate);
        setGender(MyGender);
        setLearnedHours(MyLearnedHours);
        setGmahNumber(MyGmahNumber);
        setWorkedHours(MyWorkedHours);
        setSalary(MySalary);
        setName(MyName);
        this.VT=MyVType;
    }

    /*Get,Set*/
    public int getID(){return ID;}

    public void setID(int MyID) {this.ID=MyID;}

    public String getGender() {return Gender;}

    public void  setGender(String MyGender){this.Gender=MyGender;}

    public String getName() {return Name;}

    public void setName(String MyName){this.Name=MyName;}

    public String getAddress() {return Address;}

    public void setAddress(String MyAddress){this.Address=MyAddress;}

    public Date getBirthDate() {return BirthDate;}

    public void setBirthDate(Date MyBirtDate){this.BirthDate=MyBirtDate;}

    public int getLearnedHours() {return LearnedHours;}

    public void setLearnedHours(int MyLearnedHours){this.LearnedHours=MyLearnedHours;}

    public int getWorkedHours() {return WorkedHours;}

    public void setWorkedHours(int MyWorkedHours){this.WorkedHours=MyWorkedHours;}

    public int getSalary() {return Salary;}

    public void setSalary(int MySalary){this.Salary=MySalary;}

    public int getGmahNumber() {return GmahNumber;}

    public void setGmahNumber(int MyGmahNumber){this.GmahNumber=MyGmahNumber;}

    public VolunteeringType getVT() {return VT;}


}
