
//to import date class
import java.util.Date;

//attributes which car opject have
public class Car {
    Date date = new Date();
    private String plateNo;
    private int yearManufacture;
    private int monthManufacture;
    private String color;
    private double price;
    private String manufactueby;
    private int guaranteedueYear;
    private int guaranteedueMonth;

    // this constructor has the default values for attributes
    public Car() {

        plateNo = "0123-A";
        // we add +1900 to get our current year
        yearManufacture = date.getYear() + 1900;
        // we add +1 to get current month
        monthManufacture = date.getMonth() + 1;
        color = "red";
        price = 500000.00;
        manufactueby = "Merceds";
        guaranteedueYear = date.getYear() + 1900;
        guaranteedueMonth = date.getMonth() + 1 + 6;

    }

    // this constructor to get new valuse for attributes
    public Car(String plateNo, int yearManufacture, int monthManufacture, String color, double price,
               String manufactueby, int guaranteedueYear, int guaranteedueMonth) {
        this.plateNo = plateNo;
        this.yearManufacture = yearManufacture;
        this.monthManufacture = monthManufacture;
        this.color = color;
        this.price = price;
        this.manufactueby = manufactueby;
        this.guaranteedueYear = guaranteedueYear;
        this.guaranteedueMonth = guaranteedueMonth;

    }

    // this method return a YearManufacture as an intger type
    public int getYearManufacture() {
        return yearManufacture;
    }

    // this method return a MonthManufacture as an intger type
    public int getMonthManufacture() {
        return monthManufacture;
    }

    // this method return a color for an car as a string type
    public String getColor() {
        return color;
    }

    // this method return a price as a double type
    public double getPrice() {
        return price;
    }

    // this method to setsYearManufacture value
    public void setYearManufacture(int year) {
        yearManufacture = year;
    }

    // this method to setsMonthManufacture value
    public void setMonthManufacture(int month) {
        monthManufacture = month;
    }

    // this method to sets color value
    public void setColor(String color) {
        this.color = color;

    }

    // this method to sest guarantee due to year and month value
    public void setGuarantee(int month, int year) {
        guaranteedueMonth = month;
        guaranteedueYear = year;

    }
    // method must calculate the age of car in years and months and return data as
    // string type.

    public String getCarAge() {

        int yearAge = (date.getYear() + 1900) - getYearManufacture();
        int monthAge = (date.getMonth() + 1) - getMonthManufacture();
        // this if statment because no month <0 so this equation will solve the case
        if (monthAge < 0) {
            monthAge = monthAge + 12;
            yearAge = yearAge - 1;

        }
        if (yearAge >= 0 && monthAge >= 0) {
            return ("the car has age " + yearAge + " years and " + monthAge + " months ").toUpperCase();
        } else
            return ("u enterd wrong manufactueby date").toUpperCase();

    }

    // method return a manufactueby as a string type
    public String getManufactuerby() {
        return manufactueby;
    }
    // method should calculate the reaming years and months for guarantee.

    public String getCalculateGuarantee() {

        int monthGuaranteedue = guaranteedueMonth;
        int yearGuaranteedue = guaranteedueYear;
        // this if statment because there is no month >12..
        if (monthGuaranteedue > 12) {
            monthGuaranteedue = monthGuaranteedue - 12;
            yearGuaranteedue = yearGuaranteedue + 1;
        }
        int monthRemain = (date.getMonth() + 1) - monthGuaranteedue;
        int yearRemain = (date.getYear() + 1900) - yearGuaranteedue;

        if (monthRemain == 0 && yearRemain == 0) {
            return ("the guarateedu finished this month").toUpperCase();
        }

        else if (yearRemain >= 0) {
            if (monthRemain < 0) {
                monthRemain = monthRemain * -1;
                if (yearRemain != 0)
                    yearRemain = yearRemain - 1;
            }
            return ("the guaranteedu finished from " + yearRemain + " years and " + monthRemain + " months ")
                    .toUpperCase();

        } else {
            if (monthRemain > 0) {
                yearRemain = (yearRemain * -1) - 1;
                monthRemain = monthGuaranteedue + 2;
            } else if (monthRemain < 0) {
                yearRemain = yearRemain * -1;
                monthRemain = monthRemain * -1;
            } else {
                yearRemain = yearRemain * -1;
            }

            return ("the remaining period of the  Guaranteedue is " + yearRemain + " years and " + monthRemain
                    + " months ").toUpperCase();
        }
    }

    // return all info for car as String type in upper case
    public String printCarInfo() {
        // this if statment because there is no month >12..
        if (guaranteedueMonth > 12) {
            guaranteedueMonth = guaranteedueMonth - 12;
            guaranteedueYear = guaranteedueYear + 1;
        }
        return ("plateNo:" + plateNo + "   yearManufacture:" + yearManufacture + "   monthManufacture:"
                + monthManufacture + "    color:" + color + "     price:" + price + "$    manufactueby: " + manufactueby
                + "    guaranteedueYear: " + guaranteedueYear + "    guaranteedueMonth: " + guaranteedueMonth + "\n"
                + getCalculateGuarantee() + "\n" + getCarAge()).toUpperCase();

    }
}

