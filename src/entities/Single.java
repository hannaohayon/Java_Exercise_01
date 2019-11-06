package entities;

import java.util.Date;

/*
    * This is a son class of CommunityFriend that use the methods of the interface
 */

public class Single extends CommunityFriend {
    private int NumberLearnedYears;

    /*Get/Set*/
    public int getNumberLearnedYears(){return NumberLearnedYears;}
    public void setNumberLearnedYears(int MyNumLearnedYears){this.NumberLearnedYears=MyNumLearnedYears;}

    /*Constructor*/
    public Single(int MyID, String MyName,String MyAddress, Date MyBirthDate, String MyGender,  int MyLearnedHours, int MyWorkedHours, int MySalary,
             int MyGmahNumber , int MyNumLearnedYears, entities.VolunteeringType MyVType) throws Exception {
        super( MyID,  MyName, MyAddress,  MyBirthDate, MyGender,   MyLearnedHours, MyWorkedHours,  MySalary,
         MyGmahNumber ,  MyVType);
        setNumberLearnedYears(MyNumLearnedYears);
    }

    /*
        * This is a method of the interface DutiesRights
        * @return int This returns the taxes that a friend have to pay in a month
     */
    @Override
    public int Taxes(){

        if(this.getWorkedHours()==0) //if he is learning Torah all the time he doesn't need to pay a taxe
            return 0;

        int Smic=5300;
        double taxes;
        if(this.getSalary()<5300)
        {
            taxes=this.getSalary()-0.07*this.getSalary();//7% taxes for person who earn under the minimum salary
        }
        else{
            taxes = this.getSalary()-0.1*this.getSalary();//10% taxes for person who earn over the minimum salary
        }
        return (int)taxes;
    }

    /*
     * This is a method of the interface DutiesRights
     * @return int This returns the amount that a friend can borrow to the gmah
     */
    @Override
    public int MaxGmahAmount(){

        return 0;
    }

    /*
     * This is a method of the interface DutiesRights
     * @return int This returns the hours in a week that a friend have to do
     */
    @Override
    public int VolunteeredHours(){
        return 10;
    }

}
