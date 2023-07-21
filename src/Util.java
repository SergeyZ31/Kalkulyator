public class Util {

    public static char findAndCheckOperator(String str) throws Exception {
        if (str.contains("+")) {
            return '+';
        } else if (str.contains("-")) {
            return '-';
        } else if (str.contains("*")) {
            return '*';
        } else if (str.contains("/")) {
            return '/';
        } else {
            throw new Exception("Некорректный знак действия (+,-,*,/");
        }
    }
    //делим строку по оператору
    public static String[] spliterator(char operator, String str) {
        String[] elements;
        elements = str.split("\\" + operator);
        return elements;
    }

    //проверяем операнды на условия
    public static void checkOperand(String[] args, char operator) throws Exception {

        if (operator == '+' || operator == '-') {
            for (String s : args) {
                if (s.length() > 12) {
                    throw new Exception("Количество символов одного из операндов больше 10");
                }
                if ((s.charAt(0) != '"') || (s.charAt(s.length() - 1) != '"')) {
                    throw new Exception("Строки введены без кавычек");
                }
            }
        }

        if (operator == '/' || operator == '*') {
            if (args[1].contains("\"") ){
                throw new Exception("Умножать и делить строки можно только на числа");
            }
            if (args[0].length() > 12) {
                throw new Exception("Количество символов одного из операндов больше 10");
            }
            if (Integer.parseInt(args[1]) > 10 || Integer.parseInt(args[1]) < 1) {
                throw new Exception("Число должно быть в пределах от 1 до 10 включительно");
            }
            if (args[0].charAt(0) != '"' || args[0].charAt(args[0].length() - 1) != '"') {
                throw new Exception("Строка введена без кавычек");
            }
        }

    }
    public static void replaceQuotationMarks (String [] args) {
        for (int i = 0; i < args.length; i++) {
            args[i] = args[i].replace("\"", "");
        }
    }
    public static void printInQuotes(String text){
        System.out.println("\""+text+"\"");
    }

    public static String checkRes (String res) {
        if(res.length() > 40){
            return res.substring(0,39) + "...";
        }
        return res;
    }


}