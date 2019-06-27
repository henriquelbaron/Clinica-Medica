/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.server;

import br.com.clinica.domain.Endereco;
import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Clony
 */
public class EnderecoDaoServer {

    private static final String BASE_URL = "https://viacep.com.br/ws/";
    private static final String sufix = "/json/";

    public static Endereco getEndereco(String cep) {
        String url = BASE_URL + cep + sufix;

        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpget = new HttpGet(url);
        HttpResponse response;
        Endereco endereco = null;
        Gson gson = new Gson();
        try {
            response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);

            endereco = gson.fromJson(content, Endereco.class);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            endereco = null;
        }

        return endereco;
    }

}
