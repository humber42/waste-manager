package cu.humberto.wastemanager.service.impl;

import cu.humberto.wastemanager.client.WasteManagerAddressClient;
import cu.humberto.wastemanager.dto.WasteManagerAddressDTO;
import cu.humberto.wastemanager.dto.WasteManagerDTO;
import cu.humberto.wastemanager.entity.WasteManagerEntity;
import cu.humberto.wastemanager.repository.WasteManagerRepository;
import cu.humberto.wastemanager.service.WasteManagerService;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
@RequiredArgsConstructor
public class WasteManagerServiceImpl implements WasteManagerService {

    private final WasteManagerRepository wasteManagerRepository;
    private final WasteManagerAddressClient managerAddressClient;
    private final Mapper mapper;

    @Override
    public ResponseEntity create(WasteManagerDTO wasteManagerDto, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("Error de validacion");
        }else {
            WasteManagerEntity wasteManager = mapper.map(wasteManagerDto,WasteManagerEntity.class);
            wasteManager.setIdAddress(wasteManagerDto.getManagerAddress().getId());
            return ResponseEntity.ok(this.saveOrUpdate(wasteManager));
        }
    }

    @Override
    public ResponseEntity update(WasteManagerDTO dto, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("Error de validacion");
        }else {
            WasteManagerEntity wasteManager = mapper.map(dto,WasteManagerEntity.class);
            wasteManager.setIdAddress(dto.getManagerAddress().getId());
            return ResponseEntity.ok(this.saveOrUpdate(wasteManager));
        }
    }

    private WasteManagerDTO saveOrUpdate(WasteManagerEntity wasteManager){
        WasteManagerEntity wasteManagerEntity = wasteManagerRepository.save(wasteManager);
        return mapper.map(wasteManagerEntity,WasteManagerDTO.class);
    }

    @Override
    public ResponseEntity findById(long wasteManagerId) throws Exception {
        WasteManagerEntity entity = wasteManagerRepository.findById(wasteManagerId).get();
        WasteManagerAddressDTO addressDTO = managerAddressClient.getWasteManagerAddresById(entity.getIdAddress());
        WasteManagerDTO dto = mapper.map(entity, WasteManagerDTO.class);
        dto.setManagerAddress(addressDTO);
        return ResponseEntity.ok(dto);
    }
}
