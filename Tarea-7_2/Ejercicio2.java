// Clase base que representa un artículo en la biblioteca
class Item {
    private String id;       // ID del artículo
    private String title;    // Título del artículo

    // Constructor
    public Item(String id, String title) {
        this.id = id;
        this.title = title;
    }

    // Método getter para id
    public String getId() {
        return id;
    }

    // Método getter para title
    public String getTitle() {
        return title;
    }

    // Método toString para representar el objeto como cadena
    @Override
    public String toString() {
        return "Item [ID: " + id + ", Title: " + title + "]";
    }
}

// Subclase que representa un elemento impreso
class Printed extends Item {
    private int numPages;    // Número de páginas

    // Constructor
    public Printed(String id, String title, int numPages) {
        super(id, title);  // Llamada al constructor de la clase padre
        this.numPages = numPages;
    }

    // Método toString sobrescrito
    @Override
    public String toString() {
        return "Printed [ID: " + getId() + ", Title: " + getTitle() + ", Pages: " + numPages + "]";
    }
}

// Subclase que representa un elemento multimedia
class Multimedia extends Item {
    private int lengthInSeconds;    // Duración en segundos

    // Constructor
    public Multimedia(String id, String title, int lengthInSeconds) {
        super(id, title);  // Llamada al constructor de la clase padre
        this.lengthInSeconds = lengthInSeconds;
    }

    // Método toString sobrescrito
    @Override
    public String toString() {
        return "Multimedia [ID: " + getId() + ", Title: " + getTitle() + ", Length: " + lengthInSeconds + " seconds]";
    }
}

public class Ejercicio2 {
    // Método para imprimir todos los elementos del array
    public static void printItems(Item[] items) {
        for (Item item : items) {
            System.out.println(item);  // Llama automáticamente al toString()
        }
    }

    public static void main(String[] args) {
        // Crear un array de objetos Item
        Item[] items = new Item[4];
        items[0] = new Printed("B001", "The Great Gatsby", 180);
        items[1] = new Printed("B002", "1984", 328);
        items[2] = new Multimedia("M001", "Inception", 9000);
        items[3] = new Multimedia("M002", "The Dark Knight", 9120);

        // Llamar al método para imprimir los elementos
        printItems(items);
    }
}
