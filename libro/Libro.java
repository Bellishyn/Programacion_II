package libro;

import autor.Autor;
import java.util.ArrayList;

public class Libro {
    private String titulo;
    private String editorial;
    private int noPag;
    private ArrayList<Autor> autores;

    public Libro(String titulo, String editorial, int noPag){
        this.titulo = titulo;
        this.editorial = editorial;
        this.noPag = noPag;
        autores = new ArrayList();
    }

    public String getTitulo(){
        return titulo;
    }

    public String getEditorial(){
        return editorial;
    }

    public void asignarAutor(Autor autor){
        autores.add(autor);
    }

    @Override
    public String toString(){
        String cad = "";
        for(int i = 0; i < autores.size(); i++){
            cad += autores.get() + ", ";
        }
        return titulo + ", " + cad + "No. paginas " + noPag
        + ", " + editorial;
    }
}
