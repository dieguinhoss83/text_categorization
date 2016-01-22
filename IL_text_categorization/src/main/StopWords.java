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
	
	public static String[] stop_words = "a,actualmente,acuerdo,adelante,ademas,además,adrede,afirmó,agregó,ahi,ahora,ahi,al,algo,alguna,algunas,alguno,algunos,algún,alli,alli,alrededor,ambos,ampleamos,antano,antaño,ante,anterior,antes,apenas,aproximadamente,aquel,aquella,aquellas,aquello,aquellos,aqui,aquél,aquélla,aquéllas,aquéllos,aqui,arriba,arribaabajo,aseguró,asi,asi,atras,aun,aunque,ayer,añadió,aún,b,bajo,bastante,bien,breve,buen,buena,buenas,bueno,buenos,c,cada,casi,cerca,cierta,ciertas,cierto,ciertos,cinco,claro,comentó,como,con,conmigo,conocer,conseguimos,conseguir,considera,consideró,consigo,consigue,consiguen,consigues,contigo,contra,cosas,creo,cual,cuales,cualquier,cuando,cuanta,cuantas,cuanto,cuantos,cuatro,cuenta,cuál,cuáles,cuándo,cuánta,cuántas,cuánto,cuántos,cómo,d,da,dado,dan,dar,de,debajo,debe,deben,debido,decir,dejó,del,delante,demasiado,demás,dentro,deprisa,desde,despacio,despues,después,detras,detrás,dia,dias,dice,dicen,dicho,dieron,diferente,diferentes,dijeron,dijo,dio,donde,dos,durante,dia,dias,dónde,e,ejemplo,el,ella,ellas,ello,ellos,embargo,empleais,emplean,emplear,empleas,empleo,en,encima,encuentra,enfrente,enseguida,entonces,entre,era,eramos,eran,eras,eres,es,esa,esas,ese,eso,esos,esta,estaba,estaban,estado,estados,estais,estamos,estan,estar,estará,estas,este,esto,estos,estoy,estuvo,está,están,ex,excepto,existe,existen,explicó,expresó,f,fin,final,fue,fuera,fueron,fui,fuimos,g,general,gran,grandes,gueno,h,ha,haber,habia,habla,hablan,habrá,habia,habian,hace,haceis,hacemos,hacen,hacer,hacerlo,haces,hacia,haciendo,hago,han,hasta,hay,haya,he,hecho,hemos,hicieron,hizo,horas,hoy,hubo,i,igual,incluso,indicó,informo,informó,intenta,intentais,intentamos,intentan,intentar,intentas,intento,ir,j,junto,k,l,la,lado,largo,las,le,lejos,les,llegó,lleva,llevar,lo,los,luego,lugar,m,mal,manera,manifestó,mas,mayor,me,mediante,medio,mejor,mencionó,menos,menudo,mi,mia,mias,mientras,mio,mios,mis,misma,mismas,mismo,mismos,modo,momento,mucha,muchas,mucho,muchos,muy,más,mi,mia,mias,mio,mios,n,nada,nadie,ni,ninguna,ningunas,ninguno,ningunos,ningún,no,nos,nosotras,nosotros,nuestra,nuestras,nuestro,nuestros,nueva,nuevas,nuevo,nuevos,nunca,o,ocho,os,otra,otras,otro,otros,p,pais,para,parece,parte,partir,pasada,pasado,paìs,peor,pero,pesar,poca,pocas,poco,pocos,podeis,podemos,poder,podria,podriais,podriamos,podrian,podrias,podrá,podrán,podria,podrian,poner,por,porque,posible,primer,primera,primero,primeros,principalmente,pronto,propia,propias,propio,propios,proximo,próximo,próximos,pudo,pueda,puede,pueden,puedo,pues,q,qeu,que,quedó,queremos,quien,quienes,quiere,quiza,quizas,quizá,quizás,quién,quiénes,qué,r,raras,realizado,realizar,realizó,repente,respecto,s,sabe,sabeis,sabemos,saben,saber,sabes,salvo,se,sea,sean,segun,segunda,segundo,según,seis,ser,sera,será,serán,seria,señaló,si,sido,siempre,siendo,siete,sigue,siguiente,sin,sino,sobre,sois,sola,solamente,solas,solo,solos,somos,son,soy,soyos,su,supuesto,sus,suya,suyas,suyo,sé,si,sólo,t,tal,tambien,también,tampoco,tan,tanto,tarde,te,temprano,tendrá,tendrán,teneis,tenemos,tener,tenga,tengo,tenido,tenia,tercera,ti,tiempo,tiene,tienen,toda,todas,todavia,todavia,todo,todos,total,trabaja,trabajais,trabajamos,trabajan,trabajar,trabajas,trabajo,tras,trata,través,tres,tu,tus,tuvo,tuya,tuyas,tuyo,tuyos,tú,u,ultimo,un,una,unas,uno,unos,usa,usais,usamos,usan,usar,usas,uso,usted,ustedes,v,va,vais,valor,vamos,van,varias,varios,vaya,veces,ver,verdad,verdadera,verdadero,vez,vosotras,vosotros,voy,vuestra,vuestras,vuestro,vuestros,w,x,y,ya,yo,z,él,ésa,ésas,ése,ésos,ésta,éstas,éste,éstos,última,últimas,último,últimos".toLowerCase().split(",");

	public static String[] getStop_words() {
		return stop_words;
	}

	public static void setStop_words(String[] stop_words) {
		StopWords.stop_words = stop_words;
	}

	
}
