package libro.clase;

import java.util.ArrayList;

import autores.Autor;

public class Libro {
    private String titulo;
    private String editorial;
    private int noPag;
    private ArrayList<Autor> autores;

    public Libro(String titulo, String editorial, int noPag){
        this.titulo = titulo;
        this.editorial = editorial;
        this.noPag = noPag;
        autores = new ArrayList<>();
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
            cad += "      " + autores.get(i).getNombre() + "\n";
        }
        return "Titulo: " + titulo + "\n   Editorial: " + editorial + "\n   Paginas: " + noPag
        + "\n   Autores:\n" + cad;
    }
}
