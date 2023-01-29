import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories;

    public ExpensesManager() {
        this.expensesByCategories = new HashMap<>();
    }


    double saveExpense(double moneyBeforeSalary, String category, double expense) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        if (expensesByCategories.containsKey(category)) {
            ArrayList<Double> expenses = expensesByCategories.get(category);
            expenses.add(expense);
        } else {
            ArrayList<Double> expenses = new ArrayList<>();
            expenses.add(expense);
            expensesByCategories.put(category, expenses);
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }

    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        if (expensesByCategories.containsKey(category)) {
            ArrayList<Double> expenses = expensesByCategories.get(category);
            for (Double expense : expenses) {
                if (expense > maxExpense) {
                    maxExpense = expense;
                }
            }
        } else {
            System.out.println("Такой категории пока нет.");
        }
        return maxExpense;
    }

    void printAllExpensesByCategory() {
        for (String category : expensesByCategories.keySet()) {
            System.out.println(category);
            ArrayList<Double> expenses = expensesByCategories.get(category);
            for (Double expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    void removeAllExpenses() {
        expensesByCategories.clear();
        System.out.println("Траты удалены.");
    }

    double getExpensesSum() {
        double result = 0;
        for (ArrayList<Double> expenses : expensesByCategories.values()) {
            for (Double expense : expenses) {
                result += expense;
            }
        }
        return result;
    }

    void removeCategory(String name) {
        expensesByCategories.remove(name);
    }

    String getMaxCategoryName() {
        double maxCategorySum = 0;
        String maxCategoryName = "";

        for (String name : expensesByCategories.keySet()) {
            ArrayList<Double> value = expensesByCategories.get(name);
            double expenseSum = 0;
            for (double expense : value) {
                expenseSum += expense;
            }
            if (expenseSum > maxCategorySum) {
                maxCategorySum = expenseSum;
                maxCategoryName = name;
            }
        }
        return maxCategoryName;
    }
}
