package com.example.alumno.primerparcial;

import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by alumno on 09/05/2019.
 */

public class Myconect {


    public Myconect() {
    }
    public String getString(String s)
    {

        try {
            URL url =new URL(s);
            HttpURLConnection conect = (HttpURLConnection) url.openConnection();
            conect.setRequestMethod("GET");
            conect.connect();
            int res = conect.getResponseCode();

            if (res==200)
            {
                InputStream is =conect.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] aux =new byte[1024];
                int leng=0;

                while ((leng = is.read(aux))!=-1)
                {
                    baos.write(aux, 0, leng);
                }

                is.close();
                String respuesta= new String(baos.toByteArray());
                Log.d("asdad",respuesta);
                return respuesta;
            }
            else {
                throw new Exception("Fallo conexion");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("despues try","conect");
        return s;
    }

    /*public byte[] metodoimagen (String s)
    {
        try {
            URL url =new URL(s);
            HttpURLConnection conect = (HttpURLConnection) url.openConnection();
            conect.setRequestMethod("GET");
            conect.connect();
            int res = conect.getResponseCode();
            if (res==200)
            {
                InputStream is =conect.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] aux =new byte[1024];
                int leng=0;

                while ((leng = is.read(aux))!=-1)
                {
                    baos.write(aux, 0, leng);
                }

                is.close();
                return baos.toByteArray();
            }
            else {
                throw new Exception("Fallo coneccion");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/
}
