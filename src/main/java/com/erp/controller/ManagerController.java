package com.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erp.dto.ManagerDto;
import com.erp.entity.Manager;
import com.erp.process.ManagerProcess;

@RestController
public class ManagerController {
	@Autowired
	private ManagerProcess managerProcess;
	
	// branchCode로 매니저 조회
	@GetMapping("/mypage/{branchCode}")
	public ManagerDto getManagersByBranchCode(@PathVariable("branchCode") String branchCode) {
		Manager manager = managerProcess.getManager(branchCode);
        return ManagerDto.fromEntity(manager);
	}
    
	// 수정
	@PutMapping("/mypage/update/{branchCode}")
	public String update(@PathVariable("branchCode") String branchCode, @RequestBody ManagerDto dto) {
		dto.setBranchCode(branchCode);
	    return managerProcess.update(dto);
	}
}