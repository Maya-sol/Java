import java.util.*;
import java.io.*;


class Main {
    public static void main(String args[]) {
        Dispatcher ds = new TaxiDispatcher(4);
        for (int i = 0; i < 30; i++) {
            ds.assignOrders("someadress" + i);
        }
        for (int i = 0; i < 10; i++) {
            ds.finish();
        }

    }
}
