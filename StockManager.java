import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     * Modifica el método addProduct para que no permita añadir un producto que tenga un id de otro producto ya existente.
     */
    public void addProduct(Product item)
    {
        if (findProduct(item.getID()) == null) {
            stock.add(item);
        }
        else {
            System.out.println("No se puede añadir el producto asl stock por que ya existe un producto con ese id");
        }
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product producto = findProduct(id);
        if (producto != null) {
            producto.increaseQuantity(amount); 
        } 
        else {
            System.out.println("No existe ningún producto en el stock con el el id " + id);
        }
    }

    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        Product producto = null;
        int index = 0;
        boolean buscar = true;
        int numeroProductos = stock.size();
        while (index < numeroProductos && buscar) {
            if (stock.get(index).getID() == id) {
                producto = stock.get(index);
                buscar = false;
            }
            index++;
        }
        return producto;
    }

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        int valor = 0;
        Product producto = findProduct(id);
        if (producto != null) {
            valor = producto.getQuantity(); 
        }
        return valor;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for (Product product : stock) {
            System.out.println(product);
        }
    }
    
    /**
     * Método que imprime los detalles de todos los productos cuyo stock está por debajo de un 
     * determinado número que será pasado como parámetro al método.
     */
    public void underGivenNumberInStock(int cantidad)
    {
        for (Product producto : stock) {
            if (numberInStock(producto.getID()) < cantidad) {
                System.out.println(producto);
            }
        }
    
    }
}
