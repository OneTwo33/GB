package ru.company.onetwo33.javalvl1;

public class TestEmployee {
    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        empArray[1] = new Employee("Petrov Petr", "Accountant", "pepetr@mailbox.com","892312313", 20000, 38);
        empArray[2] = new Employee("Sidorov Evgeniy", "Manager", "sievgeniy@mailbox.com", "892312314", 15000, 20);
        empArray[3] = new Employee("Kuznetsov Nikolay", "Boss", "boss@mailbox.com", "892312315", 50000, 50);
        empArray[4] = new Employee("Klimov Aleksey", "Teamlead", "klaleksey@mailbox.com", "892312316", 40000, 28);

        for (Employee employee : empArray) {
            if (employee.getAge() > 40) employee.printInfo();
        }
    }
}
