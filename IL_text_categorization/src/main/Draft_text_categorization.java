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


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

import org.apache.commons.io.IOUtils;

public class Draft_text_categorization {

	/**
	 * 
	 */
	public Draft_text_categorization() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * http://stackoverflow.com/questions/3622112/vector-space-model-algorithm-in-java-to-get-the-similarity-score-between-two-peo
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	static double cosine_similarity(Map<String, Integer> v1, Map<String, Integer> v2) {
		Set<String> both = new HashSet<String>(v1.keySet());
        both.retainAll(v2.keySet());
        double sclar = 0, norm1 = 0, norm2 = 0;
        
        for (String k : both) 
        	sclar += v1.get(k) * v2.get(k);
        for (String k : v1.keySet()) 
        	norm1 += v1.get(k) * v1.get(k);
        for (String k : v2.keySet()) 
        	norm2 += v2.get(k) * v2.get(k);
        return sclar / Math.sqrt(norm1 * norm2);
	}
	
	/**
	 * 
	 * 
	 * @param in
	 * @return
	 */
	public static Map<String, Integer> wordCounterMethod(InputStream in) {
        BufferedReader br = null;
        String words[] = null;
        String line;
        Map<String, Integer> wordCount = new HashMap<String, Integer>();     //Creates an Hash Map for storing the words and its count
        try {
        	br = new BufferedReader(new InputStreamReader(in));      //creates an Buffered Reader to read the contents of the file
            
        	while ((line = br.readLine()) != null) {
                words = line.toLowerCase().split("\\s+");                      //Splits the words with "space" as an delimeter 
            }
            br.close();
            
            for (String read : words) {
                Integer freq = wordCount.get(read);
                wordCount.put(read, (freq == null) ? 1 : freq + 1); //For Each word the count will be incremented in the Hashmap
            }
        } catch (NullPointerException | IOException e) {
            System.out.println("I could'nt read your files:" + e);
        }
            
        System.out.println(wordCount.size() + " distinct words:");     //Prints the Number of Distinct words found in the files read
        System.out.println(wordCount);                                 //Prints the Word and its occurrence
        
        return wordCount;
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 */
	public static Map<String, Integer> wordCounterForVector(Vector<String> vector) {
        ArrayList<String> words = new ArrayList<String>();
        Map<String, Integer> wordCount = new HashMap<String, Integer>();     //Creates an Hash Map for storing the words and its count
        try {
        	
            for(String vectorElement:vector){
            	words.add(vectorElement.toLowerCase());                      //Splits the words with "space" as an delimeter
            }
            
            for (String read : words) {
                Integer freq = wordCount.get(read);
                wordCount.put(read, (freq == null) ? 1 : freq + 1); //For Each word the count will be incremented in the Hashmap
            }
        } catch (NullPointerException e) {
            System.out.println("I could'nt read your files:" + e);
        }
            
//        System.out.println(wordCount.size() + " distinct words:");     //Prints the Number of Distinct words found in the files read
//        System.out.println(wordCount);                                 //Prints the Word and its occurrence
        
        return wordCount;
	}
	
	/**
	 * Devuelve un Set<String> compuesto por los términos 
	 * que aparecen en el archivo txt pasado como parámetro
	 * 
	 * @param file
	 * @return
	 */
	public static Set<String> fileToSet(Scanner file){
		Set<String> doc = new HashSet<>();
		while (file.hasNext()) {
		    doc.add(file.next().trim().toLowerCase());
		}
		
		return doc;
	}
	
	/**
	 * 
	 * @param file
	 * @return
	 */
	public static Vector<String> fileToVector(InputStream file){
		
		String word = "";
		try {
			word = IOUtils.toString(file,"ISO-8859-1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al leer el fichero:" + e.getMessage());
		}
		
		
		Vector<String> doc = new Vector<>();
		word = word.trim().toLowerCase();
		word = word.replace("(", "");
		word = word.replace(")", "");
		word = word.replace(",", "");
		word = word.replace(".", "");
		word = word.replace(":", "");
		word = word.replace("'", "");
		word = word.replace("\"", "");
		word = word.replace("-", "");
		word = word.replace("=", "");
		word = word.replace("á", "a");
		word = word.replace("é", "e");
		word = word.replace("í", "i");
		word = word.replace("ó", "o");
		word = word.replace("ú", "u");
		word = word.replace("ñ", "n");
		word = word.replace("{", "");
		word = word.replace("}", "");
		word = word.replace("¿", "");
		word = word.replace("?", "");
		word = word.replace("\n", " ");
		word = word.replace("\r", "");
		String[] tokens = word.split(" ");
		for(String w1 : tokens){
			
			if(!w1.equals("") && !w1.equals(" ") && !w1.contains(" "))
				doc.add(w1);
		}
		return doc;
	}
	
	public static Map<String, Integer> docAsVectorToMap(String path)
	{
		//Scanner scan = new Scanner(StopWords.class.getResourceAsStream(path));
		InputStream fileIs = StopWords.class.getResourceAsStream(path);
		if(fileIs == null){
			try {
				fileIs = new FileInputStream(new File(path));
			} catch (FileNotFoundException e) {
				System.out.println("Error: Fichero no encontrado");
			}
		}
		String[] stop_words_vector = StopWords.stop_words;
		
		Set<String> stop_words_set = new HashSet<>();
		for(String stop_word:stop_words_vector){
			stop_words_set.add(stop_word.toLowerCase());
		}
				
		// Vector que contiene todos los términos de un documento
		Vector<String> docToCategorize = fileToVector(fileIs);
		// Eliminamos las stop_words del documento
		docToCategorize.removeAll(stop_words_set);
		
		// 2.2) asignar peso a cada término (# apariciones)
		// Calculamos los pesos de cada palabra de la noticia
		Map<String, Integer> docWithWeights = wordCounterForVector(docToCategorize);
		
		return docWithWeights;
	}
	
	public static void news_categorization(String package_path){
		
		Map<String, Integer> glossWithWeights = new HashMap<String,Integer>();
		Map<String, Double> resultados = new HashMap<String,Double>();
		int limit = 15;
		if(package_path.endsWith(".txt")){
			limit = 1;
		}
		double similaridad = 0.0;
		String tipoGlosario = "";
		
		Map.Entry<String, Double> maxEntry = null;
		
		for(int counter = 1; counter<=limit;counter++){
			//2.1) eliminar las stop_words del documento
			//Obtenemos el documento que queremos categorizar
			String pathToFile = package_path;
			if(limit > 1){
				pathToFile = pathToFile.concat(counter+".txt");
			}
			Map<String, Integer> docWithWeights = docAsVectorToMap(pathToFile);
			
			for(int i=1; i<4; i++){
				glossWithWeights = docAsVectorToMap("/clippings/glosario_"+i+".txt");
				similaridad = cosine_similarity(docWithWeights, glossWithWeights);
				switch(i){
					case 1: 
						tipoGlosario="DEPORTES";
						break;
					case 2:
						tipoGlosario="ECONOMÍA";
						break;
					case 3: 
						tipoGlosario="POLÍTICA";
						break;
					
				}
				resultados.put(tipoGlosario, similaridad);
				
				System.out.println("Similaridad de noticia "+package_path+counter+".txt con glosario de "+tipoGlosario+" = "+String.format("%.2f",similaridad*100)+" %");
			}
			for (Entry<String, Double> resultado : resultados.entrySet())
			{
			    if (maxEntry == null || resultado.getValue().compareTo(maxEntry.getValue()) > 0)
			    {
			        maxEntry = resultado;
			    }
			}
			System.out.println("\nLa noticia "+package_path+counter+".txt, es de categoría "+maxEntry.getKey()+", con un "+String.format("%.2f",maxEntry.getValue()*100)+" %\n");
		}
	}
}
