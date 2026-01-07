package lab4;


public class TransactionWorker implements Runnable {
    private Warehouse warehouse;
    private Product product;
    private int amount;
    private FileHelper fileHelper;

    public TransactionWorker(Warehouse w, Product p, int amt, FileHelper h) {
        this.warehouse = w;
        this.product = p;
        this.amount = amt;
        this.fileHelper = h;
    }

    @Override
    public void run() {
        warehouse.updateAndLog(product, amount, fileHelper);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
    
    
}