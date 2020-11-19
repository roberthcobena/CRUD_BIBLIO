package com.example.crud_biblio;

public class Libros {
    private String id, titulo, autor, categoria, paginas, editorial, referencias, estado;

    public Libros() {
    }

    public Libros(String id, String titulo, String autor, String categoria, String paginas, String editorial, String referencias, String estado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.paginas = paginas;
        this.editorial = editorial;
        this.referencias = referencias;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
