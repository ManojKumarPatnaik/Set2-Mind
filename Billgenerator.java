package com.mind.Exercise26;

import java.util.Scanner;

public class Billgenerator {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) 
	{
		boolean temp=true;
		int[] ids=new int[] {5001,5002,5003,5004,5005};
		int[] price=new int[] {500,400,600,200,350};
		do
		{
			System.out.println("------------------");
			System.out.println("Choose Action :");
			System.out.println("1.Purchase an item");
			System.out.println("2.exit");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:System.out.println("Enter your customer Id :");
			       int cId=sc.nextInt();
			       System.out.println("Enter item Id :");
			       int id=sc.nextInt();
			       displayBill(id,cId,ids,price);
			       break;
			case 2:System.out.println("Thanks for using...");
			       temp=false;
			       System.exit(0);
			}
			
			
		}while(temp);
		//Initializing arrays with specific values
		
		
		//calling displaybill method
		
	}
	static void displayBill(int id,int cId,int[] ids,int[] price)
	{
		int count=0,temp=0;
		for(int i=0;i<ids.length;i++)
		{
			if(id==ids[i])
			{
				count=1;
				temp=i;
				break;
			}
			else
			{
				count=0;
			}
		}
		 if(count==1)
		 {
		        System.out.println("Item is available");
				System.out.println("Enter no of Items :");
				int nItems=sc.nextInt();
				int iPrice=nItems*price[temp];
				int discount=price[temp]/10;
				int total=iPrice-discount;
				int bId=cId*2;
				System.out.println("-----:Your Bill :-----");
				System.out.println("Your bill id :"+bId);
				System.out.println("Customer id  :"+cId);
				System.out.println("Purchase id  :"+id);
				System.out.println("Quantity     :"+nItems);
				System.out.println("Discount     :"+discount);
				System.out.println("Bill amount  :"+total);			
			}
		 else
		 {
			 System.out.println("Item is not available");
		 }
	}

}
