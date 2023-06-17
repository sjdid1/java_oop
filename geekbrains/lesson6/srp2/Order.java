package geekbrains.lesson6.srp2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Order {

    private String clientName;
    private String product;
    private int qnt;
    private int price;

    public Order(String clientName, String product, int qnt, int price) {
        this.clientName = clientName;
        this.product = product;
        this.qnt = qnt;
        this.price = price;
    }

    public String getClientName() {
        return clientName;
    }

    public String getProduct() {
        return product;
    }

    public int getQnt() {
        return qnt;
    }

    public double getPrice() {
        return price;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Order(){
    }

    public void saveToJson() {
        String fileName = "order.json";
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("{\n");
            writer.write("\"clientName\":\""+ clientName + "\",\n");
            writer.write("\"product\":\""+product+"\",\n");
            writer.write("\"qnt\":"+qnt+",\n");
            writer.write("\"price\":"+price+"\n");
            writer.write("}\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void inputFromConsole(){
        clientName = prompt("Client name: ");
        product = prompt("Product: ");
        qnt = Integer.parseInt(prompt("Quantity: "));
        price = Integer.parseInt(prompt("Price: "));
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
    
    public static void main(String[] args) {
        System.out.println("Enter order details:");
        Order order = new Order("", "", 0, 0);
        order.inputFromConsole();
        order.saveToJson();
    }

public class Loader {
    private Scanner scanner = new Scanner(System.in);

    public void inputFromConsole(Order order){
        order.setClientName(prompt("Chichikov: "));
        order.setProduct(prompt("Souls: "));
        order.setQnt(Integer.parseInt(prompt("100: ")));
        order.setPrice(Integer.parseInt(prompt("234234: ")));
    }

    private String prompt(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    public String loadFromJson(File path, Order order){
        String[] arr = {"clientName", "product", "qnt", "price"};
        String[] elements = new String[arr.length];
        String data = getString(path);
        for (int i = 0; i < arr.length; i++){
            if (data.contains(arr[i].subSequence(0,arr[i].length()-1))){
                int temp = data.indexOf(arr[i]) + (arr[i].length() + 2);
                int index = data.indexOf(',', temp) != -1 ? data.indexOf(',', temp) : data.length()-1;
                elements[i] = data.substring(temp, index);
            }
        }
        order.setClientName(elements[0]);
        order.setProduct(elements[1]);
        order.setQnt(Integer.parseInt(elements[2]));
        order.setPrice(Integer.parseInt(elements[3]));
        return data;
    }

    private String getString(File path){
        try (Scanner scannerFile = new Scanner(path)){
            StringBuilder data = new StringBuilder();
            while (scannerFile.hasNext()){
                data.append(scannerFile.nextLine());
            }
            return data.toString();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}

}