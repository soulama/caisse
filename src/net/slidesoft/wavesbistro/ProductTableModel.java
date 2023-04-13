package net.slidesoft.wavesbistro;

/**
 *
 * @author Rachid El Alaoui , SlideSoft.net
 */


import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rachid
 */
public final class ProductTableModel extends AbstractTableModel{

    private final ProductDB db ;

    private final String[] colNames = { "#ID", "Product Name", "QTN", "Price" };
    Class[] columns = new Class[]{ int.class, String.class, int.class, Double.class };
    

    public ProductTableModel() throws IOException {
        db = new ProductDB();        
    }
    
    public List<Product> products(){
        return db;
    }
    
    public void resetQuantity(){
        this.products().forEach( p -> p.setQtn( 1 ) );
    }
    
    public void add(Product b) throws CloneNotSupportedException{
        db.add( b.clone() );
        this.fireTableDataChanged();
    }
    
    public void remove(int index){
        db.remove(index);
//        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return db.size() ;
    }

    @Override
    public String getColumnName(int column) {
            return colNames[column];
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return columns[col];
    }
    
    

    @Override
    public Object getValueAt( final int row, final int col ) {
        Product product = db.get( row );

        switch(col) {
        case 0:
                return product.getId();
        case 1:
                return product.getName();
        case 2:
                return product.getQtn();
        case 3:
                return product.getPrice();
        }

        return null;
    }

    void empty() {
        db.clear();
        this.fireTableDataChanged();
    }

    Product getProductByID(int id) {
        Optional<Product> found = this.db.stream().filter( p -> p.getId() == id ).findFirst();
        if ( found.isPresent() ) {
            return found.get();
        }
        return null ;
    }
    
    public boolean isEmpty(){
        return db.isEmpty();
    }

    void saveToFile( final String table ) throws IOException {
        String data = this.JoinData(table);
        Utils.saveData( data );
    }

    private String JoinData( final String table ) {
        StringBuilder bf = new StringBuilder();
        this.products().forEach( p -> bf.append(table).append("; ").append(p.getCSVLine()).append("\n") );
        return bf.toString();
    }
    

    
}


