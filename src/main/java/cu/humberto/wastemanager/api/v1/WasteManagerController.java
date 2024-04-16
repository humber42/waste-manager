package cu.humberto.wastemanager.api.v1;

import cu.humberto.wastemanager.dto.WasteManagerDTO;
import cu.humberto.wastemanager.service.WasteManagerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
@RequiredArgsConstructor
public class WasteManagerController {
    private final WasteManagerService wasteManagerService;

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") long id) throws Exception {
        return wasteManagerService.findById(id);
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody @Valid WasteManagerDTO wasteManager, BindingResult bindingResult) throws Exception{
        return wasteManagerService.create(wasteManager,bindingResult);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody @Valid WasteManagerDTO wasteManager, BindingResult bindingResult) throws Exception{
        return wasteManagerService.update(wasteManager,bindingResult);
    }
}
