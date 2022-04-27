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
        Thread.sleep(1000);

        System.out.println("Введите выражение, содержащее либо римские, либо арабские цифры от 1 до 10 с оператором +-/* между ними. выражение заканчивается знаком =");
        Scanner scanner = new Scanner(System.in);
        String strokaVvoda = scanner.nextLine().toUpperCase(Locale.ROOT).trim();

        char[] MassivDevided = new char[10];

        for (int i = 0; i < strokaVvoda.length(); i++) {
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
        blocks = StringAgain.split("[+-/*\\s+]", 2);

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
                System.out.println("Оператор" + " " + simbols[i] + "  найден");

            } else {
                System.out.println("Оператор" + simbols[i] + " не найден");
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
                    Flag = false;
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
                System.out.println("Введены одновременно римские и арабские цифры");
                throw new IllegalArgumentException("введите либо арабские цифры либо римские");
            } else {
                System.out.println(" Цифры введены корректно");
            }

        }
        catch (Exception e)
        {
            System.out.println("Введены одновременно две системы счисления");
            throw new IllegalArgumentException("ошибка при вводе данных. ");
        }

        try{
            //boolean flag = false;
            for (int i = 0; i < rimskiye.length; i++){
                if (rimskiye[i].equals(blocks[0]) && rimskiye[i].equals(blocks[1])){
                    flag = true;}
                }
                if(flag=true){
                    num1 = romanToArabic(blocks[0]);
                    num2 = romanToArabic(blocks[1]);
                    oper = strokaVvoda.charAt(blocks[0].length());

                    if ((num1 <num2 )&& (oper == '-')) {
                        System.out.println("Не существует отрицательных римских чисел");
                        throw new IllegalArgumentException();
                    }
                }
                else {
                    num1 = Integer.parseInt(blocks[0]);
                    num2 = Integer.parseInt(blocks[1]);
                    oper = strokaVvoda.charAt(blocks[0].length());
                    if ((num1 > 10 || num1 < 0) || (num2 > 10 || num2 < 0)) {
                        System.out.println("Вы вышли из допустимого диапозона ввода: числа от 0 до 10 ");
                        throw new IllegalArgumentException();
                    }
                }



        }
        catch (RuntimeException e) {
            throw new IllegalArgumentException("Общее: ошибка ввода данных");
        }
    }
/*
    private  int RomToNum(String rom) {

        if (rom.equals("I")) {
            return 1;
        } else if (rom.equals("II")) {
            return 2;
        } else if (rom.equals("III")) {
            return 3;
        } else if (rom.equals("IV")) {
            return 4;
        } else if (rom.equals("V")) {
            return 5;
        } else if (rom.equals("VI")) {
            return 6;
        } else if (rom.equals("VII")) {
            return 7;
        } else if (rom.equals("VIII")) {
            return 8;
        } else if (rom.equals("IX")) {
            return 9;
        } else if (rom.equals("X")) {
            return 10;
        }
        System.gc();
        return -1;
    }
*/
enum RomanNumeral {
    I(1), II(2), III(3), IV(4), V(5),
    VI(6), VII(7), VIII(8), IX(9),
    X(10);

    private int value;

