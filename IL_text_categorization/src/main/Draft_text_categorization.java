package main;

/* Copyright 2015 Diego Martin,Javier Montero 
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
	static double cosine_similarity_2(Map<String, Double> v1, Map<String, Double> v2) {
		Set<String> both = new HashSet<String>(v1.keySet());
		both.removeAll(v2.keySet());

		double sclar = 0, norm1 = 0, norm2 = 0;

		/*
		 * We need to perform cosine similarity only on words that exist in both
		 * lists
		 */
		for (String k : both) {
			sclar += v1.get(k) * v2.get(k);
			norm1 += v1.get(k) * v1.get(k);
			norm2 += v2.get(k) * v2.get(k);
		}
		return sclar / Math.sqrt(norm1 * norm2);
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
        //System.out.println(wordCount);                                 //Prints the Word and its occurrence
        
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
            
        //System.out.println(wordCount.size() + " distinct words:");     //Prints the Number of Distinct words found in the files read
        //System.out.println(wordCount);                                 //Prints the Word and its occurrence
        
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
	public static Vector<String> fileToVector(String words){
		String[] wordsSplit = words.split(" ");
		Vector<String> doc = new Vector<>();
		for(String oneWord : wordsSplit){
			doc.add(oneWord.trim().toLowerCase());
		}
		return doc;
	}
	
	public static Map<String, Integer> docToMap(InputStream inputStream)
	{
		//InputStream fileIs = StopWords.class.getResourceAsStream("/clippings/test.txt");
		
		String[] stop_words_vector = StopWords.stop_words;
		
		Set<String> stop_words_set = new HashSet<>();
		for(String stop_word:stop_words_vector){
			stop_words_set.add(stop_word.toLowerCase());
		}
		
		// Vetor que contiene todos los términos de un documento
		String wordsOfDocument = "";
		try {
			wordsOfDocument = IOUtils.toString(inputStream,"ISO-8859-1");
			wordsOfDocument= wordsOfDocument.replace(".", "");
			wordsOfDocument= wordsOfDocument.replace(",", "");
			wordsOfDocument= wordsOfDocument.replace("=", "");
			wordsOfDocument= wordsOfDocument.replace("-", " ");
			wordsOfDocument= wordsOfDocument.replace("\"", "");
			wordsOfDocument= wordsOfDocument.replace("'", "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Vector<String> docToCategorize = fileToVector(wordsOfDocument);
		// Eliminamos las stop_words del documento
		docToCategorize.removeAll(stop_words_set);
		
		// 2.2) asignar peso a cada término (# apariciones)
		// Calculamos los pesos de cada palabra de la noticia
		Map<String, Integer> docWithWeights = wordCounterForVector(docToCategorize);
		
		return docWithWeights;
	}

}
