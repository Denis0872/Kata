package com.company;

import java.util.InputMismatchException;

public class Convertors {

    String NumToRom(int arab) {
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
            else if (arab < 0) {
                return "римских цифр не существует в отрицательном диапозоне";
            }

        }
        catch (InputMismatchException e) {System.out.println("Ошибка с форматом данных при переводе в римские цифры");
            throw new InputMismatchException();
        }

        final String s = roman[arab];
        return s;
    }
    int RomToNum(String rom) {

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
        else{
            throw new IllegalArgumentException("введённые данные не конвертируются в числа. Ошибочный ввод одного или нескольких чисел");
        }


    }
     /* enum RomanNumeral {
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
                System.out.println("не может быть конвертировано");
              throw new IllegalArgumentException(input + " не может быть конвертировано");

            }

            return result;
        }
*/

}
