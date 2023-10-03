package org.example.hw;

public class TasksWithNumber {
    public boolean evenOddNumber(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean numberInInterval(int n) {
        return n >= 25 ? (n <= 100 ? true : false) : false;
    }
}
