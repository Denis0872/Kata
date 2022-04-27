package com.company;

public class Main {

    public static boolean flag = false;
    public static void main(String[] args) {
        String rome;
        int arab;
        ReadString reader = new ReadString();

        Calculation calc= new Calculation();
        while (true) {
            try {
                reader.transfer();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                continue;
            }


            int result = calc.calculate(reader.getNum1(), reader.getNum2(), reader.getOper());
            if (flag) {
                rome = reader.NumToRom(result);
                System.out.println("В римских: " + " " + rome);
            }
            else
            {
                arab = result;
                System.out.println("В арабских: " + " " + arab);
            }
            flag=false;
            System.gc();
        }


    }


}