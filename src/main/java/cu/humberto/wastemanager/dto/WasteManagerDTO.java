package cu.humberto.wastemanager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WasteManagerDTO {
    private Long id;
    @NotBlank(message="El nombre es obligatorio")
    private String nombre;
    @NotBlank(message="El NIF es obligatorio")
    private String nif;
    @Valid
    private List<WasteCenterAuthorizationDTO> wasteCenterAuthorizationList;
    private WasteManagerAddressDTO managerAddress;
    private Long version;
}
