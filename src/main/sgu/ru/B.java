package src.main.sgu.ru;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class B {
    public void main(String[] args) {
        List<Integer> inputList = readIntList();
        int secondLargest = findSecondLargest(inputList);
        int thirdSmallest = findThirdSmallest(inputList);

        System.out.println("Second largest number: " + secondLargest);
        System.out.println("Third smallest number: " + thirdSmallest);
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

    public Integer findSecondLargest(List<Integer> array) {
        return array.stream()
                    .sorted((a, b) -> Integer.compare(b, a))
                    .skip(1)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Array contains less than two elements"));
    }


    public Integer findThirdSmallest(List<Integer> array) {
        return array.stream()
                    .sorted()
                    .skip(2)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Array contains less than three elements"));
    }
}
