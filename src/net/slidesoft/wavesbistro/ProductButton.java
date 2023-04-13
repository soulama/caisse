package net.slidesoft.wavesbistro;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author Rachid El Alaoui , SlideSoft.net
 */
public class ProductButton extends JButton {

    private final Product product ;
    
    public ProductButton( final Product p ) {
        this.product = p ;
        this.setText( p.getName() );
        this.setFont(new Font("Arial", Font.BOLD, 20));
        this.setBackground( new Color( 108, 167, 197 ) );
    }

    public Product getProduct() {
        return product;
    }

}
