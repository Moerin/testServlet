/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.urlshortener.dao.node;

import fr.urlshortener.dao.DAO;
import fr.urlshortener.database.ConnectNeo4j;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.index.IndexHits;

/**
 *
 * @author Seb
 */
public class NodeDAO extends DAO<NodeDAO>{

    
    
    public NodeDAO(ConnectNeo4j conn){
        super(conn);
        // TODO : tester si cette initialisation de connection fonctionne
    }    
    
    @Override
    public NodeDAO findID(long id) {
        String requete = null;
        
        // Debut de la transaction
        Transaction tx = graphDb.beginTx();
            try {
                Node node = graphDb.getNodeById(id);
                // TODO trouver un moyen de trouver la clef
                requete = String.valueOf(node.getProperty(key));
                // Signale que la transaction a reussi
                tx.success();
            } catch (Exception e) {
                // TODO : remplacer par des logs et slf4j
                // Signale que la transaction a ete un echec
                tx.failure(); // A VERIFIER SI CETTE LIGNE DE CODE EST UTILE
            } finally {
                // Cloture la transaction
                tx.finish();
            }
            // TODO : creer un bean pour le node
        return requete;
    }

    @Override
    public NodeDAO findValue(String property){
    long requete = -1; 
        
        // Debut de la transaction
        Transaction tx = graphDb.beginTx();

            // C'est une chaine
            try {
                IndexHits<Node> hits = nodeIndex.get(key, property);
                Node node = hits.getSingle();
                requete = node.getId();
                // Signale que la transaction a reussi
                tx.success();
            } catch (Exception e) {
                // Signale que la transaction a été un echec
                System.err.println("Raté"); // TODO : remplacer par des logs et slf4j
                tx.failure(); // A VERIFIER SI CETTE LIGNE DE CODE EST UTILE
            } finally {
                // Cloture la transaction
                tx.finish();
            }
            // TODO : creer un bean pour le node
            return requete;
    
    }
    
    @Override
    public NodeDAO create(NodeDAO obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    // TODO : remplir la methode de creation
    }

    @Override
    public NodeDAO update(NodeDAO obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    // TODO : remplir la methode de update
    }

    @Override
    public void delete(NodeDAO obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    // TODO : remplir la methode de suppression
    }
    
}
