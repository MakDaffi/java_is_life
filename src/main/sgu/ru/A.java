package src.main.sgu.ru;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class A {
    public void main(String[] args) {
        List<Integer> inputList = readIntList();
        System.out.println("Beautiful numbers:");
        inputList.stream().filter(beautifulPredicate()).forEach(System.out::println);
    }

    public List<Integer> readIntList() {
        List<String> stringList = Arrays.asList(System.console().readLine(
            "Enter integer values separated by spaces:\n"
        ).split(" "));
        List<Integer> inputList = stringList.stream()
                                            .map(Integer::parseInt)
                                            .collect(Collectors.toList());
        return inputList;
    }

    public Predicate<Integer> beautifulPredicate() {
        return number -> {
            int positiveNumber = Math.abs(number);
            if (positiveNumber <= 10) return false;
            int curNum = positiveNumber % 10;
            while (positiveNumber != 0) {
                if (curNum != positiveNumber % 10) {
                    return false;
                } else {
                    positiveNumber /= 10;
                }
            }
            return true;
        };
    }
}
