package com.deutschebank.tradestore.controller;

import com.deutschebank.tradestore.constants.Constants;
import com.deutschebank.tradestore.exception.InvalidTradeException;
import com.deutschebank.tradestore.model.Trade;
import com.deutschebank.tradestore.service.TradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TradeController {
    @Autowired
    TradeService tradeService;
    /*


     */
    @PostMapping("/trade")
    public ResponseEntity<String> tradeValidateStore(@RequestBody Trade trade){
       if(tradeService.isValid(trade)) {
           tradeService.persist(trade);
       }else{
          // return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
           throw new InvalidTradeException(trade.getTradeId()+Constants.TRADE_ID_IS_NOT_FOUND);
       }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/trade")
    public List<Trade> findAllTrades(){
        return tradeService.findAll();
    }
}
