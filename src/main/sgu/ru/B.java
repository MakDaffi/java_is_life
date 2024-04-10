package main.sgu.ru;

public class B {
    public enum DaysOfWeek {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

        private final DaysOfWeek[] vals = values();
        
        public DaysOfWeek next(Integer num) {
            return vals[(this.ordinal() + num) % vals.length];
        }
    }

    public void main(String[] args) {
        String[] input = System.console().readLine("Enter in format day_of_week num: ").split(" ");
        DaysOfWeek curDay = DaysOfWeek.valueOf(input[0]);
        Integer numToAdd = Integer.parseInt(input[1]);
        System.out.println(curDay.next(numToAdd));
    }
    
}
