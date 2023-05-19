package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of taxpayers: ");
        int n = sc.nextInt();

        List<TaxPayer> list = new ArrayList<TaxPayer>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Taxpayer# " + i + "Data: ");
            System.out.println("Individual or company(i/c)? ");
            char type = sc.next().charAt(0);
            System.out.println("Name: ");
            String name = sc.next();
            System.out.println("Anual income: ");
            double anualIcome = sc.nextDouble();
            if (type == 'i') {
                System.out.println("Health expenditures: ");
                double he = sc.nextDouble();
                Individual individual = new Individual(name, anualIcome, he);
                list.add(individual);
            } else {
                System.out.println("Number of Employees: ");
                Integer numberOfEmploees = sc.nextInt();
                list.add(new Company(numberOfEmploees, name, anualIcome));
            }
        }

        System.out.println();
        System.out.println("TAXES RAID ");
       
        for (TaxPayer taxPayer : list) {
            System.out.println(taxPayer.getName()+": $"+String.format("%.2f", taxPayer.tax()));
        }

        double sum = 0.0;
        for (TaxPayer taxPayer : list) {
            sum += taxPayer.tax(); 
        }
        
        System.out.println("TOTAL: " + String.format("%.2f", sum));
        sc.close();
    }

}
