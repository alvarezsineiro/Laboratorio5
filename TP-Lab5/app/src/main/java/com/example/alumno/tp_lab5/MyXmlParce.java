package com.example.alumno.tp_lab5;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
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
            Noticia n = null;
            parser.setInput(new StringReader(xml));
            int event = parser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT){


                if (event == XmlPullParser.START_TAG) {
                    if("item".equals(parser.getName()))
                    {
                        n = new Noticia();
                    }
                    if("title".equals(parser.getName())){
                        if(n != null){
                            n.setTitulo(parser.nextText());
                        }
                    }
                    if("description".equals(parser.getName())){
                        if(n != null){
                            n.setDescripcion(parser.nextText().replace("/n","").replace("|",""));
                        }
                    }
                    if("link".equals(parser.getName())){
                        if(n != null){
                            n.setUrl(parser.nextText());
                        }
                    }
                    if("image".equals(parser.getName())){
                        if(n != null){
                            n.setImagenUrl(parser.nextText());
                            //n.setImagen(eje.metodoimagen(n.getImagenUrl()));
                        }
                    }

                    if("enclosure".equals(parser.getName())){
                        if(n != null){
                            n.setImagenUrl(parser.getAttributeValue(null,"url"));
                            if (n.getImagenUrl().equals(null))
                            {
                                n.setImagenUrl("https://www.google.com.ar/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png");
                            }
                            else
                            {
                                n.setImagen(eje.metodoimagen(n.getImagenUrl()));
                            }

                        }
                    }
                    if("pubDate".equals(parser.getName())){
                        if(n != null){
                            n.setFecha(new Date( parser.nextText()));
                        }
                    }
                }
                else if(event == XmlPullParser.END_TAG && "item".equals(parser.getName())){
                    list.add(n);
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
