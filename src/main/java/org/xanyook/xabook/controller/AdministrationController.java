package org.xanyook.xabook.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xanyook.xabook.service.model.Documentation;
import org.xanyook.xabook.service.model.VersionApplication;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("admin")
@Api("Administration Web Services")
public class AdministrationController {

    private VersionApplication versionApplication;

    @Autowired
    public AdministrationController(final VersionApplication versionApplication) {
        super();
        this.versionApplication = versionApplication;
    }

    @ApiOperation(value = "Get the application's informations", notes = "Allow user to be aware of which application context he is dealing with")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = Documentation.GET_200_DESCRIPTION, response = VersionApplication.class),
            @ApiResponse(code = 500, message = Documentation.INTERNAL_ERROR_500_DESCRIPTION)})
    @GetMapping(value = "application/informations", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<VersionApplication> getApplicationInformations() {
        return ok(versionApplication);
    }
}
