import java.util.*;
import java.io.*;

interface Dispatcher {
    void assignOrders(String address);

    void finish();
}

class TaxiDispatcher implements Dispatcher {
    int taxisNumber;
    private List<Taxi> taxis = new ArrayList<>();
    private int Index = 0;

    TaxiDispatcher(int number) {
        taxisNumber = number;
        for (int i = 0; i < taxisNumber; ++i) {
            Taxi newTaxi = new TaxiDriver(i);
            taxis.add(newTaxi);
        }
    }

    public void assignOrders(String address) {
        Taxi current = taxis.get(Index);
        current.placeOrder(address);
        Index = (Index + 1) % taxisNumber;
    }


    public void finish() {
        Taxi current = taxis.get(Index);
        current.endMessage();
        Index = (Index + 1) % taxisNumber;
    }


}