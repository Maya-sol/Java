import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) {
        try {
            Zoo zoo = new Zoo();
        } catch (Exception e) {
            System.err.println("Application failed: " + e.getMessage());
            System.exit(1);
        }
    }
}
