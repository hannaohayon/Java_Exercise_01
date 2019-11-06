package entities;

import entities.CommunityFriend;

import java.util.Date;

public class Married extends CommunityFriend {
    private int PartnerID;
    private int NumberMinorChildren;

    /*Get/Set */
    public int getPartnerID(){return PartnerID;}
    public void setPartnerID(int MyParterID){this.PartnerID=MyParterID;}
    public int getNumberMinorChildren(){return  NumberMinorChildren;}
    public void setNumberMinorChildren(int MyNumMinorChildren) {
        NumberMinorChildren = MyNumMinorChildren;
    }

    /*Constructor*/
    public Married(int MyID, String MyName, String MyAddress, Date MyBirthDate, String MyGender, int MyLearnedHours, int MyWorkedHours, int MySalary,
           int MyGmahNumber , int MyParterID, int MyNumberMinorChildren, VolunteeringType MyVType ) throws Exception {
        super( MyID,  MyName, MyAddress,  MyBirthDate, MyGender,   MyLearnedHours, MyWorkedHours,  MySalary,
                MyGmahNumber ,  MyVType);
        setPartnerID( MyParterID);
        setNumberMinorChildren( MyNumberMinorChildren);

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
            return (int)taxes;
        }

        else{
            if(this.getNumberMinorChildren()==0) {
                taxes = this.getSalary() - 0.1 * this.getSalary();//10% taxes for person who earn over the minimum salary and don't have children
                return (int) taxes;
            }
            else {
                if(this.getNumberMinorChildren()>=1) {
                    taxes = this.getSalary() - 0.05 * this.getSalary();//5% taxes for person who earn over the minimum salary and have children
                    return (int) taxes;
                }
            }
        }

        return 0;
    }

    /*
     * This is a method of the interface DutiesRights
     * @return int This returns the amount that a friend can borrow to the gmah
     */
    @Override
    public int MaxGmahAmount()
    {

        int Smic=5300;
        if(this.getSalary()<Smic)
            return 0;
        else {
            if (this.getNumberMinorChildren() == 0)
                return 1000;
            else {
                if (this.getNumberMinorChildren() <= 3)
                    return 2000;
                else {
                    if (this.getNumberMinorChildren() >= 4)
                        return 5000;
                }
            }
        }
        return 0;
    }

    /*
     * This is a method of the interface DutiesRights
     * @return int This returns the hours in a week that a friend have to do
     */
    @Override
    public int VolunteeredHours(){

       return 5;
    }

}
