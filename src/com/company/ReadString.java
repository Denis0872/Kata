package com.company;

import java.util.*;
import java.util.stream.Collectors;
import static com.company.Main.flag;

public class ReadString
{
    private int num1;
    private int num2;
    private char oper;


    public void transfer() throws InterruptedException {
        String rrr= " II V X IX VIII VII VI IV III I ";
        StringTokenizer tokens = new StringTokenizer(rrr, " ");
        String[] rimskiye = new String[tokens.countTokens()];
        Convertors conv=new Convertors();
        int index = 0;
       // String[] rimskiye = rrr.split("\\s");
        while(tokens.hasMoreTokens()){
            rimskiye[index] = tokens.nextToken();
            ++index;
        }
       // String[] rimskiye = new String[]{"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};
        List<String> rims = Arrays.stream(rimskiye).filter(Objects::nonNull).collect(Collectors.toList());

        String[] arabskiye = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        char[] simbols = {'+', '-', '/', '*'};
        Thread.sleep(1500);

        System.out.println("Введите выражение, содержащее либо римские от I до Х-большие или маленькие, либо арабские цифры от 1 до 10 с оператором +-/* между ними. выражение заканчивается знаком =");
        Scanner scanner = new Scanner(System.in);
        String strokaVvoda = scanner.nextLine().toUpperCase(Locale.ROOT).trim();

        char[] MassivDevided = new char[10];


        for (int i = 0; i < strokaVvoda.length()-1; i++) {
            MassivDevided[i] = strokaVvoda.charAt(i);
            if (MassivDevided[i] == '+') {
                oper = '+';
            }
            if (MassivDevided[i] == '-') {
                oper = '-';
            }
            if (MassivDevided[i] == '*') {
                oper = '*';
            }
            if (MassivDevided[i] == '/') {
                oper = '/';
            }
        }

        String StringAgain = String.valueOf(MassivDevided);
        StringAgain = StringAgain.substring(0, strokaVvoda.length()-1).toUpperCase(Locale.ROOT).replaceAll(" ","");
        String[] blocks;
            blocks = StringAgain.split("[+-/*]", 3);
        try{
            int count=0;
            int p=0;
            for(; p<=blocks.length; p++)
            {
                if (p!=0){
                    count++;
                }
            }
            if(count>2){
                System.out.println("Введено слишком много цифр-максимум две");
               throw new IllegalArgumentException("введите заново");
            }
    }
        catch (Exception e){
            throw new IllegalArgumentException("введите правильно снова");
        }

        try {
            int i = 0;

            boolean found = false;
            for (; i < simbols.length; i++) {

                oper = strokaVvoda.charAt(blocks[0].length());
                if (simbols[i] == oper) {
                    found = true;
                    break;
                }
            }
           if (found) {
                System.out.println("Оператор" + " " +"\""+ simbols[i]+ "\"   найден");

            } else {
                System.out.println("Оператор не найден");
            }
        }
        catch (Exception e) {
            System.out.println("Оператор не найден");
            throw new IllegalArgumentException("ошибка при вводе оператора. введите правильно");
        }
        try {
            int k=0;
            int l=0;
            boolean Flag = false;
            for (; k < rims.stream().count(); k++) {
                if (rims.get(k).equals(blocks[0])||(rims.get(k).equals(blocks[1])))
                {

                    for (; l < arabskiye.length; l++) {
                        if(arabskiye[l].equals(blocks[1])||arabskiye[l].equals(blocks[0]))
                        {
                            Flag = true;
                            break;

                        }
                    }
                }
            }
            if (Flag) {
               System.out.println("Не введены одновременно две римские или две арабские цифры");
                throw new IllegalArgumentException();
            }
            else {
              // System.out.println(" Цифры введены корректно");
            }
        }
        catch (Exception e)
        {
            //System.out.println("Введены одновременно две системы счисления");
            throw new IllegalArgumentException("ошибка при вводе данных. ");
        }
        flag=false;

        try{

            for (int j = 0; j < rimskiye.length; j++){
                if (rimskiye[j].equals(blocks[0]) || rimskiye[j].equals(blocks[1]))
                    {flag = true;}
            }
        }
        catch (RuntimeException e) {
            throw new IllegalArgumentException("Общее: ошибка ввода данных");
        }

            if(flag){
                num1 = conv.RomToNum(blocks[0]);
                num2 = conv.RomToNum(blocks[1]);
                oper = strokaVvoda.charAt(blocks[0].length());
                try{

                    for (int j = 0; j < rimskiye.length; j++){
                        if (rimskiye[j].equals(blocks[1]) && rimskiye[j].equals(blocks[0]))
                        {
                            System.out.println("Введены две римские цифры");
                        }
                    }
                }
                catch (RuntimeException e) {
                    throw new IllegalArgumentException("Одна или обе из цифр не римские");
                }
                if ((num1 <=num2 )&& (oper == '-')) {
                    System.out.println("В результате арифметической операции возникло отрицательное или нулевое число");
                    throw new IllegalArgumentException("Не существует отрицательных или нулевых римских чисел");

                }
            }
            else {
                num1 = Integer.parseInt(blocks[0]);
                num2 = Integer.parseInt(blocks[1]);
                oper = strokaVvoda.charAt(blocks[0].length());
                if ((num1 > 10 || num1 < 0) || (num2 > 10 || num2 < 0))
                {
                    System.out.println("Вы вышли из допустимого диапозона ввода: числа от 0 до 10 ");
                    throw new IllegalArgumentException("введите допустимые числа");
                }
            }
    }
    public char getOper () {
        return oper;
    }
    public int getNum1 () {
        return num1;
    }
    public int getNum2 () {
        return num2;
    }


}