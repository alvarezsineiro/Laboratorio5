package com.example.alumno.primerparcial;

import android.util.Log;
import android.util.Xml;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumno on 09/05/2019.
 */

public class XmlParse {

    public static List<Producto> obtenerProductos(String xml){

        Myconect eje = new Myconect();
        List<Producto> list =new ArrayList<>();
        XmlPullParser parser = Xml.newPullParser();


        try {
            Producto p = null;
            parser.setInput(new StringReader(xml));
            int event = parser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT){


                if (event == XmlPullParser.START_TAG) {
                    if("producto".equals(parser.getName()))
                    {
                        p = new Producto();
                    }
                    if("nombre".equals(parser.getName())){
                        if(p != null){
                            p.setNombre(parser.nextText());
                        }
                    }
                    if("precio".equals(parser.getName())){
                        if(p != null){
                            p.setPrecio(parser.nextText());
                        }
                    }
                    if("cantidad".equals(parser.getName())){
                        if(p != null){
                            p.setCantidad(Integer.parseInt(parser.nextText()));
                        }
                    }
                }
                else if(event == XmlPullParser.END_TAG && "producto".equals(parser.getName())){
                    list.add(p);
                }


                event = parser.next();
            }
            Log.d("en try","parser");
            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
    public static void jsonparse(String json)
        {
            try
            {
                JSONObject jsonObject = new JSONObject(json);
                JSONArray frutas = jsonObject.getJSONArray("frutas");
                for(int i=0;i<frutas.length();i++)
                {
                    JSONObject fruta = frutas.getJSONObject(i);
                    String nombre = fruta.getString("nombre_fruta");
                    Integer cantidad = fruta.getInt("cantidad");
                    Log.d("json",nombre);
                    Log.d("json",""+cantidad);
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
}
