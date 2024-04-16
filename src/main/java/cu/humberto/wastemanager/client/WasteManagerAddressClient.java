package cu.humberto.wastemanager.client;

import cu.humberto.wastemanager.dto.WasteManagerAddressDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://localhost/address",name = "address")
public interface WasteManagerAddressClient {
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    WasteManagerAddressDTO getWasteManagerAddresById(@PathVariable("id") long id);
}
