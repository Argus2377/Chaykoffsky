package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Tea implements Drink {
    int Sugar = 0;
    String Producer = "None", Type = "None";

    //ВНИМАНИЕ!!! Измените путь файла для вашего компьютера
    String path = "C:\\Users\\CRINUM\\Desktop\\Java\\SDP_LR1\\src\\com\\company\\tea.txt";

    Scanner cin = new Scanner(System.in);
    Scanner cin2 = new Scanner(System.in);

    //Метод выбора производителя
    public void ChooseProducer()
    {
        System.out.print("--------------------\n");
        System.out.println("Choosed type of tea: " + Type);
        System.out.print("Available producers for this type of tea:\n");
        findProducer(Type);
        System.out.print("--------------------\n");

        Producer = returnProducer(cin2.nextInt());
    };

    //Метод добавления сахара
    public void AddSugar()
    {
        System.out.print("--------------------\n");
        System.out.println("Current state: " + Sugar);
        System.out.print("How much sugar you want? (from 0 to 32767)\n");
        System.out.print("--------------------\n");
        Sugar = cin.nextInt();
    };

    //Метод расчета стоимости
    public int CalculateCost()
    {
        int res = 0;
        String temp = "0", name;

        name = Type + "_" + Producer;

        try {
            File file = new File(path);

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

    //Метод изменения конфигурации
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
                ChooseProducer();
                break;
            default:
                break;
        }
    };

    //Индивидуальные методы класса
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

    //Выбор производителя чая
    public void ChooseType()
    {
        int c;
        System.out.print("--------------------\n");
        System.out.println("Current state: " + Type);
        System.out.print("--------------------\n");
        System.out.print("What type of tea you want?\n" +
                "1 - Green\n" +
                "2 - Black\n" +
                "Any other number - Back\n");
        System.out.print("--------------------\n");

        c = cin.nextInt();
        switch (c)
        {
            case (1):
                Type = "green";
                break;
            case (2):
                Type = "black";
                break;
            default:
                break;
        }
    };

    //Метод поиска производителя
    private void findProducer(String s)
    {
        try {
            File file = new File(path);

            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();

            int n = 0;
            while (line != null) {
                if (line.contains(s))
                {
                    int begin = line.indexOf('_') + 1;
                    int end = line.indexOf('-');

                    System.out.println(n + ". " + line.substring(begin, end));
                }
                line = reader.readLine();
                n++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    };

    //Метод, возвращающий имя производителя
    private String returnProducer(int a)
    {
        String res = "0";
        try {
            File file = new File(path);

            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();

            int n = 0;
            while (line != null) {
                if (n == a)
                {
                    int begin = line.indexOf('_') + 1;
                    int end = line.indexOf('-');

                    res = line.substring(begin, end);
                    break;
                }

                line = reader.readLine();
                n++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    };

    //Метод вывода заказа
    public void PrintOrder()
    {
        System.out.println(Type + " tea, " + Producer + ", Sugar: " + Sugar);
        System.out.print("..........\n");
    };
}
