package com.api.v1.borrower.controllers

import com.api.v1.borrower.domain.Borrower
import com.api.v1.borrower.helpers.UpdateBorrowerRequestDto
import com.api.v1.borrower.services.UpdateBorrowerService
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/v1/borrowers")
class UpdateBorrowerController {

    @Autowired
    private lateinit var service: UpdateBorrowerService

    @PutMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun update(
        @PathVariable @NotNull @Size(min=9, max=9) ssn: String,
        @RequestBody @Valid request: UpdateBorrowerRequestDto
    ): Mono<Borrower> {
        return service.update(ssn, request);
    }

}