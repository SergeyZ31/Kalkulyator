public class CoreCalculator {
    String res = "";
    char operator;
    String[] elements;

    public CoreCalculator(String string) throws Exception {
        operator = Util.findAndCheckOperator(string);
        elements = Util.spliterator(operator, string);
        Util.checkOperand(elements, operator);
        Util.replaceQuotationMarks(elements);
        action();
    }

    public void action() throws Exception {

        switch (operator) {
            case '+' -> res = (elements[0] + elements[1]);
            case '-' -> {
                int index = elements[0].indexOf(elements[1]);
                if (index == -1) {
                    res = elements[0];
                } else {
                    res = elements[0].substring(0, index);
                    res += elements[0].substring(index + elements[1].length());
                }
            }
            case '/' -> {
                int newLen = elements[0].length() / Integer.parseInt(elements[1]);
                res = elements[0].substring(0, newLen);
            }
            case '*' -> {
                int multiplier = Integer.parseInt(elements[1]);
                for (int i = 0; i < multiplier; i++) {
                    res += elements[0];
                }
            }
            default -> throw new Exception("Что-то пошло не так");
        }

    }

    public String getRes() {
        return res;
    }
}