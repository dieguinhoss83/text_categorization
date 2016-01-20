package main;

/** Copyright 2015 Javier Montero, Diego Martin
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

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class Text_Extraction {
	private static String helpMessage = "Parametros a utilizar: "
			+ "\n-h,-help : Repeticion de este mensaje de ayuda"
			+ "\n-version: Version de la aplicacion"
			+ "\n-a,-authors: Creadores de la aplicacion"
			+ "\n-f <ficheroaprocesar.txt>: Ejecucion de la aplicacion";
	public static void main(String[] args) {
		try{
			if(args.length > 0){
				if(args[0] == "-h" || args[0] == "-help"){
					System.out.println(helpMessage);
				}else if(args[0] == "-version"){
					System.out.println("Version 1.0");
				}
				else if(args[0] == "-a" || args[0] == "-authors"){
					System.out.println("Diego Martín y Javier Montero");
				}
				else if("-f".equals(args[0])){
					if(args.length == 2 && args[1] != null && !"".equals(args[1])){
						//2.1) eliminar las stop_words del documento
						//Obtenemos el documento que queremos categorizar
						Map<String, Integer> docWithWeights = Draft_text_categorization.docToMap(new FileInputStream(new File(args[1])));
						
						/** 2.3) se categoriza el Documento
						 *			2.3.1) se calcula la similaridad numérica entre cada “documento query (Q)” (vector/set) y cada vector 
						 *					documento en la colección (Di):
							
											Sim(Q; Di) = SUM(qj*dij) para los términos comunes tj
							
										donde:
										tj → término presente en Q y Di
										qj → peso del término tj en Q
										dij → peso del término tj en Di
										
										for(glosario : lista_glosarios){
											double similaridad = cosine_similarity(Map v1, Map v2);
											syso(similaridad);
										}
						*/
						Map<String, Integer> glossWithWeights = new HashMap<String,Integer>();
						double similaridad = 0.0;
						
						for(int i=1; i<4; i++){
							glossWithWeights = Draft_text_categorization.docToMap(StopWords.class.getResourceAsStream("/clippings/glosario_"+i+".txt"));
							similaridad = Draft_text_categorization.cosine_similarity(docWithWeights, glossWithWeights);
							
							System.out.println("Similaridad con glosario_"+i+" = "+similaridad);
						}
					}else{
						System.out.println(helpMessage);
					}
				}
			}else{
				System.out.println(helpMessage);
			}
		}catch(Exception e){
			System.out.println("Un error inesperado ocurrió durante la ejecución. Mensaje: "+e.getMessage());
		}
	}
}
