package com.bestogrupo.thebestogrupo.services;


import com.bestogrupo.thebestogrupo.models.Comentario;
import com.bestogrupo.thebestogrupo.models.Tarea;
import com.bestogrupo.thebestogrupo.repositories.TareaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TareaServiceImpl implements TareaService {

    @Autowired
    TareaRepository tareaRepository;

    @Override
    public Tarea getTareaPorId(Long id) {
        if (tareaRepository.existsById(id)){
            return tareaRepository.findById(id).get();
        }else{
            return null;
        }
    }

    @Override
    public void deleteTareaPorId(Long id) {
        tareaRepository.deleteById(id);
    }

    @Override
    public void updateTareaPorId(Long id, Tarea tarea) {
        Tarea tareaAEditar = tareaRepository.findById(id).get();
        tareaAEditar.setTareaTitulo(tareaAEditar.getTareaTitulo());
        tareaAEditar.setTareaDescripcion(tareaAEditar.getTareaDescripcion());
        tareaAEditar.setTareaFecha(tareaAEditar.getTareaFecha());
        tareaAEditar.setUsuario(tareaAEditar.getUsuario());
        tareaAEditar.setListaDeComentarios(tareaAEditar.getListaDeComentarios());
        tareaRepository.save(tareaAEditar);
    }

    @Override
    public void createTarea(Tarea tarea) {
        tareaRepository.save(tarea);

    }

    @Override
    public void asignarComentario(Long id, Comentario comentario) {
        Tarea tareaAgregarComentario = tareaRepository.findById(id).get();
        tareaAgregarComentario.getListaDeComentarios().add(comentario);
        tareaRepository.save(tareaAgregarComentario);
    }


}
