/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tan Shan Ke B210157B
 */
public class User {
    private int age;
    private int maritalStatus;
    private int dependentStatus;
    private int carOwnershipStatus;
    private double monthlyIncome;
    private double shortTermSavings;
    private double mediumTermSavings;
    private double longTermSavings;
    private double wants;
    private double needs;
    
    static final int SINGLE = 1;
    static final int MARRIED = 2;
    static final int CAROWNER = 1;
    static final int PUBLICTRANSPORTUSER = 2;
    
    public User(int age, int maritalStatus, int dependentStatus, int carOwnershipStatus, double monthlyIncome){
        this.age = age;
        this.maritalStatus = maritalStatus;
        this.dependentStatus = dependentStatus;
        this.carOwnershipStatus = carOwnershipStatus;
        this.monthlyIncome = monthlyIncome;
    }

    //calculates budget allocation
    public String budgetAllocation(){
        double savings = monthlyIncome * 0.1;
        shortTermSavings = mediumTermSavings = longTermSavings = savings ;
        wants = monthlyIncome * 0.25;
        needs = monthlyIncome * 0.45;
        return ("\n\n--Suggested budget allocation--\nShort-term Savings: RM" + shortTermSavings + 
                "\nMedium-term Savings: RM" + mediumTermSavings +
                "\nLong-term Savings: RM" + longTermSavings +
                "\nWants: RM" + wants +
                "\nNeeds: RM" + needs);
    }

    //select the suggested expenses budget for Johor Bahru
    public double getSuggestedExpenses(){
        double suggestedExpenses = 0;
        if (age >= 60) {
            if (maritalStatus == SINGLE) {
                suggestedExpenses = 2330;
            }else if (maritalStatus == MARRIED) {
                suggestedExpenses = 3020;
            }
        } else if (age < 60) {
            if (maritalStatus == SINGLE) {
                if (dependentStatus == 2) {
                    suggestedExpenses = 4940;
                } else if (dependentStatus == 1) {
                    suggestedExpenses = 4200;
                } else if (carOwnershipStatus == PUBLICTRANSPORTUSER) {
                    suggestedExpenses = 1760;
                } else if (carOwnershipStatus == CAROWNER) {
                    suggestedExpenses = 2290;
                }
            } else if (maritalStatus == MARRIED) {
                switch (dependentStatus) {
                    case 2 -> suggestedExpenses = 6100;
                    case 1 -> suggestedExpenses = 5360;
                    case 0 -> suggestedExpenses = 4110;
                }
            }
        }
        return suggestedExpenses;
    }
    
    //compares the total wants and needs with the suggested expenses
    public String compare(){
        double total = wants + needs;
        double exceed = total - getSuggestedExpenses();
        double leftover = getSuggestedExpenses() - total;
        if (total > getSuggestedExpenses()){
            return("\nYou has exceeded your suggested expenses! \n The exceeded amount is RM" + exceed);
        } else if (total <= getSuggestedExpenses()) {
            return ("\nYou are within your suggested expenses ^-^ \nThe leftover amount is RM"+ leftover);
        }
        return null;
    }
    
    //setter and getter
    public void setAge(int age) {
        this.age = age;
    }

    public void setMaritalStatus(int maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setDependentStatus(int dependentStatus) {
        this.dependentStatus = dependentStatus;
    }

    public void setCarOwnershipStatus(int carOwnershipStatus) {
        this.carOwnershipStatus = carOwnershipStatus;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }
    
    public void setShortTermSavings(double shortTermSavings){
        this.shortTermSavings = shortTermSavings;
    }
    
    public void setMediumTermSavings(double mediumTermSavings){
        this.mediumTermSavings = mediumTermSavings;
    }
    
    public void setLongTermSavings(double longTermSavings){
        this.longTermSavings = longTermSavings;
    }    
    
    public void setWants(double wants){
        this.wants = wants;
    }

    public void setNeeds(double needs){
        this.needs = needs;
    }

    public int getAge() {
        return age;
    }

    public int getMaritalStatus() {
        return maritalStatus;
    }

    public int getDependentStatus() {
        return dependentStatus;
    }

    public int getCarOwnershipStatus() {
        return carOwnershipStatus;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }
    
    public double getShortTermSavings(){
        return shortTermSavings;
    }
    
    public double getMediumTermSavings(){
        return mediumTermSavings;
    }
    
    public double getLongTermSavings(){
        return longTermSavings;
    }    
    
    public double getWants(){
        return wants;
    }

    public double getNeeds(){
        return needs;
    }

    
}



