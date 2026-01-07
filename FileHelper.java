package lab4;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileHelper {

    public void logAction(String fileName, String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveInventory(String fileName, Map<Integer, Product> inventory) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("\n\n --- Depo Durumu --- \n\n");
            writer.newLine();
            for (Product p: inventory.values()) {
                writer.write("Ürün: " + p.getName() +" I Stok: "+ p.getStock());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
 
    
    
    
    
    
}