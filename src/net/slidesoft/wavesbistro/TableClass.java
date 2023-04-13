package net.slidesoft.wavesbistro;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JButton;

/**
 *
 * @author Rachid El Alaoui , SlideSoft.net
 */
public class TableClass extends  JButton{
    
    private TableContentDialog tblDlg ;

    TableClass(String lbl, MainBistro parent) throws IOException {
        this.setText( lbl );
        tblDlg = new TableContentDialog( parent, lbl, new ProductTableModel());
        this.setBackground( new Color( 108, 167, 197 ) );
    }

    public void setTblFrame(TableContentDialog dlg) {
        this.tblDlg = dlg;
    }

    public TableContentDialog getTblContent() {
        return tblDlg ;
    }
    
    
    
}
