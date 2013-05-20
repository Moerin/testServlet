/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.urlshortener.dao;

import fr.urlshortener.database.ConnectNeo4j;

/**
 *
 * @author Seb
 */
public abstract class DAO<T> {
    
    // TODO : se renseigner le chemin relatif sur un serveur JEE
    protected ConnectNeo4j connect;
    // TODO : trouver une moyen d'appeler une instance de Neo4j
    public DAO(ConnectNeo4j conn){
        this.connect = conn;
    }
    
	/**
	 * Permet de récupérer un objet via son ID
	 * @param id
	 * @return
	 */
	public abstract T findID(long id);
        
        /**
         * Permet de récupérer un objet via sa propriete
         * @param property
         * @return 
         */
        public abstract T findValue(String property);
	
	/**
	 * Permet de créer une entrée dans la base de données
	 * par rapport à un objet
	 * @param obj
	 */
	public abstract T create(T obj);
	
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 * @param obj
	 */
	public abstract T update(T obj);
	
	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj
	 */
	public abstract void delete(T obj);
}
    
