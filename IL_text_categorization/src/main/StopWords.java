/** Copyright 2015 Diego Martin,Javier Montero
	Licensed under the Apache License, Version 2.0 (the "License"); 
	you may not use this file except in compliance with the License. 
	You may obtain a copy of the License at 
	
	http://www.apache.org/licenses/LICENSE-2.0 
	
	Unless required by applicable law or agreed to in writing, software 
	distributed under the License is distributed on an "AS IS" BASIS, 
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
	See the License for the specific language governing permissions and 
	limitations under the License. 
*/

package main;

public class StopWords {


	public StopWords() {
		// TODO Auto-generated constructor stub
	}
	
	public static String[] stop_words = "a,actualmente,acuerdo,adelante,ademas,adem�s,adrede,afirm�,agreg�,ahi,ahora,ahi,al,algo,alguna,algunas,alguno,algunos,alg�n,alli,alli,alrededor,ambos,ampleamos,antano,anta�o,ante,anterior,antes,apenas,aproximadamente,aquel,aquella,aquellas,aquello,aquellos,aqui,aqu�l,aqu�lla,aqu�llas,aqu�llos,aqui,arriba,arribaabajo,asegur�,asi,asi,atras,aun,aunque,ayer,a�adi�,a�n,b,bajo,bastante,bien,breve,buen,buena,buenas,bueno,buenos,c,cada,casi,cerca,cierta,ciertas,cierto,ciertos,cinco,claro,coment�,como,con,conmigo,conocer,conseguimos,conseguir,considera,consider�,consigo,consigue,consiguen,consigues,contigo,contra,cosas,creo,cual,cuales,cualquier,cuando,cuanta,cuantas,cuanto,cuantos,cuatro,cuenta,cu�l,cu�les,cu�ndo,cu�nta,cu�ntas,cu�nto,cu�ntos,c�mo,d,da,dado,dan,dar,de,debajo,debe,deben,debido,decir,dej�,del,delante,demasiado,dem�s,dentro,deprisa,desde,despacio,despues,despu�s,detras,detr�s,dia,dias,dice,dicen,dicho,dieron,diferente,diferentes,dijeron,dijo,dio,donde,dos,durante,dia,dias,d�nde,e,ejemplo,el,ella,ellas,ello,ellos,embargo,empleais,emplean,emplear,empleas,empleo,en,encima,encuentra,enfrente,enseguida,entonces,entre,era,eramos,eran,eras,eres,es,esa,esas,ese,eso,esos,esta,estaba,estaban,estado,estados,estais,estamos,estan,estar,estar�,estas,este,esto,estos,estoy,estuvo,est�,est�n,ex,excepto,existe,existen,explic�,expres�,f,fin,final,fue,fuera,fueron,fui,fuimos,g,general,gran,grandes,gueno,h,ha,haber,habia,habla,hablan,habr�,habia,habian,hace,haceis,hacemos,hacen,hacer,hacerlo,haces,hacia,haciendo,hago,han,hasta,hay,haya,he,hecho,hemos,hicieron,hizo,horas,hoy,hubo,i,igual,incluso,indic�,informo,inform�,intenta,intentais,intentamos,intentan,intentar,intentas,intento,ir,j,junto,k,l,la,lado,largo,las,le,lejos,les,lleg�,lleva,llevar,lo,los,luego,lugar,m,mal,manera,manifest�,mas,mayor,me,mediante,medio,mejor,mencion�,menos,menudo,mi,mia,mias,mientras,mio,mios,mis,misma,mismas,mismo,mismos,modo,momento,mucha,muchas,mucho,muchos,muy,m�s,mi,mia,mias,mio,mios,n,nada,nadie,ni,ninguna,ningunas,ninguno,ningunos,ning�n,no,nos,nosotras,nosotros,nuestra,nuestras,nuestro,nuestros,nueva,nuevas,nuevo,nuevos,nunca,o,ocho,os,otra,otras,otro,otros,p,pais,para,parece,parte,partir,pasada,pasado,pa�s,peor,pero,pesar,poca,pocas,poco,pocos,podeis,podemos,poder,podria,podriais,podriamos,podrian,podrias,podr�,podr�n,podria,podrian,poner,por,porque,posible,primer,primera,primero,primeros,principalmente,pronto,propia,propias,propio,propios,proximo,pr�ximo,pr�ximos,pudo,pueda,puede,pueden,puedo,pues,q,qeu,que,qued�,queremos,quien,quienes,quiere,quiza,quizas,quiz�,quiz�s,qui�n,qui�nes,qu�,r,raras,realizado,realizar,realiz�,repente,respecto,s,sabe,sabeis,sabemos,saben,saber,sabes,salvo,se,sea,sean,segun,segunda,segundo,seg�n,seis,ser,sera,ser�,ser�n,seria,se�al�,si,sido,siempre,siendo,siete,sigue,siguiente,sin,sino,sobre,sois,sola,solamente,solas,solo,solos,somos,son,soy,soyos,su,supuesto,sus,suya,suyas,suyo,s�,si,s�lo,t,tal,tambien,tambi�n,tampoco,tan,tanto,tarde,te,temprano,tendr�,tendr�n,teneis,tenemos,tener,tenga,tengo,tenido,tenia,tercera,ti,tiempo,tiene,tienen,toda,todas,todavia,todavia,todo,todos,total,trabaja,trabajais,trabajamos,trabajan,trabajar,trabajas,trabajo,tras,trata,trav�s,tres,tu,tus,tuvo,tuya,tuyas,tuyo,tuyos,t�,u,ultimo,un,una,unas,uno,unos,usa,usais,usamos,usan,usar,usas,uso,usted,ustedes,v,va,vais,valor,vamos,van,varias,varios,vaya,veces,ver,verdad,verdadera,verdadero,vez,vosotras,vosotros,voy,vuestra,vuestras,vuestro,vuestros,w,x,y,ya,yo,z,�l,�sa,�sas,�se,�sos,�sta,�stas,�ste,�stos,�ltima,�ltimas,�ltimo,�ltimos".toLowerCase().split(",");

	public static String[] getStop_words() {
		return stop_words;
	}

	public static void setStop_words(String[] stop_words) {
		StopWords.stop_words = stop_words;
	}

	
}
