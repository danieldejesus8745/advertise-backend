package com.advertise.controllers;

import com.advertise.dto.OfferDTO;
import com.advertise.services.OfferService;
import com.advertise.utils.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/offers")
public class OfferController {

    private final OfferService offerService;

    @PostMapping
    public ResponseModel addOffer(@RequestBody OfferDTO offerDTO) {
        return offerService.addOffer(offerDTO);
    }

}
