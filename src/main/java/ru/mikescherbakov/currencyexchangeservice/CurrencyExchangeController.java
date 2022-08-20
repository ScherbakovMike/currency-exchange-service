package ru.mikescherbakov.currencyexchangeservice;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CurrencyExchangeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Environment environment;
    private final ExchangeValueRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")       //where {from} and {to} are path variable
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to)  //from map to USD and to map to INR
    {
        //taking the exchange value
        ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);

        //picking port from the environment
        Optional<String> port = Optional.ofNullable(environment.getProperty("local.server.port"));
        exchangeValue.setPort(Integer.parseInt(port.orElse("0")));

        logger.info("{}", exchangeValue);
        return exchangeValue;
    }
}
