package com.interview.processor;

import java.util.ArrayList;
import java.util.List;

public class WordExtractorUtil {

	public List<String> extractWordX2Y(Character[][] wordMatrix,int xpos,int ypos){
		List<String> wordList = new ArrayList<String>();
		for ( int i = xpos ; i <wordMatrix.length;i++){
			for( int j = ypos ; j <wordMatrix[i].length;j++){
				String f = makeStringY(wordMatrix,i,ypos,j);
				wordList.add(f.toString());
				for(int l=i+1;l<wordMatrix.length;l++){
					StringBuffer g = new StringBuffer(f);
					String temp = makeStringX(wordMatrix,j,xpos+1,wordMatrix.length);
					if(temp.length()>0){
						if(!temp.equals(f)){
							wordList.add(g.toString());

						}
					}
				}
			}
		}
		return wordList;
	}

	public List<String> extractWordY2X(Character[][] wordMatrix,int xpos,int ypos){
		List<String> wordList = new ArrayList<String>();
		for ( int i = xpos ; i <wordMatrix.length;i++){
			for( int j = ypos ; j <wordMatrix[i].length;j++){
				String f = makeStringY(wordMatrix,i,ypos,j);
				wordList.add(f.toString());
				for(int l=i;l>=0;l--){
					String temp = makeStringXReverse(wordMatrix,j,i,l);
					if(temp.length()>0){
						if(!f.equals(temp)){					
							wordList.add(f+temp);
						}
					}
				}
			}
		}
		return wordList;
	}


	private  String makeStringY(Character[][] array,int x, int yStart,int yEnd){
		StringBuffer bf = new StringBuffer();
		for (int counter = yStart; counter<=yEnd ; counter++){
			bf.append(array[x][counter]);
		}
		return bf.toString();

	}

	private  String makeStringX(Character[][] array,int y, int xStart,int xEnd){
		StringBuffer bf = new StringBuffer();
		for (int counter = xStart; counter<xEnd ; counter++){
			bf.append(array[counter][y]);
		}
		return bf.toString();

	}

	static private  String makeStringXReverse(Character[][] array,int y, int xStart,int xEnd){
		StringBuffer bf = new StringBuffer();
		for (int counter = xStart-1; counter>=xEnd ; counter--){
			bf.append(array[counter][y]);
		}
		return bf.toString();

	}


}
