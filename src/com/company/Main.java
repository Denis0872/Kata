package com.company;

public class Main {

    public static boolean flag = false;
    public static void main(String[] args) {
        String rome;
        int arab;
        ReadString reader = new ReadString();
        Convertors convertors=new Convertors();
        Calculation calc= new Calculation();
        while (true) {
            try {
                reader.transfer();
            } catch (Exception e) {
                System.out.println("Введённые данные не соответсвуют условию ввода(тип ошибки ниже): ");
                System.err.println(e.getMessage());
                continue;
            }
            int result = calc.calculate(reader.getNum1(), reader.getNum2(), reader.getOper());
            if (flag) {
                rome = convertors.NumToRom(result);
                System.out.println("В римских: " + " " + rome);
            }
            else
            {
                arab = result;
                System.out.println("В арабских: " + " " + arab);
            }

            System.gc();
        }
    }
}