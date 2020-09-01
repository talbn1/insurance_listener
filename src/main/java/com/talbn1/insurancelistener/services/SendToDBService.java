package com.talbn1.insurancelistener.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author talbn on 8/27/2020
 **/

@Service
@NoArgsConstructor
public class SendToDBService {


    public static String excutePost(String jsonInputString)
    {
        HttpURLConnection connection = null;
        try {
            URL url = new URL ("http://localhost:8083/api/save");
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setUseCaches (false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            try(OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuilder response = new StringBuilder();
            while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();

        }catch (ProtocolException | UnsupportedEncodingException Exception){
            Exception.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }
}
