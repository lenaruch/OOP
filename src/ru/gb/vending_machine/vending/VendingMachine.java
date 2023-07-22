package ru.gb.vending_machine.vending;

import ru.gb.vending_machine.product.Product;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private long id;
    private List<Product> productList;

    public VendingMachine(List<Product> productList) {
        this.productList = productList;
    }

    public VendingMachine() {
        this(new ArrayList<>());
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public Product findByName(String name){
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)){
                return product;
            }
        }
        return null;
    }

    public String getProductListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список продуктов:\n");
        for (Product product : productList){
            stringBuilder.append(product);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


}
