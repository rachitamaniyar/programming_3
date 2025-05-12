package exception_handling.retirement;

public class Person {
    private int age;
    private String name;
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws ZAMAgeTooLowException, ZAMAgeTooHighException {
        if (age < 60) {
            throw new ZAMAgeTooLowException("The age " + age + " is too low. The minimum age is 60.");
        } else if (age >= 65) {
            throw new ZAMAgeTooHighException("The age " + age + " is too high. The maximum age is 64.");
        }
        this.age = age;
    }
}