    RomanNumeral(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static List<RomanNumeral> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                .collect(Collectors.toList());
    }
}
    public static int romanToArabic(String input) {

        String romanNumeral = input.toUpperCase();
        int result = 0;

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " не может быть конвертировано");
        }

        return result;
    }
    public   String NumToRom (int arab) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        try {
            if (arab == 1) {
                return "I";
            } else if (arab==2) {
                return "II";
            } else if (arab==3) {
                return "III";
            } else if (arab==4) {
                return "IV";
            } else if (arab==5) {
                return "V";
            } else if (arab==6) {
                return "VI";
            } else if (arab==7) {
                return "VII";
            } else if (arab==8) {
                return "VIII";
            } else if (arab==9) {
                return "IX";
            } else if (arab==10) {
                return "X";
            }
            if (arab == 11) {
                return "XI";
            } else if (arab==12) {
                return "XII";
            } else if (arab==13) {
                return "XIII";
            } else if (arab==14) {
                return "XIV";
            } else if (arab==15) {
                return "XV";
            } else if (arab==16) {
                return "XVI";
            } else if (arab==17) {
                return "XVII";
            } else if (arab==18) {
                return "XVIII";
            } else if (arab==19) {
                return "IXX";
            } else if (arab==20) {
                return "XX";
            }
            else if (arab == 21) {
                return "XXI";
            } else if (arab==22) {
                return "XXII";
            } else if (arab==23) {
                return "XXIII";
            } else if (arab==24) {
                return "XXIV";
            } else if (arab==25) {
                return "XXV";
            } else if (arab==26) {
                return "XXVI";
            } else if (arab==27) {
                return "XXVII";
            } else if (arab==28) {
                return "XXVIII";
            } else if (arab==29) {
                return "XXIX";
            } else if (arab==30) {
                return "XXX";
            }
            else if (arab == 31) {
                return "XXXI";
            } else if (arab==32) {
                return "XXXII";
            } else if (arab==33) {
                return "XXXIII";
            } else if (arab==34) {
                return "XXXIV";
            } else if (arab==35) {
                return "XXXV";
            } else if (arab==36) {
                return "XXXVI";
            } else if (arab==37) {
                return "XXXVII";
            } else if (arab==38) {
                return "XXXVIII";
            } else if (arab==39) {
                return "XXXIX";
            } else if (arab==40) {
                return "XL";
            }
            else if (arab == 41) {
                return "XLI";
            } else if (arab==42) {
                return "XLII";
            } else if (arab==43) {
                return "XLIII";
            } else if (arab==44) {
                return "XLIV";
            } else if (arab==45) {
                return "XLV";
            } else if (arab==46) {
                return "XLVI";
            } else if (arab==47) {
                return "XLVII";
            } else if (arab==48) {
                return "XLVIII";
            } else if (arab==49) {
                return "XLIX";
            } else if (arab==50) {
                return "L";
            }
            else if (arab == 51) {
                return "LI";
            } else if (arab==52) {
                return "LII";
            } else if (arab==53) {
                return "LIII";
            } else if (arab==54) {
                return "LIV";
            } else if (arab==55) {
                return "LV";
            } else if (arab==56) {
                return "LVI";
            } else if (arab==57) {
                return "LVII";
            } else if (arab==58) {
                return "LVIII";
            } else if (arab==59) {
                return "LIX";
            } else if (arab==60) {
                return "LX";
            }
            else if (arab == 61) {
                return "LXI";
            } else if (arab==62) {
                return "LXII";
            } else if (arab==63) {
                return "LXIII";
            } else if (arab==64) {
                return "LXIV";
            } else if (arab==65) {
                return "LXV";
            } else if (arab==66) {
                return "LXVI";
            } else if (arab==67) {
                return "LXVII";
            } else if (arab==68) {
                return "LXVIII";
            } else if (arab==69) {
                return "LXIX";
            } else if (arab==70) {
                return "LXX";
            }
            else if (arab == 71) {
                return "LXXI";
            } else if (arab==72) {
                return "LXXII";
            } else if (arab==73) {
                return "LXXIII";
            } else if (arab==74) {
                return "LXIV";
            } else if (arab==75) {
                return "LXXV";
            } else if (arab==76) {
                return "LXXVI";
            } else if (arab==77) {
                return "LXXVII";
            } else if (arab==78) {
                return "LXXVIII";
            } else if (arab==79) {
                return "LXXIX";
            } else if (arab==80) {
                return "LXXX";
            }
            else if (arab == 81) {
                return "LXXXI";
            } else if (arab==82) {
                return "LXXXII";
            } else if (arab==83) {
                return "LXXXIII";
            } else if (arab==84) {
                return "LXXXIV";
            } else if (arab==85) {
                return "LXXXV";
            } else if (arab==86) {
                return "LXXXVI";
            } else if (arab==87) {
                return "LXXXVII";
            } else if (arab==88) {
                return "LXXXVIII";
            } else if (arab==89) {
                return "LXXXIX";
            } else if (arab==90) {
                return "XC";
            }
            else if (arab == 91) {
                return "XCI";
            } else if (arab==92) {
                return "XCII";
            } else if (arab==93) {
                return "XCIII";
            } else if (arab==94) {
                return "XCIV";
            } else if (arab==95) {
                return "XCV";
            } else if (arab==96) {
                return "XCVI";
            } else if (arab==97) {
                return "XCVII";
            } else if (arab==98) {
                return "XCVIII";
            } else if (arab==99) {
                return "XCIX";
            } else if (arab==100) {
                return "C";
            }
            else if (arab <= 0) {
                return "римских цифр не существует в отрицательном диапозоне";
            }

        }
        catch (InputMismatchException e) {System.out.println("Ошибка с форматом данных при переводе в римские цифры");
            throw new InputMismatchException();
        }

        final String s = roman[arab];
        return s;
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