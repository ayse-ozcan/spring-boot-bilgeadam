package com.ayseozcan.service;

import com.ayseozcan.dto.request.ActivateStatusRequestDto;
import com.ayseozcan.dto.request.CardDetailsSaveRequestDto;
import com.ayseozcan.dto.request.CustomerLoginRequestDto;
import com.ayseozcan.dto.request.CustomerRegisterRequestDto;
import com.ayseozcan.dto.response.CustomerFindAllResponseDto;
import com.ayseozcan.dto.response.CustomerRegisterResponseDto;
import com.ayseozcan.exception.ErrorType;
import com.ayseozcan.exception.YemekSepetiException;
import com.ayseozcan.mapper.ICustomerMapper;
import com.ayseozcan.repository.ICustomerRepository;
import com.ayseozcan.repository.entity.CardDetail;
import com.ayseozcan.repository.entity.Customer;
import com.ayseozcan.repository.enums.EStatus;
import com.ayseozcan.utility.CodeGenerator;
import com.ayseozcan.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService extends ServiceManager<Customer, Long> {
    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        super(customerRepository);
        this.customerRepository = customerRepository;
    }

    public CustomerRegisterResponseDto register(CustomerRegisterRequestDto dto) {
        Customer customer = ICustomerMapper.INSTANCE.fromRegisterDto(dto);
        Optional<Customer> optionalCustomer = customerRepository.findOptionalByEmail(dto.getEmail());
        if (optionalCustomer.isEmpty()) {
            customer.setActivationCode(CodeGenerator.generateCode());
            customerRepository.save(customer);
        } else {
            throw new YemekSepetiException(ErrorType.CUSTOMER_ALREADY_EXIST);
        }
        return CustomerRegisterResponseDto.builder().activationCode(customer.getActivationCode()).build();
    }

    public Boolean login(CustomerLoginRequestDto dto) {
        Optional<Customer> optionalCustomer = customerRepository.findOptionalByEmailIgnoreCaseAndPassword(dto.getEmail(), dto.getPassword());
        if (optionalCustomer.isEmpty() || !optionalCustomer.get().getStatus().equals(EStatus.ACTIVE)) {
            throw new YemekSepetiException(ErrorType.CUSTOMER_NOT_FOUND);
        } else {
            return true;
        }
    }

    public Boolean activateStatus(ActivateStatusRequestDto dto) {
        Optional<Customer> optionalCustomer = customerRepository.findOptionalByActivationCode(dto.getActivationCode());
        if (optionalCustomer.isEmpty()) {
            throw new YemekSepetiException(ErrorType.INVALID_ACTIVATION_CODE);
        } else {
            optionalCustomer.get().setStatus(EStatus.ACTIVE);
            update(optionalCustomer.get());
            return true;
        }
    }
    public List<CustomerFindAllResponseDto> findAllDto() {
        return customerRepository.findAll().stream()
                .map(x -> CustomerFindAllResponseDto.builder().name(x.getName()).surname(x.getSurname())
                        .address(x.getAddress()).email(x.getEmail())
                        .phoneNumber(x.getPhoneNumber())
                        .build()).toList();
    }

}
