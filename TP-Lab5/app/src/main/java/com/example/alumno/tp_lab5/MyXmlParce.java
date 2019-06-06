package com.example.alumno.tp_lab5;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agus on 4/6/2019.
 */

public class MyXmlParce {


    public static List<Noticia> obtenerNoticias(String xml){

        MyConect eje = new MyConect();
        List<Noticia> list =new ArrayList<>();
        XmlPullParser parser = Xml.newPullParser();


        try {
            Noticia p = null;
            parser.setInput(new StringReader(xml));
            int event = parser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT){


                if (event == XmlPullParser.START_TAG) {
                    if("item".equals(parser.getName()))
                    {
                        p = new Noticia();
                    }
                    if("title".equals(parser.getName())){
                        if(p != null){
                            p.setTitulo(parser.nextText());
                        }
                    }
                    if("description".equals(parser.getName())){
                        if(p != null){
                            p.setDescripcion(parser.nextText());
                        }
                    }
                    if("link".equals(parser.getName())){
                        if(p != null){
                            p.setUrl(parser.nextText());
                        }
                    }
                    if("image".equals(parser.getName())){
                        if(p != null){
                            p.setImagenUrl(parser.nextText());
                            p.setImagen(eje.metodoimagen(p.getImagenUrl()));
                        }
                    }
                }
                else if(event == XmlPullParser.END_TAG && "item".equals(parser.getName())){
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
}
