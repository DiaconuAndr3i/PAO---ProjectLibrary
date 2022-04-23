package com.springboot.system.Library.controller;


import com.springboot.system.Library.entities.Audit;
import com.springboot.system.Library.services.interfaces.AuditInterfaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditController {

    private final AuditInterfaceService auditInterfaceService;

    public AuditController(AuditInterfaceService auditInterfaceService){
        this.auditInterfaceService = auditInterfaceService;
    }

    @GetMapping("/get")
    public List<Audit> getAllRecords(){
        return this.auditInterfaceService.getAllRecords();
    }

    @PostMapping("/create")
    public Audit createRecord(@RequestBody Audit audit){
        return this.auditInterfaceService.createRecord(audit);
    }
}
