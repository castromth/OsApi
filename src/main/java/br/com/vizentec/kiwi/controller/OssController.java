package br.com.vizentec.kiwi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.vizentec.kiwi.controller.dto.DetalhesOsDto;
import br.com.vizentec.kiwi.controller.dto.OsDto;
import br.com.vizentec.kiwi.controller.form.AttOsForm;
import br.com.vizentec.kiwi.controller.form.OsForm;
import br.com.vizentec.kiwi.controller.search.OsSearch;
import br.com.vizentec.kiwi.model.Os;
import br.com.vizentec.kiwi.repository.EquipamentoRepository;
import br.com.vizentec.kiwi.repository.OsRepository;
import br.com.vizentec.kiwi.repository.specification.OsSpecification;

@RestController
@RequestMapping("/os")
public class OssController {

	@Autowired
	private OsRepository osRepository;
	private EquipamentoRepository equipRepository;
	
	@GetMapping
	public List<OsDto> lista(){
		List<Os> oss = osRepository.findAll();
		return OsDto.converter(oss);
	}

	
	@PostMapping
	@Transactional
	public ResponseEntity<OsDto> cadastra(@RequestBody @Valid OsForm form,UriComponentsBuilder builder) {
		Os os = OsForm.converter(form, equipRepository);
		osRepository.save(os);
		URI uri = builder.path("/os/{id}").buildAndExpand(os.getId()).toUri();
		return ResponseEntity.created(uri).body(new OsDto(os));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesOsDto> getOs(@PathVariable Long  id) {
		Optional<Os> os = osRepository.findById(id);
		if(os.isPresent()) {
			return ResponseEntity.ok(new DetalhesOsDto(os.get()));
		}
		return ResponseEntity.notFound().build();
	}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<OsDto> atualiza(@PathVariable Long id,@RequestBody @Valid AttOsForm attOsForm){
		Optional<Os> osOptional = osRepository.findById(id);
		if(osOptional.isPresent()) {
			Os os = attOsForm.atualiza(id, osRepository);
			return ResponseEntity.ok(new OsDto(os));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Os> osOptional = osRepository.findById(id);
		if(osOptional.isPresent()) {
			osRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<List<OsDto>> search(@ModelAttribute  OsSearch osSearch, Pageable pageable){
		OsSpecification osSpec = new OsSpecification(osSearch);
		Page<Os> page = osRepository.findAll(osSpec,pageable);
		List<Os> list = page.getContent();
		List<OsDto> oss = OsDto.converter(list);
		return ResponseEntity.ok(oss);
		
	}
	
}
