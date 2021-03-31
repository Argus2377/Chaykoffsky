package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Coffee implements Drink {
    int Sugar = 0;
    String Producer = "None";
    int Milk = 0;

    //ВНИМАНИЕ!!! Измените путь файла для вашего компьютера
    String path = "C:\\Users\\CRINUM\\Desktop\\Java\\SDP_LR1\\src\\com\\company\\coffee.txt";

    Scanner cin = new Scanner(System.in);
    Scanner cin2 = new Scanner(System.in);

    //Метод выбора производителя
    public void ChooseProducer() {
        System.out.print("--------------------\n");
        System.out.print("Available coffee producers:\n");
        findProducer();
        System.out.print("--------------------\n");

        Producer = returnProducer(cin2.nextInt());
    }

    //Метод добавления сахара
    public void AddSugar() {
        System.out.print("--------------------\n");
        System.out.println("Current state: " + Sugar);
        System.out.print("--------------------\n");

        System.out.print("--------------------\n");
        System.out.print("How much sugar you want to add (from 0 to 32767)?\n");
        System.out.print("--------------------\n");

        Sugar = cin.nextInt();
    }

    //Метод расчета стоимости
    public int CalculateCost() {
        int res = 0;
        String temp = "0";

        try {
            File file = new File(path);

            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            while (line != null) {

                if (line.contains(Producer))
                {
                    temp = line.substring(line.indexOf('-') + 1);
                    break;
                }
                line = reader.readLine();
            }
            res += Integer.parseInt(temp);
            res += Sugar + Milk * 20;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    //Метод изменения конфигурации
    public void ChangeConfiguration() {
        int c;
        System.out.print("--------------------\n");
        System.out.print("What do you want to change?\n" +
                "1 - Sugar\n" +
                "2 - Producer\n" +
                "3 - Milk\n" +
                "Any other number - Back\n");
        System.out.print("--------------------\n");

        c = cin.nextInt();
        switch (c) {
            case (1):
                AddSugar();
                break;
            case (2):
                ChooseProducer();
                break;
            case (3):
                AddMilk();
                break;
            default:
                break;
        }
    }

    //Индивидуальные методы класса
    public void IndividMethods() {
        int c;
        System.out.print("--------------------\n");
        System.out.println("Current state: " + Milk);
        System.out.print("--------------------\n");

        System.out.print("--------------------\n");
        System.out.print("Choose one of individual methods:\n" +
                "1 - Add milk\n" +
                "Any other number - Back\n");
        System.out.print("--------------------\n");

        c = cin.nextInt();
        switch (c) {
            case (1):
                AddMilk();
                break;
            default:
                break;
        }
    }

    //Выбор производителя чая
    public void AddMilk() {
        int c;
        System.out.print("--------------------\n");
        System.out.print("Do you want to add milk?\n" +
                "1 - yes\n" +
                "0 - no\n" +
                "Any other number - Back\n");
        System.out.print("--------------------\n");

        c = cin.nextInt();

        switch (c) {
            case (1):
                Milk = 1;
                break;
            case (0):
                Milk = 0;
                break;
            default:
                break;
        }
    }

    //Метод поиска производителя
    private void findProducer() {
        try {
            File file = new File(path);

            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);

            int n = 0;
            String line = reader.readLine();
            while (line != null)
            {
                int end = line.indexOf('-');

                System.out.println(n + ". " + line.substring(0, end));
                line = reader.readLine();
                n++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Метод, возвращающий имя производителя
    private String returnProducer(int a) {
        String res = "0";

        try {
            File file = new File(path);

            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();

            int n = 0;
            while (line != null)
            {
                if (n == a) {
                    int end = line.indexOf('-');
                    res = line.substring(0, end);

                    break;
                }

                line = reader.readLine();
                n++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    //Метод вывода заказа
    public void PrintOrder() {
        if (Milk == 1) {
            System.out.println("Coffee with milk, " + Producer + ", Sugar: " + Sugar);
        } else {
            System.out.println("Coffee without milk, " + Producer + ", Sugar: " + Sugar);
        }
        System.out.print("..........\n");
    }
}
