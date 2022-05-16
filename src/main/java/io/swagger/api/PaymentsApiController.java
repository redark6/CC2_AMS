package io.swagger.api;

import io.swagger.model.Payment;
import io.swagger.model.PaymentResponse;
import io.swagger.model.PaymentResponseDTO;
import io.swagger.model.UniquePaymentKey;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.repository.PaymentRedisRepository;
import io.swagger.service.PaymentRedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@EnableCaching
@ImportAutoConfiguration(classes = {
        CacheAutoConfiguration.class,
})
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-16T06:10:14.366Z")
@Configuration
@Controller
public class PaymentsApiController implements PaymentsApi {

    private static final Logger log = LoggerFactory.getLogger(PaymentsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final PaymentRedisService paymentRedis;

    @org.springframework.beans.factory.annotation.Autowired
    public PaymentsApiController(ObjectMapper objectMapper, HttpServletRequest request, PaymentRedisService paymentRedis) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.paymentRedis = paymentRedis;
    }

    public ResponseEntity<UniquePaymentKey> obtainKey() {
        UniquePaymentKey key = new UniquePaymentKey();
        key.setKey(UUID.randomUUID().toString());
        return new ResponseEntity<UniquePaymentKey>(key,HttpStatus.OK);
    }

    public ResponseEntity<PaymentResponseDTO> processPayment(@ApiParam(value = "The unique payment key to make action idempotent",required=true) @PathVariable("payment_unique_key") String paymentUniqueKey, @ApiParam(value = "Payment object that needs to be processed" ,required=true )  @Valid @RequestBody Payment body) {
        Optional<PaymentResponse> savedResponse = this.paymentRedis.findById(paymentUniqueKey);
        if(savedResponse.isPresent() && savedResponse.get().getStatus() != PaymentResponse.StatusEnum.ERROR){
            PaymentResponseDTO response = new PaymentResponseDTO(savedResponse.get());
            return new ResponseEntity(response,HttpStatus.OK);
        }else {
            PaymentResponse paymentResponse = new PaymentResponse();
            paymentResponse.setPaymentId(paymentUniqueKey);
            paymentResponse.setDate(LocalDateTime.now().toString());
            if(body.getCheckoutId() == null){
                paymentResponse.setStatus(paymentResponse.getStatus().ERROR);
                paymentResponse.setResultat("C'est pas bon tout ça. comme je savais pas quoi mettre dans resultat en tant qu'objet alors j'ai mis cette string à la place");
            } else{
                paymentResponse.setStatus(paymentResponse.getStatus().SUCCESS);
                paymentResponse.setResultat("Tout roules, les payment ont correctement été fait");
            }
            // for the payment i make it synchronous but we can make it asnchronous with "processing"
            // it is much better than the synchronous way but for this part we want synchronous
            // so if you give a null checkoutid it will give the error status for the "proof of concept" but it should be up to the service to do thsi work normaly
            // for the asynchronous way we suppose this payment object will be modified in the cache and DB after the success / failure of the request
            // the associated service should save the payment response to keep it in database ( simulation )
            this.paymentRedis.save(paymentResponse);
            PaymentResponseDTO response = new PaymentResponseDTO(paymentResponse);
            return new ResponseEntity<PaymentResponseDTO>(response,HttpStatus.CREATED);
        }
    }

}
