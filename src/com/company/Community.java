package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import entities.CommunityFriend;
import entities.Married;
import entities.Single;
import entities.VolunteeringType;

import javax.swing.*;

public class Community {

    /**
     * This is the main method which makes use of addNum method.
     * @param args Unused
     * @return Nothing
     * @exception ParseException if the program can't convert the birth date and if the hoursworked and learned are not equal to 2/3 of the week's hours
     */
    public static void main(String[] args){

        List<CommunityFriend> listFriend = null;
        System.out.println("Hello! Enter the number of your choice (between 1 and 4) ");
        Scanner input =  new Scanner(System.in);
        int choice = input.nextInt();
        Date date = null;
        while(choice != 0) {
            switch (choice) {
                case 1:
                    System.out.println("Enter the following information: id, name, adress, birth date, gender, worked hours(by week), learned hours(by week), salary,nitsolet gmah'");
                    int newId = input.nextInt();
                    input.nextLine();
                    String newName = input.nextLine();
                    String newAddress = input.nextLine();


                    System.out.printf("%d %s %s \n",newId,newName,newAddress);
                    String datestr = input.nextLine();
                    /**
                     *     String sDate1="31/12/1998";
                     *     Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
                     *     System.out.println(sDate1+"\t"+date1);
                     */
                    try {
  //                     dateFormat = new SimpleDateFormat("DD/MMM/YYYY").parse(date);
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYY");

                        String dateString = format.format( new Date()   );
                        date       = format.parse ( datestr );
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    String newGender = input.next();
                    int newWorkedHours = input.nextInt();
                    int newLearnedHours = input.nextInt();
                    int newSalary = input.nextInt();
                    int newGmahNumber = input.nextInt();

                    System.out.println("Choose the type of volunteering (Spiritual,Physical,Musical)");
                    String VT = input.next();
                    VolunteeringType newVT = VolunteeringType.valueOf(VT.toUpperCase());

                    System.out.println("Are you married?");
                    String response = input.next();
                    try {
                        switch (response) {
                            case "yes":
                                System.out.println("Enter the id of your partner and then the number of children");
                                int newIdPartner = input.nextInt();
                                int newNumberChildren = input.nextInt();

                                Married married = new Married(newId, newName, newAddress, date, newGender, newLearnedHours, newWorkedHours, newSalary, newGmahNumber, newIdPartner, newNumberChildren, newVT);
                                listFriend.add(married);
                                break;

                            case "no":
                                System.out.println("Enter the number of years learned");
                                int newNumberYearsLearned = input.nextInt();

                                Single single = new Single(newId, newName, newAddress, date, newGender, newLearnedHours, newWorkedHours, newSalary, newGmahNumber, newNumberYearsLearned, newVT);
                                listFriend.add(single);
                                break;
                        }
                    }
                    catch(Exception msg)
                    {
                        System.out.println(msg);
                    }

                    break;

                case 2:
                    int taxes = 0;
                    for (CommunityFriend CF : listFriend) {
                        taxes += CF.Taxes();
                    }
                    System.out.println(taxes);
                    break;

                case 3:
                    System.out.println("Enter the name of the friend who wants to borrow ");
                    String name = input.next();
                    int sumOfTheGmah = 0;
                    for (CommunityFriend CF : listFriend) {
                        if (name == CF.getName()) {
                            sumOfTheGmah = CF.MaxGmahAmount();
                            break;
                        }
                    }
                    System.out.println("The amount that you can borrow is : ");
                    System.out.println(sumOfTheGmah);
                    break;

                case 4:
                    int[] arrVolunteeringHours = new int[listFriend.size()];
                    int i = 0;

                    for (CommunityFriend CF : listFriend) {
                        if (CF.getVT().toString() == "SPIRITUAL") {
                            arrVolunteeringHours[i] = CF.VolunteeredHours();
                            i++;
                        }

                    }

                    for (CommunityFriend CF : listFriend) {
                        if (CF.getVT().toString() == "PHYSICAL") {
                            arrVolunteeringHours[i] = CF.VolunteeredHours();
                            i++;
                        }

                    }

                    for (CommunityFriend CF : listFriend) {
                        if (CF.getVT().toString() == "MUSICAL") {
                            arrVolunteeringHours[i] = CF.VolunteeredHours();
                            i++;
                        }

                    }
                    System.out.println(Arrays.toString(arrVolunteeringHours));
                    break;

                default:
                    System.out.println("Bye!");
                    return;
            }
            System.out.println("Enter another action that you wants to do");
            choice = input.nextInt();

        }

    }
}
