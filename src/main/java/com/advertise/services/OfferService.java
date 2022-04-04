package com.advertise.services;

import com.advertise.dto.OfferDTO;
import com.advertise.entities.Offer;
import com.advertise.repositories.OfferRepository;
import com.advertise.utils.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class OfferService {

    private final OfferRepository offerRepository;

    public ResponseModel addOffer(OfferDTO offerDTO) {
        Offer offer = new Offer();
        offer.setOfferDesc(offerDTO.getOfferDesc());
        offer.setPrice(offerDTO.getPrice());
        offer.setOwner(offerDTO.getOwner());
        offer.setPost(offerDTO.getPost());
        offer.setCreatedAt(LocalDate.now());

        offerRepository.save(offer);

        return new ResponseModel(200, "Oferta enviada com sucesso");
    }

}
