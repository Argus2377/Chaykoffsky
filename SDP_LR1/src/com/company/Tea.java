package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Tea implements Drink {
    int Sugar = 0;
    String Producer = "None", Type = "None";
    Scanner cin = new Scanner(System.in);
    Scanner cin2 = new Scanner(System.in);

    public void ChooseProducer()
    {
        System.out.print("--------------------\n");
        System.out.println("Choosed type of tea: " + Type);
        System.out.print("Available producers for this type of tea:\n");
        findProducer(Type);
        System.out.print("Type name of producer (start with small letter and try not to make mistakes)\n");
        System.out.print("--------------------\n");
        Producer = cin2.nextLine();
    };

    public void AddSugar()
    {
        System.out.print("--------------------\n");
        System.out.println("Current state: " + Sugar);
        System.out.print("How much sugar you want? (from 0 to 32767)\n");
        System.out.print("--------------------\n");
        Sugar = cin.nextInt();
    };

    public int CalculateCost()
    {
        int res = 0;
        String temp = "0", name;

        name = Type + "_" + Producer;

        try {
            File file = new File("C:\\Users\\CRINUM\\Desktop\\Java\\SDP_LR1\\src\\com\\company\\tea.txt");

            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            while (line != null) {

                if (line.contains(name))
                {
                    temp = line.substring(line.indexOf('-') + 1);
                    break;
                }
                line = reader.readLine();
            }
            res += Integer.parseInt(temp);
            res += Sugar;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    };

    public void ChangeConfiguration()
    {
        int c;

        System.out.print("--------------------\n");
        System.out.println("Your current configuration:\n" +
                "Type - " + Type +
                "\nProducer - " + Producer +
                "\nSugar - " + Sugar +
                "\nCurrent cost: " + CalculateCost());
        System.out.print("--------------------\n");

        System.out.print("--------------------\n");
        System.out.print("What do you want to change?\n" +
                "1 - Sugar\n" +
                "2 - Producer\n" +
                "3 - Type of tea\n" +
                "Any other number - Back\n");
        System.out.print("--------------------\n");

        c = cin.nextInt();
        switch (c)
        {
            case (1):
                AddSugar();
                break;
            case (2):
                ChooseProducer();
                break;
            case (3):
                ChooseType();
                break;
            default:
                break;
        }
    };

    public void IndividMethods()
    {
        int c;
        System.out.print("--------------------\n");
        System.out.print("Choose one of individual methods:\n" +
                "1 - Choose type of tea\n" +
                "Any other number - Back\n");
        System.out.print("--------------------\n");

        c = cin.nextInt();
        switch (c)
        {
            case (1):
                ChooseType();
                break;
            default:
                break;
        }
    };

    public void ChooseType()
    {
        int c;
        System.out.print("--------------------\n");
        System.out.println("Current state: " + Type);
        System.out.print("--------------------\n");
        System.out.print("What type of tea you want?\n" +
                "1 - green\n" +
                "2 - black\n" +
                "Any other number - Back\n");
        System.out.print("--------------------\n");

        c = cin.nextInt();
        switch (c)
        {
            case (1):
                Type = "green";
            case (2):
                Type = "black";
                break;
            default:
                break;
        }
    };

    private void findProducer(String s)
    {
        try {
            File file = new File("C:\\Users\\CRINUM\\Desktop\\Java\\SDP_LR1\\src\\com\\company\\tea.txt");

            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            while (line != null) {
                if (line.contains(s))
                {
                    int begin = line.indexOf('_') + 1;
                    int end = line.indexOf('-');

                    System.out.println(line.substring(begin, end));
                }
                line = reader.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    };

    public void PrintOrder()
    {
        System.out.println(Type + " tea, " + Producer + ", Sugar: " + Sugar);
        System.out.print("..........\n");
    };
}
