package com.pedapp.pedapp.pedapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.pedapp.pedapp.pedapp.Utilities.Utilities;


public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    // final String CREATE_TABLE_PLAYERS = "CREATE TABLE Players (id INTEGER, nombre TEXT, genero TEXT)";

    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String[] arrChallenge;
        String[] arrRespond;
        Integer [] fromuser;
        Integer[] category;
        db.execSQL(Utilities.CREATE_TABLE_PLAYERS);
        db.execSQL(Utilities.CREATE_TABLE_CHALLENGE);

         int numero = (int) (Math.random() * 6) + 1;
        //Insert de Retos de Categoria 1
        category = new Integer[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
        arrChallenge = new String[] {"¿Estas en una Relación?","¿Quién fue la ultima persona que besaste?","¿En dónde fue tu primer beso?","¿Quien fue tu primer amor?","Menciona la primera vez que te rompieron el corazón","¿Alguna vez has sido infiel?","¿Alguna vez besaste a alguien de tu mismo Sexo?"     ,"Canción favorita de Reggeaton","Alguna vez le dijiste a alguien que lo amabas sin sentirlo","Alguna vez pensaste en engañar a tu pareja","¿Cuanto tiempo has durado soltero?","Si pudieras estar en algún lugar del mundo, ¿En Donde estarías?","Si tuvieras un deseo, ¿Que desearías?","¿Como seria tu cita perfecta?","Si pudieras andar con un famoso, ¿con cual seria?","Alguna vez aplicaste ‘Es que no encuentro mi cartera’ para no pagar la cuenta","¿Quien de los jugadores es el mas guap@?","¿Cual es la la Apuesta mas estupida que has hecho?","¿Cual es la cosa mas infantil que aun haces?","¿Cual es la técnica de ligue que mas te funcióna?","El/La elegid@ para tomar es:","La persona que elige quien toma es:","Todos toman","El/La mas viej@ toma","El/La mas joven toma","El/La mas pendej@ toma \n(Si no sabes quien es eres tu)","La/El mas zorr@ toma","El/La mas culo toma","Baila con los calzones arriba del pantalon","Cuenta un secreto que nadie sabe","Enseñale tu pie a todos"                              ,"Echate un hidalgo (shot)","El/La mas mandilon/na"                             ,"Yo nunca nunca express","Cuenta hasta " + numero + ", y ese toma","El mas malacopa toma"                               ,"REVERSA, cambia el sentido del Juego","Haz un Reversazo","Fondo a tu bebida","Canta un pedacito de Salvame"};
        arrRespond = new String[] {"Vamos a empezar de Cobardes","Seguro fue tu tio","Seguro no lo has dado","No Es tiempo de superarlo"                               ,"Te volvera a pasar"                                 ,"Rata de dos patas"           ,"El amor es muy bonito como para tenerlo en un closet","Ahh pero en el 2006...."      ,"Animal Rastero, Escoria de la vida"                        ,"Perro infiel"                              ,"Que haces aqui vete a Tinder"      ,"El closet no cuenta"                                            ,"¿Deseas mas Alcohol?"                 ,"¿Al menos has tenido una?"    ,"Chabelo no cuenta"                                ,"Miua, no seas gat@"                                                           ,"Ya dicelo"                               ,"¿Perdiste algo mas que el dinero?"                 ,"Te da pena tenerle miedo a la obscuridad"    ,"Tinder no cuenta"                                 ,"Si el no quido tomas tu"     ,"El pisto es de quien lo trabaja"    ,"Dejen de jugar y vallanse a dormir","Crecer duele","Almenos tienes la edad para tomar","Por culpa del pendejo"      ,"Se esta mensajeando con el/la Novi@ de tu amig@","Por algo es el culo","Super man esta decepcionado de ti"    ,"Buen amigo eres"                 ,"Tan grande es el Juanete, un pedicure te vendria bien","Felicidades no eres un chavoruco","Van a cortar","El que nada debe, nada teme","¿Que haces juagando?","Nos has salvado, estamos agradecidos","Para que juegas, si no me vas hacer caso","Seguro se te tuerce la reversa","Si no es fondo, igual te la vas a acabar","Sabias que RBD lleno un estadio mas que Los Beatles en brazil"};
        fromuser = new Integer[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        insertArrayChallenges(db,category, arrChallenge,arrRespond, fromuser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Players");
        onCreate(db);
    }

    public void insertArrayChallenges(SQLiteDatabase db,Integer [] category, String [] arrChallenge, String [] arrRespond, Integer[] fromuser){

        for(int i = 0; i < arrChallenge.length;i++) {
            ContentValues values = new ContentValues();
            values.put(Utilities.FIELD_CATEGORY, category[i]);
            values.put(Utilities.FIELD_CHALLENGE, arrChallenge[i]);
            values.put(Utilities.FIELD_RESPOND, arrRespond[i]);
            values.put(Utilities.FIELD_FROMUSER, fromuser[i]);
            Long res = db.insert(Utilities.TABLE_CHALLENGE, Utilities.FIELD_CHALLENGE, values);
            Log.d("Registry ID: ", String.valueOf(res));
        }
    }
}
