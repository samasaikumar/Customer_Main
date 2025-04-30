package com.details.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.details.constants.Constants;
import com.details.dto.CustomerDto;
import com.details.dto.SuccessResponseDto;
import com.details.service.IAccountsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@RestController
//@RequestMapping(path = "/api")

@Validated
@Tag(
		name="CURD REST API FOR SBI MICROSERVICES",
		description = "it perform opertions like create delete etc"
		)
public class AccountsController {
	private IAccountsService iAccountsService;
	
	public AccountsController(IAccountsService iAccountsService) {
		super();
		this.iAccountsService = iAccountsService;
	}




  @PostMapping("/create")
  @Operation(
		  summary = "Create Account Rest API",
		  description = "This api create new account "
		  )
  @ApiResponse(
		  responseCode = "201",
		  description = "HTTP status created",
		  //content is ussed to display the successResponseDTo in Swagger Docs
		  content = @Content(
				  schema = @Schema(implementation = SuccessResponseDto.class)
				  )
		  )
 
	public ResponseEntity<String> creteAccount(@Valid @RequestBody CustomerDto customerDto)
	{
	   iAccountsService.createAccount(customerDto);
		return new ResponseEntity<String>(Constants.SAVING,HttpStatus.CREATED);
	}
  
//  @GetMapping("/fetch")
//  public ResponseEntity<CustomerDto> fetchDetails(@RequestParam String mobileNum)
//  {
//	  CustomerDto fetchAccountdetails = iAccountsService.fetchAccountdetails(mobileNum);
//	  
//	  return ResponseEntity.status(HttpStatus.OK).body(fetchAccountdetails);
//	  
//  }
//  
  //@PutMapping("/update")
//  public ResponseEntity<String> updateDetails(@RequestBody CustomerDto customerDto)
//  {
//	  boolean updateAccount = iAccountsService.updateAccount(customerDto);
//	  if(updateAccount)
//	  {
//		  return new ResponseEntity<String>(Constants.STATUS_MGS200,HttpStatus.OK);
//	  }
//	  else
//	  {
//		  return new ResponseEntity<String>(Constants.STATUS_MGS200,HttpStatus.BAD_REQUEST);
//		  
//	  }
//  }

  
  @DeleteMapping("/delete")
  public ResponseEntity<String> deleteAccountdetails(@RequestParam 
		  @Pattern(regexp = "^$|[0-9]{10}",message = "Enter valis mobile number") String mobileNum)
  {
	  boolean deleteAccount = iAccountsService.deleteAccount(mobileNum);
	  if(deleteAccount)
	  {
		  return new ResponseEntity<String >(Constants.STATUS_MGS200,HttpStatus.OK);
	  }
	  else
	  {
		  return new ResponseEntity<String >(Constants.STATUS_MGS500,HttpStatus.BAD_REQUEST);
	  }
	  
  }
}
