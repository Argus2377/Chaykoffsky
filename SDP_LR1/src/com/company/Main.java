package com.company;

import java.util.ArrayList;
import java.util.Scanner;

//Главная класс
public class Main {

    //Главная функция
    public static void main(String[] args) {
        ArrayList<Drink> Drinks = new ArrayList<Drink>();
        Scanner cin = new Scanner(System.in);
        Scanner cin2 = new Scanner(System.in);
        int j = 1, k = 1, price = 0;

        //Пользовательский интерфейс
        System.out.print("Welcome customer!\n");
        while (j != 0)
        {
            System.out.print("--------------------\n");
            System.out.print("What do you want?\n" +
                    "1 - See your order\n" +
                    "2 - Change your order\n" +
                    "0 or any other number - Exit\n");
            System.out.print("--------------------\n");

            j = cin.nextInt();

            switch (j)
            {
                case (1):
                    System.out.print("--------------------\n");
                    for (int i = 0; i < Drinks.size(); i++)
                    {
                        System.out.print(i + ". ");
                        Drinks.get(i).PrintOrder();
                    }
                    System.out.print("--------------------\n");

                    break;

                case (2):
                    System.out.print("--------------------\n");
                    System.out.print("What do you want to change?\n" +
                            "1 - Delete position\n" +
                            "2 - Add new position\n" +
                            "3 - Change some position\n" +
                            "4 - Clear order\n" +
                            "0 or any other number - Back\n");
                    System.out.print("--------------------\n");

                    k = cin.nextInt();

                    switch (k)
                    {
                        case (1):
                            System.out.print("--------------------\n");
                            System.out.print("What position you want to delete? (from 0 to " + (Drinks.size() - 1) + ")\n");
                            System.out.print("--------------------\n");
                            Drinks.remove(cin2.nextInt());

                            break;
                        case (2):
                            System.out.print("--------------------\n");
                            System.out.print("What drink you want to add?\n" +
                                    "1 - Tea\n" +
                                    "2 - Coffee\n" +
                                    "0 or any other number - Back\n");
                            System.out.print("--------------------\n");

                            int a = cin2.nextInt();
                            switch (a)
                            {
                                case (1):
                                    Drinks.add(new Tea());

                                    Drinks.get(Drinks.size() - 1).IndividMethods();
                                    Drinks.get(Drinks.size() - 1).ChooseProducer();
                                    Drinks.get(Drinks.size() - 1).AddSugar();

                                    break;
                                case (2):
                                    Drinks.add(new Coffee());

                                    Drinks.get(Drinks.size() - 1).IndividMethods();
                                    Drinks.get(Drinks.size() - 1).ChooseProducer();
                                    Drinks.get(Drinks.size() - 1).AddSugar();

                                    break;
                                default:
                                    break;
                            }

                            break;
                        case (3):
                            System.out.print("--------------------\n");
                            System.out.print("What position you want to change? (from 0 to " + (Drinks.size() - 1) + ")\n");
                            System.out.print("--------------------\n");
                            Drinks.get(cin2.nextInt()).ChangeConfiguration();

                            break;
                        case (4):
                            Drinks.clear();
                            break;
                        default:
                            break;
                    }
                    break;

                default:
                    System.out.print("--------------------\n");
                    System.out.print("Total price: ");

                    for (int i = 0; i < Drinks.size(); i++)
                    {
                        price += Drinks.get(i).CalculateCost();
                    }

                    System.out.println(price);

                    System.out.print("Bye! Come again!\n");
                    System.out.print("--------------------\n");

                    Drinks.clear();
                    j = 0;
                    break;
            }
        }
    }
}