package com.mintic.lagenerica.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mintic.lagenerica.model.Consolidacion;
import com.mintic.lagenerica.repository.ConsolidacionRepository;

@CrossOrigin(origins = { "http://localhost:1111","http://localhost:3000"})
@RestController
@RequestMapping("/consolidado")
public class ConsolidacionController {
	
	@Autowired
	private ConsolidacionRepository consolidacionRepository;
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarConsolidado(@RequestBody Consolidacion consolidado) {
		Optional<Consolidacion> cAnt = consolidacionRepository.findById(consolidado.getId());
		
		if(cAnt.isEmpty())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(consolidacionRepository.save(consolidado));
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> borrarConsporId(@PathVariable(value = "id") Long id) {

		Optional<Consolidacion> oC = consolidacionRepository.findById(id) ;
		
		if (oC.isEmpty())
			return ResponseEntity.notFound().build();
		
		consolidacionRepository.deleteById(id);
		
		return ResponseEntity.ok(oC);
	}

	@PostMapping("/guardar")
	public ResponseEntity<?> crearConsolidado(@RequestBody Consolidacion consolidado){
		return ResponseEntity.status(HttpStatus.CREATED).body(consolidacionRepository.save(consolidado));
	}
	
	@GetMapping("/listar")
	public List<Consolidacion> listarConsolidado() {
		List<Consolidacion> listaConsolidado = StreamSupport.stream(consolidacionRepository.findAll().spliterator(), false).collect(Collectors.toList());
		
		return listaConsolidado;
	}
	
	
}
