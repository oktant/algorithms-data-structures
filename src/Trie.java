package com.azerfon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oalizada on 12/19/2016.
 */
public class Trie {
    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endofWord;

        public TrieNode() {
            children = new HashMap<>();
            endofWord = false;

        }
    }

    private final TrieNode root;
    public Trie(){
        root=new TrieNode();
    }

    public void insert(String word){
        TrieNode current=root;
        for(int i=0; i<word.length();i++){
            char ch=word.charAt(i);
            TrieNode node=current.children.get(ch);
            if(node==null){
                node=new TrieNode();
                current.children.put(ch,node);

            }
            current=node;
        }
        current.endofWord=true;


    }


    public void insertRec(String word){
        insertHelper(word, root,0);
    }

    public void insertHelper(String word, TrieNode root, int index){
        if(index==word.length()){
            root.endofWord=true;
            return;
        }
        char ch=word.charAt(index);
        TrieNode node=root.children.get(ch);
        if(node==null){
            node=new TrieNode();
            node.children.put(ch, node);

        }
        insertHelper(word, node, index+1);


    }
    public boolean search(String word){
        TrieNode current=root;
        for(int i=0; i<word.length(); i++)
        {
            char ch=word.charAt(i);
            TrieNode node=current.children.get(ch);
            if(node==null){
                return false;
            }
            current=node;

        }
        return current.endofWord;
    }
    public boolean searchRecursive(String word){
      return  searchRecursiveHelper(word, root, 0);
    }
    public boolean searchRecursiveHelper(String word, TrieNode current, int index){

        if(index==word.length() ){
            return current.endofWord;
        }
        char ch=word.charAt(index);
        TrieNode node=current.children.get(ch);
        if(node==null){
            return false;
        }
        current=node;
       return searchRecursiveHelper(word, current, index+1);
    }

    public boolean delete(String toDelete){
       return deleteHelper(root, toDelete, 0);
    }
    public boolean deleteHelper(TrieNode current, String word, int index){
        if(index==word.length()){
            if(!current.endofWord){
                return false;
            }
            current.endofWord=false;
            return current.children.size()==0;

        }
        char ch=word.charAt(index);
        TrieNode node=current.children.get(ch);
        if(node==null){
            return false;
        }

        boolean shouldBeDeleted=deleteHelper(node, word, index+1);

        if(shouldBeDeleted){
            current.children.remove(ch);
            return current.children.size()==0;
        }
        return false;
    }

}
