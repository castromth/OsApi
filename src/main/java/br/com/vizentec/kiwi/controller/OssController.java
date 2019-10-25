package br.com.vizentec.kiwi.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.vizentec.kiwi.controller.dto.OsDto;
import br.com.vizentec.kiwi.controller.form.OsForm;
import br.com.vizentec.kiwi.model.Os;
import br.com.vizentec.kiwi.repository.EquipamentoRepository;
import br.com.vizentec.kiwi.repository.OsRepository;

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
	public ResponseEntity<OsDto> cadastra(@RequestBody @Valid OsForm form,UriComponentsBuilder builder) {
		Os os = OsForm.converter(form, equipRepository);
		osRepository.save(os);
		URI uri = builder.path("/os/{id}").buildAndExpand(os.getId()).toUri();
		return ResponseEntity.created(uri).body(new OsDto(os));
	}
	
	@GetMapping("/{id}")
	public OsDto getOs(@PathVariable Long  id) {
		return OsDto.converter(osRepository.getOne(id));
	}
	
}
