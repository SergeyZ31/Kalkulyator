public class Calculator {
    CoreCalculator coreCalculator;

    Calculator(String string) throws Exception {
        coreCalculator = new CoreCalculator(string);
    }

    public void getAnswer() throws Exception {
        String answer = coreCalculator.getRes();
        Util.printInQuotes(Util.checkRes(answer));
    }
}
