package com.mycompany.beautysalon;
import java.util.Scanner;
class Customer{
    private String Name, memberType;
    private boolean isMember;
    
    Customer(String name){
        this.Name = name;
        this.memberType = "None";
        this.isMember = false;
    }
    
    String getName(){
        return Name;
    }
    
    void setMemberType(String memberType){
        this.isMember = true;
        this.memberType = memberType;
    }
    
    String getMemberType(){
        return memberType;
    }
    
    void setIsMember(boolean member){
        this.isMember = member;
    }
    
    boolean getIsMember(){
        return isMember;
    }
    
        String getCustomerDetails() {
        return "Customer{name='" + Name + "', member=" + isMember + ", memberType='" + memberType + "'}";
    }
}

class Discount{
    private double PREMIUM_SERVICE_DISCOUNT = 0.20;
    private double GOLD_SERVICE_DISCOUNT = 0.15;
    private double SILVER_SERVICE_DISCOUNT = 0.10;
    
    //flat 10% discount on purchase of products to all
    private double PRODUCT_DISCOUNT = 0.10;
    
    double getServiceDiscount(String memberType){
        switch (memberType){
            case "Premium": 
                return PREMIUM_SERVICE_DISCOUNT;
            case "Gold":
                return GOLD_SERVICE_DISCOUNT;
            case "Silver":
                return SILVER_SERVICE_DISCOUNT;
            default:
                return 0.0;
        }
    }
    
    double getProductDiscount(boolean isMember){
        return isMember ? 0.10 : 0.0;
    }
}

class Visit{
    private Customer customer;
    private double serviceExpenses;
    private double productExpenses;
    private Discount d;
    
    
    Visit(Customer customer){
        this.customer = customer;
        this.d = new Discount();
    }
    
    Customer getCustomer(){
        return customer;
    }
    
    void setServiceExpenses(double serviceExpenses){
        this.serviceExpenses = serviceExpenses;
    }
    
    double getServiceExpenses(){
        return serviceExpenses;
    }
    
    void setProductExpenses(double productExpenses){
        this.productExpenses = productExpenses;
    }
    
    double getProductExpenses(){
        return productExpenses;
    }
    
    double getTotalBill(){
        double serviceDiscount = d.getServiceDiscount(customer.getMemberType());
        double productDiscount = d.getProductDiscount(customer.getIsMember());
        
        double discountedServiceExpenses = serviceExpenses - (serviceExpenses * serviceDiscount );
        double discountedProductExpenses = productExpenses - (productExpenses * productDiscount );
        
        return discountedServiceExpenses + discountedProductExpenses;
    }
}
public class BeautySalon {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter the name of the customer: ");
          String name = sc.nextLine();
          Customer c1 = new Customer(name);
          
          System.out.println("Is the customer a member?(yes/no)");
          String isMemberInput = sc.nextLine().trim().toLowerCase();
          boolean isMember = isMemberInput.equals("yes");
          
          if(isMember){
              System.out.println("Enter the member type (Premium/Gold/Silver): ");
              String memberType = sc.nextLine().trim();
              c1.setMemberType(memberType);
          }
          System.out.println(c1.getCustomerDetails());
          
          Visit v1 = new Visit(c1);
          
          System.out.println("Enter the product expenses: ");
          double productExpenses = sc.nextDouble();
          v1.setProductExpenses(productExpenses);
          
          System.out.println("Enter the service expenses: ");
          double serviceExpenses = sc.nextDouble();
          v1.setServiceExpenses(serviceExpenses);
          System.out.println("Total Expenses: " + v1.getTotalBill());
    }
}
