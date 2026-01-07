package lab4;


import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private String name;
    private int maxCapacity;
    private Map<Integer, Product> inventory;

    public Warehouse(String name, int maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.inventory = new HashMap<>();
    }

    public Map<Integer, Product> getInventory() {
        return inventory;
    }

    public void addProduct(Product p) {
        inventory.put(p.getId(), p);
    }

    public boolean isFull(int amount) {
        int currentTotalStock = 0;
        for (Product p : inventory.values()) {
            currentTotalStock += p.getStock();
        }
        return (currentTotalStock+ amount) > maxCapacity;
    }

    public synchronized void updateAndLog(Product p, int amount, FileHelper helper) {
        String threadName = Thread.currentThread().getName();
        String message;
        
        System.out.println("İşlem yapan thread: " + threadName);

        if (amount > 0) {
            if (!isFull(amount)) {
                p.setStock(p.getStock() + amount);
                message = String.format("TEDARIK (+) Ürün: %s Miktar: %d Güncel Stok: %d", 
                                        p.getName(), amount, p.getStock());
            } else {
                message = "Hata: Depo kapasitesi doldu. işlem yapılamıyor: " + p.getName();
            }
        } else {
            if (p.getStock() + amount >= 0) {
                p.setStock(p.getStock() + amount);
                message = String.format("SATIS (-) Ürün: %s Miktar: %d Güncel Stok: %d", 
                                        p.getName(), Math.abs(amount), p.getStock());
            } else {
                message = "Hata: Depoda stok yok. Ürün: " + p.getName();
            }
        }

        System.out.println(message);
        helper.logAction("warehouse_log.txt", threadName + " -> " + message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n --- Depo Durumu --- \n\n");
        for (Product p : inventory.values()) {
            sb.append("Ürün: ").append(p.getName())
              .append(" I Stok: ").append(p.getStock()).append("\n");
        }
        return sb.toString();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}