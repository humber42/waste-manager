package cu.humberto.wastemanager.service;

import cu.humberto.wastemanager.dto.WasteManagerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface WasteManagerService {
    ResponseEntity create ( WasteManagerDTO wasteManagerDto,
                            BindingResult bindingResult ) throws Exception;
    ResponseEntity update( WasteManagerDTO dto,
                           BindingResult bindingResult ) throws Exception;
    ResponseEntity findById(long wasteManagerId) throws Exception;
}
