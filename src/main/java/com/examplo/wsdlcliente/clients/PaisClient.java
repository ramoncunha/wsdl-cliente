package com.examplo.wsdlcliente.clients;

import com.exemplo.wsdlcliente.wsdl.GetPaisRequest;
import com.exemplo.wsdlcliente.wsdl.GetPaisResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Slf4j
public class PaisClient extends WebServiceGatewaySupport {

    public GetPaisResponse getPais(String pais) {
        GetPaisRequest request = new GetPaisRequest();
        request.setNome(pais);

        log.info("Obtendo dados sobre: " + pais);

        GetPaisResponse response = (GetPaisResponse) getWebServiceTemplate()
            .marshalSendAndReceive("http://localhost:8080/ws/paises", request,
                new SoapActionCallback("http://localhost:8080/wsdlservidor/assets/GetPaisRequest"));

        return response;
    }

}
