/** Copyright 2015 Javier Montero,Diego Martin
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

public class Text_Extraction {
	private static String helpMessage = "Parametros a utilizar: "
			+ "\n-h,-help : Repeticion de este mensaje de ayuda"
			+ "\n-version: Version de la aplicacion"
			+ "\n-a,-authors: Creadores de la aplicacion"
			+ "\n-d: Procesamiento de las noticias utilizadas en la practica"
			+ "\n-f <ficheroaprocesar.txt>: Ejecucion de la aplicacion";
	public static void main(String[] args) {
		try{
			if(args.length > 0){
				if("-h".equals(args[0]) || "-help".equals(args[0])){
					System.out.println(helpMessage);
				}else if("-version".equals(args[0])){
					System.out.println("Version 1.0");
				}
				else if("-a".equals(args[0]) || "-authors".equals(args[0])){
					System.out.println("Diego Martin y Javier Montero");
				}
				else if("-d".equals(args[0]) ){
					//Categorizamos noticias de deportes
					Draft_text_categorization.news_categorization("/news_sports/news_sports_");
					
					//Categorizamos noticias de economia
					Draft_text_categorization.news_categorization("/news_economics/news_economics_");
					
					//Categorizamos noticias de politica
					Draft_text_categorization.news_categorization("/news_politics/news_politics_");
				}
				else if("-f".equals(args[0])){
					if(args.length == 2 && args[1] != null && !"".equals(args[1])){
						if(!args[1].endsWith(".txt")){
							System.out.println("El fichero debe tener formato .txt");
						}else{
							Draft_text_categorization.news_categorization(args[1]);
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

