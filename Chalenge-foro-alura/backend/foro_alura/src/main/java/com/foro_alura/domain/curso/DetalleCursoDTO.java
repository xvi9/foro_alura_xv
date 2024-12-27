package com.foro_alura.domain.curso;



public record DetalleCursoDTO(Long id, String name, Categoria categoria, Boolean activo) {//Define los parametros a recibir

    //Constructor
    public DetalleCursoDTO(Curso curso){
        this(curso.getId(), curso.getName(), curso.getCategoria(), curso.getActivo());
    }
}


