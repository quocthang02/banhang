package poly.edu.config;



import java.util.ArrayList;
import java.util.List;

import poly.edu.domain.Product;

public class GlobalData {
    //tao bien toan cuc
    public static List<Product> cart;

    static {
        cart = new ArrayList<>();
    }

}
