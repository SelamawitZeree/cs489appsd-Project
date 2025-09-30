package edu.miu.cs.cs489appsd.lab1.productmgmtapp;
import edu.miu.cs.cs489appsd.lab1.productmgmtapp.model.Product;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class ProductMgmtApp {
    public static void main(String[] args) {
        Product[] products = productArray();
        printProducts(products);
    }

    private static Product[] productArray() {
        return new Product[]{
            new Product(new BigInteger("31288741190182539912"), "Banana", LocalDate.parse("2025-01-24"), 124, new BigDecimal("0.55")),
            new Product(new BigInteger("29274582650152771644"), "Apple",  LocalDate.parse("2024-12-09"),  18, new BigDecimal("1.09")),
            new Product(new BigInteger("91899274600128155167"), "Carrot", LocalDate.parse("2025-03-31"),  89, new BigDecimal("2.99")),
            new Product(new BigInteger("31288741190182539913"), "Banana", LocalDate.parse("2025-02-13"), 240, new BigDecimal("0.65"))
        };
    }

    public static void printProducts(Product[] products) {
        Product[] byName = Arrays.copyOf(products, products.length);
        Arrays.sort(byName, Comparator.comparing(Product::getName)
                                      .thenComparing(Product::getUnitPrice));

        Product[] byPriceDesc = Arrays.copyOf(products, products.length);
        Arrays.sort(byPriceDesc, Comparator.comparing(Product::getUnitPrice).reversed()
                                           .thenComparing(Product::getName));

        System.out.println("Printed in JSON format");
        System.out.println("Sorted by Product Name (ascending)");
        System.out.println(toJson(byName));
        System.out.println();
        System.out.println("Sorted by Unit Price (descending)");
        System.out.println(toJson(byPriceDesc));
        System.out.println();

        System.out.println("Printed in XML format");
        System.out.println("Sorted by Product Name (ascending)");
        System.out.println(toXml(byName));
        System.out.println();
        System.out.println("Sorted by Unit Price (descending)");
        System.out.println(toXml(byPriceDesc));
        System.out.println();

        System.out.println("Printed in Comma-Separated Values (CSV) format");
        System.out.println("Sorted by Product Name (ascending)");
        System.out.println(toCsv(byName));
        System.out.println();
        System.out.println("Sorted by Unit Price (descending)");
        System.out.println(toCsv(byPriceDesc));
    }

    private static String toJson(Product[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < arr.length; i++) {
            Product p = arr[i];
            sb.append(String.format(
                "  {\"productId\": \"%s\", \"name\": \"%s\", " +
                        "\"dateSupplied\": \"%s\", \"quantityInStock\": %d, \"unitPrice\": %s}",
                p.getProductId(), p.getName(), p.getDateSupplied()
                    , p.getQuantityInStock(), p.unitPriceAsString()
            ));
            if (i < arr.length - 1) sb.append(",\n");
        }
        sb.append("\n]");
        return sb.toString();
    }

    private static String toXml(Product[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\"?>\n");
        sb.append("<products>\n");
        for (Product p : arr) {
            sb.append(String.format(
                "  <product productId=\"%s\" name=\"%s\" " +
                        "dateSupplied=\"%s\" quantityInStock=\"%d\" unitPrice=\"%s\"/>\n",
                p.getProductId(), p.getName(), p.getDateSupplied()
                    , p.getQuantityInStock(), p.unitPriceAsString()
            ));
        }
        sb.append("</products>");
        return sb.toString();
    }

    private static String toCsv(Product[] arr) {
        StringBuilder sb = new StringBuilder();
        for (Product p : arr) {
            sb.append(String.format("%s, %s, %s, %d, %s%n",
                    p.getProductId(), p.getName(), p.getDateSupplied()
                    , p.getQuantityInStock(), p.unitPriceAsString()));
        }
        return sb.toString();
    }
}
